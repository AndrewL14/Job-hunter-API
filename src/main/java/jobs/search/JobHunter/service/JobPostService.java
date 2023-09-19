package jobs.search.JobHunter.service;

import com.mongodb.client.result.UpdateResult;
import jobs.search.JobHunter.DTO.request.UpdateJobRequest;
import jobs.search.JobHunter.DTO.response.JobPostDTO;
import jobs.search.JobHunter.converter.CustomConverter;
import jobs.search.JobHunter.entity.JobPost;
import jobs.search.JobHunter.exception.JobPostNotFoundException;
import jobs.search.JobHunter.repository.JobPostRepository;
import jobs.search.JobHunter.utils.CustomIdMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository repo;
    @Autowired
    private CustomIdMaker customIdMaker;
    @Autowired
    private MongoTemplate template;

    public JobPostDTO updateJobPost(UpdateJobRequest request) {
        if (request == null) throw new NullPointerException("request is null");
        Query query = new Query(Criteria.where("imbdId").is(request.imdbId()));
        Update update = new Update();

        if (!request.profile().isEmpty()) update.set("profile", request.profile());
        if (!request.description().isEmpty()) update.set("description", request.description());
        if (request.experience() != null) update.set("experience", request.experience());
        if (!request.skills().isEmpty()) update.set("skills", request.skills());

        template.updateFirst(query, update, JobPost.class);

        return new JobPostDTO(request.imdbId(), request.profile(),
                request.description(), request.experience(), request.skills());
    }

    public List<JobPostDTO> fetchAllJobPost() {
        return repo.findAll().stream()
                .map(CustomConverter::jobToDto)
                .collect(Collectors.toList());
    }

    public JobPostDTO findJobByImbdId(String imbdId) {
        Optional<JobPost> jobPost = repo.findByimbdId(imbdId);
        return CustomConverter.jobToDto(jobPost
                .orElseThrow(JobPostNotFoundException::new));
    }

    public JobPostDTO addNewPost(JobPost post) {
        post.setImbdId(customIdMaker.generateId(2,4));
        return CustomConverter.jobToDto(repo.insert(post));
    }

    public void deleteJobPost(JobPost post) {
        repo.delete(post);
    }

    public void deleteJobPost(String imbdId) {
        JobPost temp = new JobPost();
        temp.setImbdId(imbdId);

        repo.delete(temp);
    }

}
