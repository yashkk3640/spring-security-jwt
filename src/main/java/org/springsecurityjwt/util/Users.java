package org.springsecurityjwt.util;

import org.springsecurityjwt.UserClassNameChanger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Author: ykhatri
 * Date: 28-11-2019
 */
@Entity
@Table(name = UserClassNameChanger.DEFAULT_TABLE)
@Component
class Users implements UserDetails {

    @Id
    @Column(name = UserClassNameChanger.DEFAULT_USERNAME)
    private String username;

    @Column(name = UserClassNameChanger.DEFAULT_PASSWORD)
    private String password;

    public Users(){
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isAredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
