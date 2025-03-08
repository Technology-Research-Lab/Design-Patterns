package spring.designpatterns.dom.Decorator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.designpatterns.dom.Decorator.entity.File;

public interface FileRepository extends JpaRepository<File, Long> {
}
