package jobs.search.JobHunter.DTO.response;

import java.util.List;

public record JobPostDTO(
        String imbdId,
        String profile,
        String description,
        int experience,
        List<String> skills
) {
}
