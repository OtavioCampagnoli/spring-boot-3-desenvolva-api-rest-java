package med.voll.api.medico;

public record DadosDaListagemMedico(String nome, String email, String crm, Especialidade especialidade) {
	
	public DadosDaListagemMedico(Medico medico) {
		this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
