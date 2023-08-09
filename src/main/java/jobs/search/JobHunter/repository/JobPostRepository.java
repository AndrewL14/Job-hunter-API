package jobs.search.JobHunter.repository;

import jobs.search.JobHunter.entity.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPostRepository extends MongoRepository<JobPost, Long> {

    Optional<JobPost> findByimbdId(String imbdId);
}
