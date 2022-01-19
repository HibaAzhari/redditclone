package project.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.redditclone.model.Post;
import project.redditclone.model.Subreddit;
import project.redditclone.model.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllBySubreddit(Subreddit subreddit);
    List<Post> findByUser(User user);

}
