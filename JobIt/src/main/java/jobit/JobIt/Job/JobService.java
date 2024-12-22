package jobit.JobIt.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll() ;
    void createJob(Job job) ;

    Job findJobById(Long id);

    Boolean deleteJobById(Long id);

    Boolean updateJobById(Long id, Job updatedJob);
}
