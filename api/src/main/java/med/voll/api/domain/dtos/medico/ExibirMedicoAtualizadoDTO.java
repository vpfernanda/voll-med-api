package med.voll.api.domain.dtos.medico;

import med.voll.api.domain.enums.Especialidade;
import med.voll.api.domain.models.Endereco;
import med.voll.api.domain.models.Medico;

public record ExibirMedicoAtualizadoDTO(Long id, String nome, String telefone, String email, String crm,
                                        Especialidade especialidade, Endereco endereco) {

    public ExibirMedicoAtualizadoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(),
                medico.getEspecialidade(), medico.getEndereco());
    }
}
