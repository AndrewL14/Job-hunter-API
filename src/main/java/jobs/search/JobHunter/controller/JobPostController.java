package jobs.search.JobHunter.controller;

import jobs.search.JobHunter.DTO.request.UpdateJobRequest;
import jobs.search.JobHunter.DTO.response.JobPostDTO;
import jobs.search.JobHunter.entity.JobPost;
import jobs.search.JobHunter.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobPostController {

    @Autowired
    JobPostService service;

    @GetMapping("/find")
    public ResponseEntity<JobPostDTO> getJobByImbdId(@RequestParam String imbdId) {
        return new ResponseEntity<JobPostDTO>(
                service.findJobByImbdId(imbdId), HttpStatus.OK
        );
    }

    @PutMapping("/update")
    public ResponseEntity<JobPostDTO> updateJobPost(@RequestBody UpdateJobRequest request) {
        return new ResponseEntity<JobPostDTO>(
                service.updateJobPost(request), HttpStatus.OK
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<JobPostDTO>> getAllJobPost() {
        return new ResponseEntity<List<JobPostDTO>>(
                service.fetchAllJobPost(), HttpStatus.OK
        );
    }

    @PostMapping("/upload")
    public ResponseEntity<JobPostDTO> createJobPost(@RequestBody JobPost post) {
        return new ResponseEntity<JobPostDTO>(
                service.addNewPost(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteJobPost(@RequestBody JobPost post) {
        service.deleteJobPost(post);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{imbdId}")
    public ResponseEntity<?> deleteJobPost(@PathVariable String imbdId) {
        service.deleteJobPost(imbdId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}