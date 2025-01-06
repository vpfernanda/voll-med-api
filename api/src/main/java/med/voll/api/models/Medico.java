package med.voll.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.MedicoDTO;
import med.voll.api.enums.Especialidade;

@Table(name="medico")
@Entity
@Data
@NoArgsConstructor
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

    public Medico (MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.telefone = medicoDTO.telefone();
        this.email = medicoDTO.email();
        this.crm = medicoDTO.crm();
        this.endereco = new Endereco(medicoDTO.endereco());
        this.especialidade = medicoDTO.especialidade();
    }
}
