package spring.designpatterns.dom.factory.user_generator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_auth_factory")
public class UserAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long authId;
}
