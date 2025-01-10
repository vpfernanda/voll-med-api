package med.voll.api.dtos;

import med.voll.api.enums.Especialidade;
import med.voll.api.models.Medico;

public record ListagemMedicoDTO (String nome, String crm, Especialidade especialidade, String email) {

    public ListagemMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEmail());
    }

}
