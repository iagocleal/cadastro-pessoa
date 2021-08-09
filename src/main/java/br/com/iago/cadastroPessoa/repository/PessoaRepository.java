package br.com.iago.cadastroPessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iago.cadastroPessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaCustomizedRepository {

	Pessoa findByCpf(String cpf);
	
}
