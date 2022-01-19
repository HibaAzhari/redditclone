package project.redditclone.model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import project.redditclone.model.User;
import project.redditclone.model.Subreddit;

import java.time.Instant;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;
    @NotBlank(message = "Must provide a title")
    private String title;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User OP;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subId", referencedColumnName = "subId")
    private Subreddit sub;
    private Instant postedOn;
}
