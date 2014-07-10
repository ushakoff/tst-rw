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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {
	
	private static final String MESSAGE_LOGIN_NOTBLANK= "Login must not be blank";
	private static final String MESSAGE_LOGIN_REGEXP = "Login must contain only latin letters and numbers";
	private static final String MESSAGE_LOGIN_LONG = "Login is too long (maximum is 40 characters)";
	private static final String MESSAGE_PASSWORD_NOTBLANK= "Password must not be blank";
	private static final String MESSAGE_PASSWORD_REGEXP = "Password must contain only latin letters and numbers";
	private static final String MESSAGE_PASSWORD_LONG = "Password must be between 3 and 40 characters long";
	
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "login", unique=true)
	@NotBlank(message = MESSAGE_LOGIN_NOTBLANK)
	@Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = MESSAGE_LOGIN_REGEXP)
	@Size(max=40, message = MESSAGE_LOGIN_LONG)
	private String login;
	
	
	@Column(name = "password")
	@NotBlank(message = MESSAGE_PASSWORD_NOTBLANK)
	@Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = MESSAGE_PASSWORD_REGEXP)
	@Size(min = 3, max = 40, message = MESSAGE_PASSWORD_LONG)
	private String password;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL) 
	private Profile profile;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="user_to_role",
    		joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},  
    		inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")}) 
	private Role role;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "user")
	@OrderBy("id")
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
