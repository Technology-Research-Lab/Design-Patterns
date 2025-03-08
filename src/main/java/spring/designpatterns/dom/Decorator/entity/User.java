package spring.designpatterns.dom.Decorator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String loginId;
    private String userName;
    private String password;
}
