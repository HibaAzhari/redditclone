package project.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import project.redditclone.model.User;
import project.redditclone.model.Post;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long subId;
    @NotBlank(message = "Must provide a name")
    private String name;
    @NotBlank(message = "Must provide a description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts;
    private Instant createdOn;
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

}
