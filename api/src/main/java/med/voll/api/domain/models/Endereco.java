package med.voll.api.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.domain.dtos.endereco.EnderecoDTO;
import med.voll.api.domain.enums.UFBr;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
    public Endereco() {
    }

    @AttributeOverrides({
            @AttributeOverride(name = "logradouro", column = @Column(name = "endereco_logradouro")),
            @AttributeOverride(name = "numero", column = @Column(name = "endereco_numero")),
            @AttributeOverride(name = "bairro", column = @Column(name = "endereco_bairro")),
            @AttributeOverride(name = "complemento", column = @Column(name="endereco_complemento")),
            @AttributeOverride(name = "cep", column = @Column(name = "endereco_cep")),
            @AttributeOverride(name="uf", column = @Column(name="endereco_uf")),
            @AttributeOverride(name="cidade", column = @Column(name="endereco_cidade"))
    })


    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;

    @Enumerated(EnumType.STRING)
    private UFBr uf;

    private String cidade;

    public Endereco (EnderecoDTO enderecoDTO) {
        this.logradouro = enderecoDTO.logradouro();
        this.numero = enderecoDTO.numero();
        this.bairro = enderecoDTO.bairro();
        this.complemento = enderecoDTO.complemento();
        this.cep = enderecoDTO.cep();
        this.uf = enderecoDTO.uf();
        this.cidade = enderecoDTO.cidade();
    }

    public void atualizarDados(EnderecoDTO enderecoDTO) {
        if(enderecoDTO.logradouro() != null) {
            this.logradouro = enderecoDTO.logradouro();
        }
        if(enderecoDTO.numero() != null) {
            this.numero = enderecoDTO.numero();
        }
        if(enderecoDTO.bairro() != null) {
            this.bairro = enderecoDTO.bairro();
        }
        if(enderecoDTO.complemento() != null) {
            this.complemento = enderecoDTO.complemento();
        }
        if(enderecoDTO.cep() != null) {
            this.cep = enderecoDTO.cep();
        }
        if(enderecoDTO.uf() != null) {
            this.uf = enderecoDTO.uf();
        }
        if(enderecoDTO.cidade() != null) {
            this.cidade = enderecoDTO.cidade();
        }
    }
}
