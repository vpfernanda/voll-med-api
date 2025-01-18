package med.voll.api.domain.dtos.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dtos.endereco.EnderecoDTO;

public record AtualizarMedicoDTO(@NotNull Long id,
                                 String nome, String telefone, EnderecoDTO enderecoDTO) {
}
