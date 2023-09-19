package jobs.search.JobHunter.DTO.request;

import java.util.List;

public record UpdateJobRequest(
        String imdbId,
        String profile,
        String description,
        Integer experience,
        List<String> skills
) {
}
