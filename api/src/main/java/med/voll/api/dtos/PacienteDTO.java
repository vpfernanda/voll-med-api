package med.voll.api.dtos;

public record PacienteDTO(String nome, String telefone, String email,
                          String cpf, EnderecoDTO endereco) {
}
