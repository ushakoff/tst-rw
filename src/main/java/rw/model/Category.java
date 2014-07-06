package rw.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue	
	@Column(name = "category_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name")
	@NotBlank(message = "Name must not be blank")	
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "category")
	private Set<Discount> discounts;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}
	
}
