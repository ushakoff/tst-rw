package rw.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "login", unique=true)
	@NotBlank(message = "Login must not be blank")
	@Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Login must contain only letters and numbers")
	@Size(max=40, message = "Login is too long (maximum is 40 characters)")
	private String login;
	
	
	@Column(name = "password")
	@NotBlank(message = "Password must not be blank")
	@Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Password must contain only letters and numbers")
	@Size(min = 3, max = 40, message = "Password must be between 3 and 40 characters long")
	private String password;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL) 
	private Profile profile;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="user_to_role",
    		joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},  
    		inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")}) 
	private Role role;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "user")
	private Set<DiscCode> discCodes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<DiscCode> getDiscCodes() {
		return discCodes;
	}

	public void setDiscCodes(Set<DiscCode> discCodes) {
		this.discCodes = discCodes;
	}

}
