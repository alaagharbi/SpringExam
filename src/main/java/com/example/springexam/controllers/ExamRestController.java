package com.example.springexam.controllers;

import com.example.springexam.entity.Project;
import com.example.springexam.entity.Sprint;
import com.example.springexam.entity.User;
import com.example.springexam.repository.ProjectRepository;
import com.example.springexam.repository.SprintRepository;
import com.example.springexam.repository.UserrRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("rest")
@AllArgsConstructor
public class ExamRestController {

    private final UserrRepository userRepository;
    private final ProjectRepository projectRepository;
    private final SprintRepository sprintRepository;


//
//    //http://localhost:9090/rest/add
//    @PostMapping("/add")
//    public User add(@RequestBody Contrat entity) {
//        System.out.println(entity);
//        return	contratRepository.save(entity);
//    }

    //http://localhost:9090/rest/add-Beneficiaire
    @PostMapping("/add-User")
    public User addUser(@RequestBody User entity) {
        return	userRepository.save(entity);
    }


    //http://localhost:9090/rest/add-Beneficiaire
    @PostMapping("/add-Sprint")
    public Sprint addSprint(@RequestBody Sprint entity) {
        return	sprintRepository.save(entity);
    }

    //http://localhost:9090/rest/add-Beneficiaire
    @PostMapping("/add-Project")
    public Project addProject(@RequestBody Project entity) {
        return	projectRepository.save(entity);
    }
    @GetMapping({"/affecterUtilisateurClasse/{idUtilisateur}/{codeClasse}"})
    public void assignProjectToUser(@PathVariable int projectId, @PathVariable int userId) {
        Project project = (Project) this.projectRepository.findById(projectId);
        User user = (User)this.userRepository.findById(userId);
        user.setProjects(user);
        projectRepository.save(project);
    }
//    //http://localhost:9090/rest/add-Assurance/{cinBf}
//    @PostMapping("/add-Assurance/{cinBf}")
//    public Assurance add(@RequestBody Assurance entity,@PathVariable int cinBf) {
//        Beneficiaire beneficiaire =beneficiaireRepository.findByCin(cinBf);
//
//        if(beneficiaire!= null){
//            entity.setBeneficiaire(beneficiaire);
//            return	assuranceRepository.save(entity);
//        }
//        return null;
//
//    }
//    //http://localhost:9090/rest/getContratBf/{id}
//    @GetMapping("/getContratBf/{idBf}")
//    public Contrat getContratBf(@PathVariable int idBf ) {
//        //using JPQL
//        return	contratRepository.getContratBfJPQL(idBf).get(0);
//        //using SQL
////		return	contratRepository.getContratBf(idBf);
//
//
//    }
//
//    //http://localhost:9090/rest/add/{id}
////	@GetMapping("/add/{cinBf}")
////	public Contrat getMontantBf(@PathVariable int cinBf ) {
////		return	contratRepository.getContratBf(idBf);
////	}
//
//    //http://localhost:9090/rest/getBeneficiairesAsType/{typeContrat}
//    @GetMapping("/getBeneficiairesAsType/{typeContrat}")
//    public Set<Beneficiaire> getBeneficiairesAsType(@PathVariable TypeContrat typeContrat ) {
//        return	beneficiaireRepository.findByAssurancesContratType(typeContrat);
////		return	assuranceRepository.findAll().stream()
////				.filter(a -> a.getContrat().getType().equals(typeContrat))
////				.map(Assurance::getBeneficiaire)
////				.collect(Collectors.toSet());
//    }
//
//    @Scheduled(fixedRate = 60000)
//    public void statistiques() {
//        beneficiaireRepository.getBeneficiaireByNbrAssuranceJPQL()
////		beneficiaireRepository.getBeneficiaireByNbrAssuranceSQL()
//                .stream()
//                .forEach(b -> log.info("Le Beneficiare : "+ b.getNom() +" " + b.getPrenom() +" a " + b.getAssurances().size()));
//    }



}
