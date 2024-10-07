package med.voll.api.paciente;

public record DadosDaListagemPaciente(Long id, String nome, String email, String cpf) {
	
	public DadosDaListagemPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
	}
}
