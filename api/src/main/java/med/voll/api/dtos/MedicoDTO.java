package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Especialidade;
import med.voll.api.models.Medico;

public record MedicoDTO(@NotBlank
                        String nome,

                        @NotBlank @Email
                        String email,

                        @NotBlank
                        String telefone,

                        @NotBlank
                        @Pattern(regexp = "\\d{4,6}")
                        String crm,

                        @NotNull
                        Especialidade especialidade,

                        @NotNull
                        @Valid
                        EnderecoDTO endereco) {

    public MedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getTelefone(),
                medico.getCrm(), medico.getEspecialidade(), new EnderecoDTO(medico.getEndereco()));
    }

}
