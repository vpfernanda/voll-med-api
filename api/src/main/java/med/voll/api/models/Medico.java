package med.voll.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import med.voll.api.dtos.CadastrarMedicoDTO;
import med.voll.api.enums.Especialidade;

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

    public Medico (CadastrarMedicoDTO cadastrarMedicoDTO) {
        this.nome = cadastrarMedicoDTO.nome();
        this.telefone = cadastrarMedicoDTO.telefone();
        this.email = cadastrarMedicoDTO.email();
        this.crm = cadastrarMedicoDTO.crm();
        this.endereco = new Endereco(cadastrarMedicoDTO.endereco());
        this.especialidade = cadastrarMedicoDTO.especialidade();
    }

    public Medico (){}

}
