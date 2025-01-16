package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.models.Paciente;
import org.hibernate.validator.constraints.br.CPF;

public record CadastrarPacienteDTO(@NotBlank
                          String nome,

                          @NotBlank
                          String telefone,

                          @NotBlank @Email
                          String email,

                          @NotBlank @CPF
                          String cpf,

                          @NotNull @Valid
                          EnderecoDTO endereco) {

    public CadastrarPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getTelefone(),
                paciente.getEmail(), paciente.getCpf(), new EnderecoDTO(paciente.getEndereco()) );
    }
}
