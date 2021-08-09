package br.com.iago.cadastroPessoa.repository;

import br.com.iago.cadastroPessoa.dto.PessoaDTO;
import br.com.iago.cadastroPessoa.model.Pessoa;
import br.com.iago.cadastroPessoa.model.page.Paginated;

public interface PessoaCustomizedRepository {

	public Paginated<Pessoa> getAllPageableByFilter(PessoaDTO pessoaDTO, Paginated<Pessoa> paginated);
}
