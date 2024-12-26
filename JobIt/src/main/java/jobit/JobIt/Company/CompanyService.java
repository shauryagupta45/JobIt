package jobit.JobIt.Company;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> findAll() ;
    Optional<Company> getCompanyById(Long id);
    Boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    Boolean deleteCompanyById(Long id) ;
}
