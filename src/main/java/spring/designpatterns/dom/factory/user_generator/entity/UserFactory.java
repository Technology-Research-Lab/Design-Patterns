package spring.designpatterns.dom.factory.user_generator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_factory")
public class UserFactory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String role;
    private String auth;

    public UserFactory(String username, String password, String role, String auth) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.auth = auth;
    }

}
