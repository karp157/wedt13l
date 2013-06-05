package pl.edu.pw.elka.postsearch.service.harvesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.edu.pw.elka.postsearch.model.Post;
import pl.edu.pw.elka.postsearch.model.Posts;
import pl.edu.pw.elka.postsearch.model.User;

import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static pl.edu.pw.elka.postsearch.service.harvesting.TwitterCorpusHarvester.*;

@ContextConfiguration("classpath:post-search-test-context.xml")
public class TwitterCorpusHarvesterTest extends AbstractTestNGSpringContextTests {
    private TwitterCorpusHarvester instance;
    private List<Post> expectedList;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Post post1;
    @Autowired
    private Post post2;

    @BeforeMethod
    public void setUp() throws Exception {
        expectedList = Arrays.asList(post1, post2);
    }

    @Test
    public void testSimpleAppleTest() throws Exception {
        Resource testFile = context.getResource("classpath:harvesting/apple_test");
        instance = new TwitterCorpusHarvester(testFile.getFile(), 2, "en");
        Posts expected = new Posts(expectedList);
        Posts actual = instance.next();

        PostSearchAssert.assertEquals(actual, expected);
    }

    @Test
    public void testHasNext() throws Exception {
        Resource testFile = context.getResource("classpath:harvesting/apple_test");
        instance = new TwitterCorpusHarvester(testFile.getFile(), 1, "en");

        for(int i = 0; i < 10; ++i) {
            PostSearchAssert.assertTrue(instance.hasNext());
        }

        Posts expected = new Posts(expectedList.subList(0, 1));
        Posts actual = instance.next();

        PostSearchAssert.assertEquals(actual, expected);
    }
}
