package ma.enset.jpaap.web;

import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "5") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String kw
    ){
        Page<Patient> pagePatients = patientRepository.findByNomContains(kw, PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "patients";
    }
    @GetMapping(path = "/delete")
    public String DeletePatient(Model model,Long id){
        patientRepository.deleteById(id);
        return "redirect:/index";
    }
    @GetMapping("/formPatient")
    public String formPatient(Model model ){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }
    @PostMapping("/save")
    public String save(@Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "redirect:/index";
        patientRepository.save(patient);
        return "redirect:/index";
    }
    @GetMapping("/editPatient")
    public String editPatient(@RequestParam(name = "id") Long id, Model model){
        Patient patient=patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        return "editPatient";
    }
}