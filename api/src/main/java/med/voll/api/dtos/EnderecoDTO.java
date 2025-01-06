package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.UFBr;

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
    //logradouro, número, complemento, bairro, cidade, UF e CEP

}
