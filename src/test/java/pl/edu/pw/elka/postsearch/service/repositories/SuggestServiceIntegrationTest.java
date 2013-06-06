package pl.edu.pw.elka.postsearch.service.repositories;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.edu.pw.elka.postsearch.service.harvesting.PostSearchAssert;

@ContextConfiguration("classpath:post-search-test-context.xml")
public class SuggestServiceIntegrationTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private Client client;

    private SuggestService suggestService;

    @BeforeMethod
    public void setUp() throws Exception {
        suggestService = new SuggestService(client);
    }

    @Test
    public void testGetMostLikelySuggestions() throws Exception {
        String result = suggestService.getMostLikelySuggestions("aple juize");
        PostSearchAssert.assertEquals(result, "apple juice");
    }

    @Test
    public void testGetNullSuggestion() throws Exception {
        String result = suggestService.getMostLikelySuggestions("apple phone");
        PostSearchAssert.assertEquals(result, null);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        client.close();
    }
}
