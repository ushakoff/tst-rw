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
	
	private static final String MESSAGE_CODE_NOTBLANK = "Code must not be blank";
	
	@Id
	@GeneratedValue
	@Column(name = "code_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "code")
	@NotBlank(message = MESSAGE_CODE_NOTBLANK)
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "discount_id", nullable = false)
	private Discount discount;
	
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
