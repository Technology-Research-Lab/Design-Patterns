package spring.designpatterns.dom.decorator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.designpatterns.dom.decorator.entity.LanFile;

public interface LanFileRepository extends JpaRepository<LanFile, Long> {
}
