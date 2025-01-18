package med.voll.api.domain.dtos.paciente;

import med.voll.api.domain.models.Endereco;
import med.voll.api.domain.models.Paciente;

public record ExibirPacienteAtualizadoDTO(Long id, String nome, String email, String telefone,
                                          String cpf, Endereco endereco) {

   public ExibirPacienteAtualizadoDTO(Paciente paciente){
       this(paciente.getId(), paciente.getNome(), paciente.getEmail(),
               paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
   }
}
