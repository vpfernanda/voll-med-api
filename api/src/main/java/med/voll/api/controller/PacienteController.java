package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.*;
import med.voll.api.models.Paciente;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CadastrarPacienteDTO> cadastrarPaciente(@RequestBody @Valid CadastrarPacienteDTO pacienteDTO, UriComponentsBuilder uriBuilder) {
        Paciente pacienteSaved = pacienteRepository.save(new Paciente(pacienteDTO));
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(pacienteSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(new CadastrarPacienteDTO(pacienteSaved));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemPacienteDTO>> listarPacientes (@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = pacienteRepository.findAllByAtivoTrue(pageable).map(ListagemPacienteDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ListagemPacienteDTO> buscarPaciente (@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()) {
            var pacienteFound = new ListagemPacienteDTO(paciente.get());
            return ResponseEntity.ok(pacienteFound);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ExibirPacienteAtualizadoDTO> editarPaciente(@RequestBody @Valid AtualizarPacienteDTO atualizarPacienteDTO) {
        var paciente = pacienteRepository.getReferenceById(atualizarPacienteDTO.id());
        paciente.atualizarInformacoes(atualizarPacienteDTO);
        return ResponseEntity.ok(new ExibirPacienteAtualizadoDTO(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluirPaciente();
        return ResponseEntity.noContent().build();
    }

}
