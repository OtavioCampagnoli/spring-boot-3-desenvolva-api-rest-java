package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.paciente.DadosCadastroPaciente;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private String logradouro;

	private String bairro;

	private String cep;

	private String numero;

	private String complemento;

	private String cidade;

	private String uf;

	public Endereco(DadosCadastroMedico dados) {
		this.logradouro = dados.endereco().logradouro();
		this.bairro = dados.endereco().bairro();
		this.cep = dados.endereco().cep();
		this.numero = dados.endereco().numero();
		this.complemento = dados.endereco().complemento();
		this.cidade = dados.endereco().cidade();
		this.uf = dados.endereco().uf();
	}
	
	public Endereco(DadosCadastroPaciente dados) {
		this.logradouro = dados.endereco().logradouro();
		this.bairro = dados.endereco().bairro();
		this.cep = dados.endereco().cep();
		this.numero = dados.endereco().numero();
		this.complemento = dados.endereco().complemento();
		this.cidade = dados.endereco().cidade();
		this.uf = dados.endereco().uf();
	}

	public void atualizarInformacoes(DadosEndereco dados) {
		if (dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}
		if (dados.bairro() != null) {
			this.bairro = dados.bairro();
		}
		if (dados.cep() != null) {
			this.cep = dados.cep();
		}
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}
		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
		if (dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		if (dados.uf() != null) {
			this.uf = dados.uf();
		}
	}
}
