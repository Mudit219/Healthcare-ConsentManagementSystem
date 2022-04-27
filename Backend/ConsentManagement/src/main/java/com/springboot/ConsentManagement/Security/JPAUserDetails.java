package com.springboot.ConsentManagement.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

// UserDetails object is required by UserDetails service. It contains the username, password and all authorities assigned to a user.
public class JPAUserDetails implements UserDetails {

    private String username;
    private String password;

    private Set<? extends GrantedAuthority> Authorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public JPAUserDetails(String username,
                          String password,
                          Set<? extends GrantedAuthority> authorities,
                          boolean isAccountNonExpired,
                          boolean isAccountNonLocked,
                          boolean isCredentialsNonExpired,
                          boolean isEnabled) {
        this.username = username;
        this.password = password;
        Authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.Authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
