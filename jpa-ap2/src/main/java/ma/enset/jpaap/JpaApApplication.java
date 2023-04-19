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
        CommandLineRunner start(PatientRepository patientRepository){
            return args -> {
                patientRepository.save(new Patient(null,"Mohamed",new Date(),false,50));
                patientRepository.save(new Patient(null,"Youssef",new Date(),true,788));
                patientRepository.save(new Patient(null,"Sara",new Date(),true,154));
                patientRepository.save(new Patient(null,"Said",new Date(),false,255));
                patientRepository.save(new Patient(null,"Said",new Date(),false,255));
                patientRepository.save(new Patient(null,"Mohamed",new Date(),false,50));
                patientRepository.save(new Patient(null,"Youssef",new Date(),true,788));
                patientRepository.save(new Patient(null,"Sara",new Date(),true,154));
                patientRepository.save(new Patient(null,"Said",new Date(),false,255));
                patientRepository.save(new Patient(null,"Said",new Date(),false,255));
                patientRepository.save(new Patient(null,"Mohamed",new Date(),false,50));
                patientRepository.save(new Patient(null,"Youssef",new Date(),true,788));
                patientRepository.save(new Patient(null,"Sara",new Date(),true,154));
                patientRepository.save(new Patient(null,"Said",new Date(),false,255));
                patientRepository.save(new Patient(null,"Said",new Date(),false,255));
            };
        }
    }