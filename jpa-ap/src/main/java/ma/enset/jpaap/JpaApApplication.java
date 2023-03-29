package ma.enset.jpaap;
import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.Date;
import java.util.List;
@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------------------------------------------------------------------------");
        //initilize datas
        patientRepository.save(new Patient(null,"Hassan",new Date(), false,56));
        patientRepository.save(new Patient(null,"Mohamed",new Date(), true,100));
        patientRepository.save(new Patient(null,"Imane",new Date(), false,210));
        Page<Patient> patient = patientRepository.findAll(PageRequest.of(0, 5));
        System.out.println("Total pages = " + patient.getTotalPages());
        System.out.println("Total elements = " + patient.getTotalElements());
        System.out.println("Numéro de la page = " + patient.getNumber());
        System.out.println();
        System.out.println();
        // get all Patient data
        List<Patient> patients = patientRepository.findAll();
        // displaying data
        for (Patient p : patients) {
            System.out.print(" "+p.getNom());
            System.out.print(" "+p.getDateNaissance());
            System.out.print(" "+p.isMalade());
            System.out.print(" "+p.getScore());
            System.out.println();
            System.out.println();
            System.out.println("###########################");
        }
        Patient pat = patientRepository.findById(1L).orElse(null);
        if (pat !=null){
            System.out.println(pat.getNom());
            System.out.println(pat.isMalade());
        }
        System.out.println();

        // get Patient Malade = False
        List<Patient> byMalade = patientRepository.findByMalade(false);
        System.out.println("------ Patients Non Malades ------");
        for (Patient p : byMalade) {

            System.out.print(" "+p.getNom());
            System.out.print(" "+p.getDateNaissance());
            System.out.print(" "+p.isMalade());
            System.out.print(" "+p.getScore());
            System.out.println();
            System.out.println();
            System.out.println("###########################");

        }

        System.out.println();
        // get Patient Malade = true
        byMalade = patientRepository.findByMalade(true);
        System.out.println("------ Patients Malades ------");
        for (Patient p : byMalade) {
            System.out.print(" "+p.getNom());
            System.out.print(" "+p.getDateNaissance());
            System.out.print(" "+p.isMalade());
            System.out.print(" "+p.getScore());
            System.out.println();
            System.out.println();
            System.out.println("###########################");
        }

        System.out.println();
        // Using @QUERY
        List<Patient> byDate = patientRepository.FindPatients(new Date(2023,3,1),new Date(2023,8,1),"Hassan");
        System.out.println("------ Patients between dates ------");
        for (Patient p : byDate) {
            System.out.print(" "+p.getNom());
            System.out.print(" "+p.getDateNaissance());
            System.out.print(" "+p.isMalade());
            System.out.print(" "+p.getScore());
            System.out.println();
            System.out.println();
            System.out.println("###########################");
        }


        }

    }
