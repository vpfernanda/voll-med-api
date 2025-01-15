package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.ListagemMedicoDTO;
import med.voll.api.dtos.ListagemPacienteDTO;
import med.voll.api.dtos.PacienteDTO;
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
    public void cadastrarPaciente(@RequestBody @Valid PacienteDTO pacienteDTO) {
        System.out.println(pacienteRepository.save(new Paciente(pacienteDTO)));
    }

    @GetMapping
    public Page<ListagemPacienteDTO> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(ListagemPacienteDTO::new);
    }


}
