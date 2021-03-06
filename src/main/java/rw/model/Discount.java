package rw.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="discount")
public class Discount {
	
	private static final String MESSAGE_NAME_NOTBLANK = "Name must not be blank";
	private static final String MESSAGE_PERCENT_BETWEEN = "Number must be between 0 and 100";
	
	@Id
	@GeneratedValue
	@Column(name = "discount_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name")
	@NotBlank(message = MESSAGE_NAME_NOTBLANK)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@Column(name = "percent", columnDefinition = "int default 0")	
	@Range(min = 0, max = 100, message = MESSAGE_PERCENT_BETWEEN)
	private Integer percent;

	@OneToOne(mappedBy = "discount", cascade = CascadeType.ALL) 
	private Detail detail;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "discount")
	@OrderBy("id")
	private Set<DiscCode> discCodes;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getPercent() {
		return percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Set<DiscCode> getDiscCodes() {
		return discCodes;
	}

	public void setDiscCodes(Set<DiscCode> discCodes) {
		this.discCodes = discCodes;
	}

}
