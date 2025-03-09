package spring.designpatterns.dom.decorator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user", indexes = {
        @Index(name="idx_login_id",columnList = "loginId")
})
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true, nullable = false)
    private String loginId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
}
