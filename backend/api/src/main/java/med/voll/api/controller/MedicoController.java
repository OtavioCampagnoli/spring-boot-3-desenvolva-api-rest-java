package med.voll.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medico.DadosCadastroMedico;

@RestController
@RequestMapping(path = "medicos")
@CrossOrigin(origins = "*")
public class MedicoController {
	
	@PostMapping
	public void cadastrar (@RequestBody DadosCadastroMedico json) {
		System.out.println(json);
	}
}
