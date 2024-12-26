package jobit.JobIt.Company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService ;

    @GetMapping
    public List<Company> findAll(){
        return companyService.findAll() ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null   , HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        if(Boolean.TRUE.equals(companyService.updateCompany(company, id)))
            return ResponseEntity.ok("Company updated Succesfully");

        return (ResponseEntity<String>)ResponseEntity.notFound();
    }

    @PostMapping
    public ResponseEntity<String> createCompany( @RequestBody Company company){
        companyService.createCompany(company);
        return ResponseEntity.ok("New company added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById( @PathVariable Long id){
        if(Boolean.TRUE.equals(companyService.deleteCompanyById(id)))
            return ResponseEntity.ok("Company Successfully delete") ;
        return new ResponseEntity<>("No company to be deleted", HttpStatus.NOT_FOUND) ;
    }
}
