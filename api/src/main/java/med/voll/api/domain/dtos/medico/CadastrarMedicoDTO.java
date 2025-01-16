package med.voll.api.domain.dtos.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.dtos.endereco.EnderecoDTO;
import med.voll.api.domain.enums.Especialidade;
import med.voll.api.domain.models.Medico;

public record CadastrarMedicoDTO(@NotBlank
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

    public CadastrarMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getTelefone(),
                medico.getCrm(), medico.getEspecialidade(), new EnderecoDTO(medico.getEndereco()));
    }

}
