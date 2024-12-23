package jobit.JobIt.Company.impl;

import jobit.JobIt.Company.Company;
import jobit.JobIt.Company.CompanyRepo;
import jobit.JobIt.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.* ;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo ;

    public List<Company> findAll(){
        return companyRepo.findAll() ;
    }

}
