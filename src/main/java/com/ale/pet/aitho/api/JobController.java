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

    record addLavoroRequest(String id, String job){}
    @PostMapping("")
    public void addLavori(@RequestBody addLavoroRequest request){
        Job lavoro = new Job();
        lavoro.setId(request.id());
        lavoro.setJob_name(request.job());
        jobs.save(lavoro);
    }

    record rmLavoroRequest(String id){}
    @DeleteMapping("{id}")
    public void rmLavori(@PathVariable String id){
        Optional<Job> toDelete = jobs.findById(id);
        toDelete.ifPresent(job -> jobs.delete(job));
    }
}