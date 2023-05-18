package com.ale.pet.aitho.api;

import com.ale.pet.aitho.models.Job;
import com.ale.pet.aitho.repositories.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobRepository jobs;

    public JobController(JobRepository jobs) {
        this.jobs = jobs;
    }

    @GetMapping
    public List<Job> getLavori(){
        return jobs.findAll();
    }

    @GetMapping("{id}")
    public Optional<Job> getLavoriByPersona(@PathVariable String id){
        return jobs.findById(id);
    }

    record addLavoroRequest(String job_name){}
    @PostMapping
    public void addLavoro(@RequestBody addLavoroRequest request){
        Job lavoro = new Job();
        lavoro.setJob_name(request.job_name());
        jobs.save(lavoro);
    }

    record rmLavoroRequest(String id){}
    @DeleteMapping("{id}")
    public void rmLavoro(@PathVariable String id){
        Optional<Job> toDelete = jobs.findById(id);
        toDelete.ifPresent(job -> jobs.delete(job));
    }

    record editLavoroRequest(long job_id, String job_name){}
    @PutMapping("/edit")
    public void editLavoro(@RequestBody editLavoroRequest request){
        Job lavoro = new Job();
        lavoro.setId(request.job_id);
        lavoro.setJob_name(request.job_name);
        jobs.save(lavoro);
    }
}