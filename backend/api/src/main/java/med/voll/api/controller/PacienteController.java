package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosDaListagemMedico;
import med.voll.api.paciente.DadosAtualizacaoPaciente;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosDaListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;

@RestController
@RequestMapping(path = "pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	@GetMapping
	public Page<DadosDaListagemPaciente> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosDaListagemPaciente::new);
	}
	
	@PostMapping
	@Transactional
	public void adicionar(@RequestBody @Valid DadosCadastroPaciente dados) {
	    repository.save(new Paciente(dados));
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
	    var paciente = repository.getReferenceById(dados.id());
	    paciente.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void remover(@PathVariable Long id) {
	    var paciente = repository.getReferenceById(id);
	    paciente.inativar();
	}
}
