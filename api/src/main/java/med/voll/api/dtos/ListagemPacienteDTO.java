package med.voll.api.dtos;

import med.voll.api.models.Paciente;

public record ListagemPacienteDTO (String nome, String email, String cpf) {

    public ListagemPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
