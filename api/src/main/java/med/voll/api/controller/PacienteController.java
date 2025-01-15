package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.*;
import med.voll.api.models.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid CadastrarPacienteDTO pacienteDTO) {
        System.out.println(pacienteRepository.save(new Paciente(pacienteDTO)));
    }

    @GetMapping
    public Page<ListagemPacienteDTO> listarPacientes (@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return pacienteRepository.findAllByAtivoTrue(pageable).map(ListagemPacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void editarPaciente(@RequestBody @Valid AtualizarPacienteDTO atualizarPacienteDTO) {
        var paciente = pacienteRepository.getReferenceById(atualizarPacienteDTO.id());
        paciente.atualizarInformacoes(atualizarPacienteDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public void excluirPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluirPaciente();
    }

}
