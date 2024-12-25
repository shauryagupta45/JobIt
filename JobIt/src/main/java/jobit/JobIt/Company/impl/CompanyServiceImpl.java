package jobit.JobIt.Company.impl;

import jobit.JobIt.Company.Company;
import jobit.JobIt.Company.CompanyRepo;
import jobit.JobIt.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.* ;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo ;

    public List<Company> findAll(){
        return companyRepo.findAll() ;
    }

    @Override
    public Boolean updateCompany(Company updatedCompany, Long id){
        Optional<Company> companyOptional = companyRepo.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setId(updatedCompany.getId());
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepo.save(company);
            return true;
        }
        return false ;
    }

    @Override
    public void createCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public Boolean deleteCompanyById(Long id){
        if(companyRepo.existsById(id)){
            companyRepo.deleteById(id);
            return true ;
        }
        return false ;
    }
}
