package spring.designpatterns.dom.decorator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.designpatterns.dom.decorator.entity.LanFile;

@Repository
public interface LanFileRepository extends JpaRepository<LanFile, Long> {
}
