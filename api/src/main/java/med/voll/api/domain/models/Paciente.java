package med.voll.api.domain.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import med.voll.api.domain.dtos.paciente.AtualizarPacienteDTO;
import med.voll.api.domain.dtos.paciente.CadastrarPacienteDTO;


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
