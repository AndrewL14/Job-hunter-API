package jobs.search.JobHunter.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "JobPost")
public class JobPost {
    @Id
    private Long id;
    private String imbdId;
    private String profile;
    private String description;
    private int experience;
    private List<String> skills;

    public JobPost(String imdbId , String profile , String description , int experience , List<String> skills) {
        this.imbdId = imdbId;
        this.profile = profile;
        this.description = description;
        this.experience = experience;
        this.skills = skills;
    }
}
