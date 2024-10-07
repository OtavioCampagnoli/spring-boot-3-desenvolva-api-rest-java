package med.voll.api.medico;

public record DadosDaListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
	
	public DadosDaListagemMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
