
package com.sebastianContreras.Curriculumbackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author root
 */
@Getter  @Setter
@Entity
@Builder
@ToString
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String fullname;
    @Column(unique = true)
    private String email;
    private String password;
    private String aboutMe;
    private String shortEducation;
    private String image;
    private String portraitImage;
    
    public User() {
    }

    
    public User(String fullname, String email, String password) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public User(int id, String fullname, String email, String password, String aboutMe, String shortEducation, String image, String portraitImage) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.aboutMe = aboutMe;
        this.shortEducation = shortEducation;
        this.image = image;
        this.portraitImage = portraitImage;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("User"));
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
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
    
    
}
