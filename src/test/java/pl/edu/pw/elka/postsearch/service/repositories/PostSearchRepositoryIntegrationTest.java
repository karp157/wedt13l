package pl.edu.pw.elka.postsearch.service.repositories;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import pl.edu.pw.elka.postsearch.model.Post;

import javax.annotation.Resource;

@ContextConfiguration("classpath:post-search-test-context.xml")
@Ignore
public class PostSearchRepositoryIntegrationTest extends AbstractTestNGSpringContextTests {
    @Resource
    private PostSearchRepository postSearchRepository;
    @Resource
    private PostIndexRepository postIndexRepository;

    @Autowired
    private Post post1;
    @Autowired
    private Post post2;

    @Test
    public void testFindByMessage() throws Exception {
//        postIndexRepository.save(Arrays.asList(post1, post2));
        Iterable<Post> posts = postSearchRepository.findByMessage("*", new PageRequest(0, 10));
        System.out.println("Posts: ");
        for(Post post : posts) {
            System.out.println("Post: " + post);
        }
    }
}

