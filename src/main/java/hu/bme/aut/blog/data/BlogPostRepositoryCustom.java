package hu.bme.aut.blog.data;

import java.util.List;

public interface BlogPostRepositoryCustom {

    List<BlogPost> findPostsWrittenByAuthorThatContainKeyword(String author, String keyword);

}
