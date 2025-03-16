package spring.designpatterns.dom.factory.user_generator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_factory")
public class User {
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
}
