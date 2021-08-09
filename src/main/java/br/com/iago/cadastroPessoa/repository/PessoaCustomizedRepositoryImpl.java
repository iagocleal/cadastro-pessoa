package br.com.iago.cadastroPessoa.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.iago.cadastroPessoa.dto.PessoaDTO;
import br.com.iago.cadastroPessoa.model.Pessoa;
import br.com.iago.cadastroPessoa.model.page.Paginated;

public class PessoaCustomizedRepositoryImpl implements PessoaCustomizedRepository {

	@Autowired
	public EntityManager entityManager;
	
	@Override
	public Paginated<Pessoa> getAllPageableByFilter(PessoaDTO pessoaDTO, Paginated<Pessoa> paginated) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		String jpql = "SELECT p FROM Pessoa p ";
		
		String filtro = definirParametros(pessoaDTO, parametros);
		
		Query query = entityManager.createQuery(jpql + filtro, Pessoa.class); 
		
		parametros.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		query.setFirstResult(paginated.getOffSet());
		query.setMaxResults(paginated.getPageSize());

		List<Pessoa> pessoas = query.getResultList();
		paginated.setContent(pessoas);
		paginated.setCount(count(pessoaDTO));
		return paginated;
	}
	
	private Long count(PessoaDTO pessoaDTO) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		String jpql = "SELECT count(*) FROM Pessoa p";
		
		String filtro = definirParametros(pessoaDTO, parametros);
		
		TypedQuery<Long> query = entityManager.createQuery(jpql + filtro, Long.class); 
		
		parametros.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		return query.getSingleResult();
	}
	
	private String definirParametros(PessoaDTO filter, Map<String, Object> parametros) {
		String filtro = "";
		
		if (filter != null && filter.getNome() != null) {
			filtro += " p.nome = :nome AND ";
			parametros.put("nome", filter.getNome());
		}
		
		if (filter != null && filter.getCpf() != null) {
			filtro += " p.cpf = :cpf AND ";
			parametros.put("cpf", filter.getCpf());
		}
		
		if (filtro != null && filtro.length() > 0) {
			filtro = " WHERE " + removerUltimaClausulaAnd(filtro);
		}
		
		return filtro;
	}
	
	private String removerUltimaClausulaAnd(String filtro) {
		 return filtro.substring(0, filtro.length() - 4);
	}

}
