package br.com.iago.cadastroPessoa.model.page;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paginated<T> {

	private List<T> content;
	private Long count;
	private Integer pageSize;
	private Integer pageNumber;
	private Sort sort;
	
	public Paginated() {
		this.pageSize = 10;
		this.pageNumber = 0;
    }

    public Paginated(List<T> content, Long count, Integer pageNumber, Integer pageSize, String active, String direction) {
    	this.content = content;
        this.count = count;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = new Sort(direction, active);
    }

    public Paginated(List<T> content, Long count, Integer pageNumber, Integer pageSize, Sort sort) {
    	this.content = content;
        this.count = count;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = sort;
    }


    public Paginated(List<T> content, Long count, Integer pageNumber, Integer pageSize) {
    	this.content = content;
    	this.count = count;
    	this.pageNumber = pageNumber;
    	this.pageSize = pageSize;
    }

    public Paginated(Integer pageSize, Integer pageNumber) {
    	this.pageSize = pageSize;
    	this.pageNumber = pageNumber;
    }

    public int getOffSet() {
        return (pageNumber * pageSize);
    }

}
