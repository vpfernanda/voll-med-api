package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.UFBr;
import med.voll.api.models.Endereco;

public record EnderecoDTO(
                          @NotBlank
                          String logradouro,

                          String numero,

                          String complemento,

                          @NotBlank
                          String bairro,

                          @NotBlank
                          String cidade,

                          @NotNull
                          UFBr uf,

                          @NotBlank
                          @Pattern(regexp = "\\d{8}")
                          String cep) {

    public EnderecoDTO(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(),
                endereco.getBairro(), endereco.getCidade(), endereco.getUf(),
                endereco.getCep());
    }

}
