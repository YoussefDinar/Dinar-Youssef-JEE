package ma.enset.jpaap;

import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JpaApApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaApApplication.class, args);
    }

    @Bean

    // @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(
                    new Patient(null,"Youssef",new Date(),false,170));
            patientRepository.save(
                    new Patient(null,"Mohammed",new Date(),true,125));
            patientRepository.save(
                    new Patient(null,"Imane",new Date(),true,100));
            patientRepository.save(
                    new Patient(null,"Sara",new Date(),false,115));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
    // @Bean



}