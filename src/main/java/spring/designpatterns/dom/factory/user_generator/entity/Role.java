package spring.designpatterns.dom.factory.user_generator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role_factory")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
}
