package br.com.iago.cadastroPessoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.iago.cadastroPessoa.dto.PessoaDTO;
import br.com.iago.cadastroPessoa.model.Pessoa;
import br.com.iago.cadastroPessoa.model.page.Paginated;
import br.com.iago.cadastroPessoa.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
	
	public Pessoa update(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
	
	public Paginated<Pessoa> getAllPageableByFilter(PessoaDTO pessoaDto, Paginated<Pessoa> paginated) {
		return pessoaRepository.getAllPageableByFilter(pessoaDto, paginated);
	}

	public Pessoa getByCpf(String cpf) {
		return pessoaRepository.findByCpf(cpf);
	}
	
	public Pessoa getById(Long id) {
		return pessoaRepository.findById(id).get();
	}

}
