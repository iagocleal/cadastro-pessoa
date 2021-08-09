package br.com.iago.cadastroPessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.cadastroPessoa.dto.PessoaDTO;
import br.com.iago.cadastroPessoa.model.Pessoa;
import br.com.iago.cadastroPessoa.model.page.Paginated;
import br.com.iago.cadastroPessoa.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.save(pessoa), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) {		
		return new ResponseEntity<Pessoa>(pessoaService.update(pessoa), HttpStatus.OK);
	}
	
	@GetMapping(value = "/paginated")
	public ResponseEntity<Paginated<Pessoa>> getAllPageableByFilter(PessoaDTO pessoaDto, Paginated<Pessoa> paginated) {
		return new ResponseEntity<Paginated<Pessoa>>(pessoaService.getAllPageableByFilter(pessoaDto, paginated), HttpStatus.OK);
	}
	
	@GetMapping(value = "/byCpf")
	public ResponseEntity<Pessoa> getByCpf(@RequestParam(name="cpf") String cpf) {
		return new ResponseEntity<Pessoa>(pessoaService.getByCpf(cpf),  HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
		return new ResponseEntity<Pessoa>(pessoaService.getById(id),  HttpStatus.OK);
	}

}
