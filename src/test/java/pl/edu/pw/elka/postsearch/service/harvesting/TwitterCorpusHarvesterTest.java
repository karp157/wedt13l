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

    @BeforeMethod
    public void setUp() throws Exception {
        Date date = CREATION_DATE_SDF.parse("20081025");
        expectedList = Arrays.asList(new Post(date,
                152517L,
                new User("GnarleyCharley", new URL("http://a3.twimg.com/profile_images/252328289/101_2280_normal.jpg")),
                "is going around renaming things so they all start with an \"i\" before Apple does it..iToaster, his iToilet, and his ipatch and iDOG.all set.",
                "en"
        ),
                new Post(date,
                        161252L,
                        new User("lsbuffs", new URL("http://a1.twimg.com/profile_images/300319856/P5300144_normal.JPG")),
                        "Frogger available in iPhone app store for $.99 #apple",
                        "it"
                )
        );

    }

    @Test
    public void testSimpleAppleTest() throws Exception {
        Resource testFile = context.getResource("classpath:harvesting/apple_test");
        instance = new TwitterCorpusHarvester(testFile.getFile(), 2);
        Posts expected = new Posts(expectedList);
        Posts actual = instance.next();

        PostSearchAssert.assertEquals(actual, expected);
    }

    @Test
    public void testHasNext() throws Exception {
        Resource testFile = context.getResource("classpath:harvesting/apple_test");
        instance = new TwitterCorpusHarvester(testFile.getFile(), 1);

        for(int i = 0; i < 10; ++i) {
            PostSearchAssert.assertTrue(instance.hasNext());
        }

        Posts expected = new Posts(expectedList.subList(0, 1));
        Posts actual = instance.next();

        PostSearchAssert.assertEquals(actual, expected);
    }
}
