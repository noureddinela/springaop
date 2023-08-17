package fr.inoco.showcase.repository;

import fr.inoco.showcase.conf.aop.annotation.CalculateExecutionTime;
import fr.inoco.showcase.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  @CalculateExecutionTime
  List<Tutorial> findByPublished(boolean published);

  @CalculateExecutionTime
  List<Tutorial> findByTitleContaining(String title);
}
