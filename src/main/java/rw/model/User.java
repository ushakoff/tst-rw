package rw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "login", unique=true)
	@Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Type only letters and numbers, please.")
	@Size(min=1, max=40, message = "Login must be at least 1 character.")
	private String login;
	
	@Column(name = "password")
	@Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Type only letters and numbers, please.")
	@Size(min = 3, max = 40, message = "Password must be at least 3 characters.")
	private String password;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL) 
	private Profile profile;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="user_to_role",
    		joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},  
    		inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")}) 
	private Role role;
	
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

}
