package jobit.JobIt.Job.impl;

import jobit.JobIt.Job.Job;
import jobit.JobIt.Job.JobRepo;
import jobit.JobIt.Job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
   private JobRepo jobRepo ;

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job)  ;
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepo.findById(id).orElse(null) ;
    }

    @Override
    public Boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobList.iterator();
//        while(iterator.hasNext()){
//            Job job = iterator.next() ;
//            if(job.getId().equals(id)){
//                iterator.remove();
//                return  true;
//            }
//        }
//        return false ;
        try {
            jobRepo.deleteById(id);
            return  true;
        }catch (Exception e){
            return false ;
        }
    }

    @Override
    public Boolean updateJobById(Long id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepo.findById( id );
        if(jobOptional.isPresent()){
            Job job = jobOptional.get() ;
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setLocation(updatedJob.getLocation());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());

            jobRepo.save(job) ;
            return true ;
        }

//        Iterator<Job> iterator = jobList.iterator();
//        while(iterator.hasNext()){
//            Job job = iterator.next() ;
//            if(job.getId().equals(id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setLocation(updatedJob.getLocation());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//
//                return true ;
//            }
//        }
        return  false;
    }

}
