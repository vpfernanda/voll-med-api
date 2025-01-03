package med.voll.api.dtos;

import med.voll.api.enums.Especialidade;

public record MedicoDTO(String nome, String email, String telefone,
                        String crm, Especialidade especialidade, EnderecoDTO endereco) {
}
