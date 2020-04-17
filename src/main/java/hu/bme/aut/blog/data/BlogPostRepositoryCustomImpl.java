package hu.bme.aut.blog.data;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogPostRepositoryCustomImpl implements BlogPostRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<BlogPost> findPostsWrittenByAuthorThatContainKeyword(String author, String keyword) {
        String queryString = "SELECT p FROM BlogPost p WHERE p.author.name = :author AND LOWER(p.title) LIKE CONCAT('%',:keyword ,'%')";
        TypedQuery<BlogPost> query = em.createQuery(queryString, BlogPost.class);
        query.setParameter("author", author);
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }
}
