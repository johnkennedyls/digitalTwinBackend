package com.icesi.edu.co.pdg.dashboard.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SaamfiUserDetails implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3763248087828761783L;
	private String persId;
    private String role;
    private Integer system;
    private Integer institution;
    private String username;

    // Constructor y getters/setters omitidos para brevedad

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
    
    @Override
	public String getUsername() {
		return username;
	}

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	public String getPersId() {
		return persId;
	}

	public void setPersId(String persId) {
		this.persId = persId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getSystem() {
		return system;
	}

	public void setSystem(Integer system) {
		this.system = system;
	}

	public Integer getInstitution() {
		return institution;
	}

	public void setInstitution(Integer institution) {
		this.institution = institution;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
