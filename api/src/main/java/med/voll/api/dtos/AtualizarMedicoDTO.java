package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;

public record AtualizarMedicoDTO(@NotNull Long id,
                                 String nome, String telefone, EnderecoDTO enderecoDTO) {
}
