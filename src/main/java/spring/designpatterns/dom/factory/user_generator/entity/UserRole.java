package spring.designpatterns.dom.factory.user_generator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role_factory")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long roleId;
}
