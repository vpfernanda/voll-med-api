package med.voll.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.PacienteDTO;

@Entity
@Table(name="paciente")
@Data
public class Paciente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String telefone;
    private String email;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.telefone = pacienteDTO.telefone();
        this.email = pacienteDTO.email();
        this.cpf = pacienteDTO.cpf();
        this.endereco = new Endereco(pacienteDTO.endereco());
    }

    public Paciente(){}
}
