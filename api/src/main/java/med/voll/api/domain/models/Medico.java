package med.voll.api.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import med.voll.api.domain.dtos.medico.AtualizarMedicoDTO;
import med.voll.api.domain.dtos.medico.CadastrarMedicoDTO;
import med.voll.api.domain.enums.Especialidade;

@Table(name="medico")
@Entity
@Data
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String telefone;
    private String email;

    @Embedded
    private Endereco endereco;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private boolean ativo;

    public Medico (CadastrarMedicoDTO cadastrarMedicoDTO) {
        this.ativo = true;
        this.nome = cadastrarMedicoDTO.nome();
        this.telefone = cadastrarMedicoDTO.telefone();
        this.email = cadastrarMedicoDTO.email();
        this.crm = cadastrarMedicoDTO.crm();
        this.endereco = new Endereco(cadastrarMedicoDTO.endereco());
        this.especialidade = cadastrarMedicoDTO.especialidade();
    }

    public Medico (){}

    public void atualizarInformacoes(AtualizarMedicoDTO atualizarMedicoDTO) {
        if(atualizarMedicoDTO.nome()!=null){
            this.nome = atualizarMedicoDTO.nome();
        }
        if(atualizarMedicoDTO.telefone()!=null){
            this.telefone = atualizarMedicoDTO.telefone();
        }
        if(atualizarMedicoDTO.enderecoDTO()!=null){
            this.endereco.atualizarDados(atualizarMedicoDTO.enderecoDTO());
        }
    }

    public void excluirMedico(){
        this.ativo = false;
    }

}
