package med.voll.api.domain.dtos.medico;

import med.voll.api.domain.enums.Especialidade;
import med.voll.api.domain.models.Medico;

public record ListagemMedicoDTO (Long id, String nome, String crm, Especialidade especialidade, String email) {

    public ListagemMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEmail());
    }

}
