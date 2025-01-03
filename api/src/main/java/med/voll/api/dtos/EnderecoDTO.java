package med.voll.api.dtos;

import med.voll.api.enums.UFBr;

public record EnderecoDTO(String logradouro, String numero, String complemento,
                          String bairro, String cidade, UFBr uf, String cep) {
    //logradouro, número, complemento, bairro, cidade, UF e CEP

}
