package fr.inoco.showcase.repository;


import fr.inoco.showcase.conf.aop.annotation.CalculateExecutionTime;
import fr.inoco.showcase.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDatabase {

    @Autowired
    TutorialRepository tutorialRepository;

    @PostConstruct
    @CalculateExecutionTime
    public void initDatabase(){
        tutorialRepository.save(new Tutorial("java", "Inoco", true));
        tutorialRepository.save(new Tutorial("Python", "Inoco", true));
        tutorialRepository.save(new Tutorial("C", "Inoco", false));
        tutorialRepository.save(new Tutorial("Kotlin", "Inoco", true));
    }
}
