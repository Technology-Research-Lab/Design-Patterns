package spring.designpatterns.dom.decorator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.designpatterns.dom.decorator.entity.User_File;

import java.util.List;

@Repository
public interface UserFileRepository extends JpaRepository<User_File,Long> {
    List<User_File> findByUserId(Long userId);
}
