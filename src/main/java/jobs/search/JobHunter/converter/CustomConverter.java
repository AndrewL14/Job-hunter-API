package jobs.search.JobHunter.converter;

import jobs.search.JobHunter.DTO.response.JobPostDTO;
import jobs.search.JobHunter.entity.JobPost;

public class CustomConverter {

    public static JobPostDTO jobToDto(JobPost post) {
        return new JobPostDTO(post.getImbdId(), post.getProfile()
                ,post.getDescription() , post.getExperience() , post.getSkills());
    }
}
