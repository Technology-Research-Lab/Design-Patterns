package spring.designpatterns.dom.decorator.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "file")
@NoArgsConstructor
public class LanFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    private String languageType;
    private String filePath;

    @Builder
    public LanFile(String fileName, String filePath, String language) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.languageType = language;
    }

}
