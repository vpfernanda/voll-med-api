package med.voll.api.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.AtualizarPacienteDTO;
import med.voll.api.dtos.CadastrarMedicoDTO;
import med.voll.api.dtos.CadastrarPacienteDTO;


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

    private boolean ativo;

    public Paciente(CadastrarPacienteDTO pacienteDTO) {
        this.ativo = true;
        this.nome = pacienteDTO.nome();
        this.telefone = pacienteDTO.telefone();
        this.email = pacienteDTO.email();
        this.cpf = pacienteDTO.cpf();
        this.endereco = new Endereco(pacienteDTO.endereco());
    }

    public Paciente(){}

    public void atualizarInformacoes(@Valid AtualizarPacienteDTO atualizarPacienteDTO) {
        if(atualizarPacienteDTO.nome()!=null){
            this.nome = atualizarPacienteDTO.nome();
        }
        if(atualizarPacienteDTO.telefone()!=null){
            this.telefone = atualizarPacienteDTO.telefone();
        }
        if(atualizarPacienteDTO.enderecoDTO()!=null){
            this.endereco.atualizarDados(atualizarPacienteDTO.enderecoDTO());
        }
    }

    public void excluirPaciente() {
        this.ativo = false;
    }
}
