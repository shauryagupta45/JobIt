package jobit.JobIt.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
