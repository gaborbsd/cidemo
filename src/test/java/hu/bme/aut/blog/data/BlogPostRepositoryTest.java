package hu.bme.aut.blog.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogPostRepositoryTest {

    @Autowired
    private BlogUserRepository repository;

    @Test
    public void testSaveUser() {
        BlogUser user = new BlogUser();
        user.setEmail("foo@bar.hu");
        user.setName("Foo Bar");
        user.setPassword("pass");

        long sizeBefore = repository.count();
        repository.save(user);
        long sizeAfter = repository.count();

        assertEquals("Count must have been incremented", sizeBefore + 1, sizeAfter);

        List<BlogUser> users = repository.findAll();
        assertTrue("findAll() must return saved user", users.contains(user));
        assertTrue(false);
    }
}
