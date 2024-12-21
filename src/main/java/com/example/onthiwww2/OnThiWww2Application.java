package com.example.onthiwww2;

import com.example.onthiwww2.backend.enums.Roles;
import com.example.onthiwww2.backend.models.Candidate;
import com.example.onthiwww2.backend.models.Experience;
import com.example.onthiwww2.backend.repositories.CandidateRepository;
import com.example.onthiwww2.backend.repositories.ExperienceRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OnThiWww2Application implements CommandLineRunner {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ExperienceRepository experienceRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnThiWww2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Faker faker = new Faker();
//        for(int i = 0; i < 3; i++){
//            Candidate can = new Candidate();
//            can.setEmail(faker.internet().emailAddress());
//            can.setPhone(faker.phoneNumber().cellPhone());
//            can.setFullName(faker.name().fullName());
//            candidateRepository.save(can);
//
//            for(int j = 0; j < 3; j++){
//                Experience experience = new Experience();
//                experience.setCandidate(can);
//                experience.setRoles(Roles.STAFF);
//                experience.setCompanyName(faker.company().name());
//                LocalDate from = faker.date().birthdayLocalDate();
//                experience.setFromDate(from);
//                experience.setToDate(from.plusMonths(faker.number().numberBetween(12, 100)));
//                experienceRepository.save(experience);
//            }
//        }
    }
}
