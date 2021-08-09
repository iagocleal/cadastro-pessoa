package br.com.iago.cadastroPessoa.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.iago.cadastroPessoa.enums.custom.CustomEnumDeserializer;
import br.com.iago.cadastroPessoa.enums.custom.CustomEnumJPAConverter;
import br.com.iago.cadastroPessoa.enums.custom.IBaseEnum;
import lombok.Getter;

@Getter
@JsonDeserialize(using = CustomEnumDeserializer.class)
@JsonFormat(shape = Shape.OBJECT)
public enum SexoEnum implements IBaseEnum<SexoEnum> {

	MASCULINO(1, "MASCULINO"),
	FEMININO(2, "FEMININO");
	
	private Integer codigo;
	private String descricao;

	SexoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static class Converter extends CustomEnumJPAConverter<SexoEnum, Integer> {
		public Converter() {
			super(SexoEnum.class);
		}
	}
}