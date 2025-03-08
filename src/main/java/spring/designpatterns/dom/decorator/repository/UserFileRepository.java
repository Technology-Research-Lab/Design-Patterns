package spring.designpatterns.dom.decorator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.designpatterns.dom.decorator.entity.User_File;

public interface UserFileRepository extends JpaRepository<User_File,Long> {
}
