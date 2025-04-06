package spring.designpatterns.dom.factory.user_generator.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "auth_factory")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String auth;

    public Auth(String auth) {
        this.auth = auth;
    }
}
