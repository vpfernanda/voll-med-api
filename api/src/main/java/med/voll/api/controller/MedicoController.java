package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.dtos.medico.AtualizarMedicoDTO;
import med.voll.api.domain.dtos.medico.CadastrarMedicoDTO;
import med.voll.api.domain.dtos.medico.ExibirMedicoAtualizadoDTO;
import med.voll.api.domain.dtos.medico.ListagemMedicoDTO;
import med.voll.api.domain.models.Medico;
import med.voll.api.repository.MedicoRepository;
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
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CadastrarMedicoDTO> cadastrarMedico(@RequestBody @Valid CadastrarMedicoDTO medico,
                                                              UriComponentsBuilder uriBuilder) {
        Medico medicoSaved = medicoRepository.save(new Medico(medico));
        var uri = uriBuilder.path("/medico/{id}").buildAndExpand(medicoSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(new CadastrarMedicoDTO(medicoSaved));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDTO>>  listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(ListagemMedicoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemMedicoDTO> buscarMedico(@PathVariable Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isPresent()) {
            var medicoFound = new ListagemMedicoDTO(medico.get());
            return ResponseEntity.ok(medicoFound);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ExibirMedicoAtualizadoDTO> editarMedico(@RequestBody @Valid AtualizarMedicoDTO atualizarMedicoDTO) {
        var medico = medicoRepository.getReferenceById(atualizarMedicoDTO.id());
        medico.atualizarInformacoes(atualizarMedicoDTO);
        return ResponseEntity.ok(new ExibirMedicoAtualizadoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluirMedico();

        return ResponseEntity.noContent().build();

    }

}

