package spring.designpatterns.dom.Decorator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    @Enumerated(EnumType.STRING)
    private Language languageType;
    private String filePath;

}
