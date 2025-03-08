package spring.designpatterns.dom.decorator.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_file")
@NoArgsConstructor
public class User_File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_file_id")
    private Long userFileId;
    private Long userId;
    private Long fileId;

    @Builder
    public User_File(Long fileId, Long userId) {
        this.fileId = fileId;
        this.userId = userId;
    }
}
