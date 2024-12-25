package jobit.JobIt.Company;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompanyService {

    List<Company> findAll() ;
    Boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    Boolean deleteCompanyById(Long id) ;
}
