package hu.bme.aut.blog;

import hu.bme.aut.blog.data.BlogPost;
import hu.bme.aut.blog.data.BlogPostRepository;
import hu.bme.aut.blog.data.BlogUser;
import hu.bme.aut.blog.data.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

    @Autowired
    private BlogPostRepository blogPostRepo;

    @Autowired
    private BlogUserRepository blogUserRepo;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "creationDate");
        Page<BlogPost> page = blogPostRepo.findAll(pageable);
        page.forEach(System.out::println);

        List<BlogPost> postsStartingWithM = blogPostRepo.findPostsWhoseTitleStartsWithM();
        postsStartingWithM.forEach(System.out::println);

        List<BlogPost> postsWrittenByJillThatContainsDinner = blogPostRepo.findPostsWrittenByAuthorThatContainKeyword("Jill", "dinner");
        postsWrittenByJillThatContainsDinner.forEach(System.out::println);
*/

        Optional<BlogUser> jillOpt = blogUserRepo.findById("jill@example.com");
        BlogUser jill = jillOpt.orElse(null);
        // LazyInitializationException!
        jill.getPosts().forEach(System.out::println);

    }
}
