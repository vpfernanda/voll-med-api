package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.AtualizarMedicoDTO;
import med.voll.api.dtos.CadastrarMedicoDTO;
import med.voll.api.dtos.ListagemMedicoDTO;
import med.voll.api.models.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid CadastrarMedicoDTO medico) {
        System.out.println(medicoRepository.save(new Medico(medico)));
    }

    @GetMapping
    public Page<ListagemMedicoDTO> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(ListagemMedicoDTO::new);
    }

    @PutMapping
    @Transactional
    public void editarMedico(@RequestBody @Valid AtualizarMedicoDTO atualizarMedicoDTO) {
        var medico = medicoRepository.getReferenceById(atualizarMedicoDTO.id());
        medico.atualizarInformacoes(atualizarMedicoDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluirMedico();
    }

}

