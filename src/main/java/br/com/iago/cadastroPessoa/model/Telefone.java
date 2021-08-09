package br.com.iago.cadastroPessoa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@JsonSerializableSchema
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TELEFONE", schema = "TESTE_IAGO")
public class Telefone implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6274453172879201035L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique=true, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "DDD")
	private String ddd;
	
	@Column(name = "NUMERO")
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name = "PESSOA_FK", referencedColumnName = "ID")
	@JsonBackReference
	private Pessoa pessoa;

}
