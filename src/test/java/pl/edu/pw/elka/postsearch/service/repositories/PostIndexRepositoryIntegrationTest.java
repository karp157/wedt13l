package pl.edu.pw.elka.postsearch.service.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pl.edu.pw.elka.postsearch.model.Post;
import pl.edu.pw.elka.postsearch.service.harvesting.PostSearchAssert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ContextConfiguration("classpath:post-search-test-context.xml")
public class PostIndexRepositoryIntegrationTest extends AbstractTestNGSpringContextTests {

    @Resource
    private PostIndexRepository postIndexRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private Post post1;
    @Autowired
    private Post post2;

    @AfterMethod
    public void tearDown() throws Exception {
//        elasticsearchTemplate.deleteIndex(Post.class);
    }

    @Test
    public void testCreateOnePost() throws Exception {
        postIndexRepository.save(post1);

        Post actualPost = postIndexRepository.findOne(post1.getId());
        PostSearchAssert.assertEquals(post1, actualPost);

    }

    @Test
    public void testCreateMultiplePosts() throws Exception {
        List<Post> expected = Arrays.asList(post1, post2);
        List<Post> actual = new ArrayList<Post>();
        postIndexRepository.save(expected);

        for(Post post : postIndexRepository.findAll()) {
            actual.add(post);
        }

        PostSearchAssert.assertEquals(actual, expected);
    }
}
