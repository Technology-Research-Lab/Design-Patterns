package spring.designpatterns.dom.Decorator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_file")
public class User_File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_file_id")
    private Long userFileId;
    private String userId;
    private String fileId;

}
