package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.PacienteDTO;
import med.voll.api.models.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
