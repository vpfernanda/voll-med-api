package med.voll.api.domain.dtos.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dtos.endereco.EnderecoDTO;

public record AtualizarPacienteDTO(@NotNull Long id,
                                   String nome,
                                   String telefone,
                                   EnderecoDTO enderecoDTO) {
}
