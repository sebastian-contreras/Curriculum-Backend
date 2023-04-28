
package com.sebastianContreras.Curriculumbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Getter  @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullname;
    private String email;
    private String password;
    private String aboutMe;
    private String shortEducation;
    private String image;
    private String portraitImage;

    public User() {
    }

    
    public User(int id, String fullname, String email, String password) {
        this.id = id;
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
    
    
}
