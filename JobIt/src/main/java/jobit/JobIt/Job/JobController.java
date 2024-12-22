package jobit.JobIt.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController{

    private JobService jobService ;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("New job created successfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id){
        Job job = jobService.findJobById(id);
        if(job  != null)
            return new ResponseEntity<>(job, HttpStatus.OK) ;
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        Boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return ResponseEntity.ok("Job deleted succesfully" );

        return new ResponseEntity("No job to be deleted", HttpStatus.NOT_FOUND) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        Boolean updated = jobService.updateJobById(id, updatedJob) ;
        if(updated)
            return ResponseEntity.ok("Job with job id " +id+ " updated !") ;

        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND) ;
    }

}
