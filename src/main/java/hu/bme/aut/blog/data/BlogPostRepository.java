package hu.bme.aut.blog.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer>, BlogPostRepositoryCustom {

    @Query("SELECT bp FROM BlogPost bp WHERE bp.title LIKE 'M%'")
    public List<BlogPost> findPostsWhoseTitleStartsWithM();
}