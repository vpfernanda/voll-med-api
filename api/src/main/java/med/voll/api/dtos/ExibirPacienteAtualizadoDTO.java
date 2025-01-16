package med.voll.api.dtos;

import med.voll.api.models.Endereco;
import med.voll.api.models.Paciente;

public record ExibirPacienteAtualizadoDTO(Long id, String nome, String email, String telefone,
                                          String cpf, Endereco endereco) {

   public ExibirPacienteAtualizadoDTO(Paciente paciente){
       this(paciente.getId(), paciente.getNome(), paciente.getEmail(),
               paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
   }
}
