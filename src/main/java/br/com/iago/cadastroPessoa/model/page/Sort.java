package br.com.iago.cadastroPessoa.model.page;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sort {
	
	private String direction;
	private String active;
	private String aliasActive;
	
	public Sort(String direction, String active) {
		this.direction = direction;
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "ORDER BY " + aliasActive + direction;
	}
	
	public String getDirection() {
		return " ASC";
	}

}
