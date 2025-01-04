package med.voll.api.controller;

import med.voll.api.dtos.PacienteDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @PostMapping
    public void cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        System.out.println(pacienteDTO.toString());
    }

}
