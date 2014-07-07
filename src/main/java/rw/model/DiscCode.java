package rw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="codes")
public class DiscCode {
	
	@Id
	@GeneratedValue
	@Column(name = "code_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "code")
	@NotBlank(message = "Code must not be blank")
	private String code;
	
	//@Column(name = "discount_id")
	@ManyToOne
	@JoinColumn(name = "discount_id", nullable = false)
	private Discount discount;
	
	//@Column(name = "user_id")
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
