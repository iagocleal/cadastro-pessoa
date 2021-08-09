package br.com.iago.cadastroPessoa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.iago.cadastroPessoa.model.Pessoa;
import br.com.iago.cadastroPessoa.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroPessoaApplicationTests {

	@Autowired
	PessoaRepository pessoaRepository;

	@Test
	public void teste1_inserirUmaPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Iago");
		pessoa.setCpf("00000000000");
		pessoa.setEmail("iago@teste.com");
		pessoa.setDataNascimento(LocalDate.now());
		
		pessoaRepository.save(pessoa);
		
		assertTrue(pessoaRepository.existsById(1L));
		
	}
	
	@Test
	public void teste2_AlterarNomeDeUmaPessoa() {
		Pessoa pessoa = pessoaRepository.findById(1L).get();
		
		Pessoa pessoaBanco = pessoaRepository.save(pessoa);
		
		assertEquals("Iago Leal", pessoaBanco.getNome());
	}
	
	@Test
	public void teste3_consultarUmaPessoaPorId() {
		Pessoa pessoa = pessoaRepository.findById(1L).get();
		
		assertNotNull(pessoa);
	}
	
	@Test
	public void teste4_deletarUmaPessoaPorId() {
		pessoaRepository.deleteById(1L);
		
		assertFalse(pessoaRepository.existsById(1L));
	}

}
