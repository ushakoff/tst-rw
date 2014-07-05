package rw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="detail")
public class Detail {
	
	@Id  
	@Column(name = "discount_id", unique = true, nullable = false)  
	@GeneratedValue(generator = "gen")  
	@GenericGenerator(name = "gen", strategy = "foreign",
					  parameters = @Parameter(name = "property", value = "discount"))  
	private Integer id;
	
	@Column(name = "info")
	private String info;
	
	@Column(name = "site")
	private String site;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Discount discount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}
