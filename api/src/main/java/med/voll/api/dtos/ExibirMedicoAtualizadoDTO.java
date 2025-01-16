package med.voll.api.dtos;

import med.voll.api.enums.Especialidade;
import med.voll.api.models.Endereco;
import med.voll.api.models.Medico;

public record ExibirMedicoAtualizadoDTO(Long id, String nome, String email, String crm,
                                        Especialidade especialidade, Endereco endereco) {

    public ExibirMedicoAtualizadoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),
                medico.getEspecialidade(), medico.getEndereco());
    }
}
