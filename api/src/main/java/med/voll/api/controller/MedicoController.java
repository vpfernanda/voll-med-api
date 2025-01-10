package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.ListagemMedicoDTO;
import med.voll.api.dtos.MedicoDTO;
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
    public void cadastrarMedico(@RequestBody @Valid MedicoDTO medico) {
        System.out.println(medicoRepository.save(new Medico(medico)));
    }

    @GetMapping
    public Page<ListagemMedicoDTO> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAll(pageable).map(ListagemMedicoDTO::new);
//        List<ListagemMedicoDTO> medicoDTOs = new ArrayList<>();
//        for (Medico medico : medicos) {
//            medicoDTOs.add(new ListagemMedicoDTO(medico));
//        }


    }

}

