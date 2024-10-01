package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.medico.DadosCadastroMedico;

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

}
