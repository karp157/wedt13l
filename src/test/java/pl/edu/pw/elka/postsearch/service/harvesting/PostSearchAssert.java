package pl.edu.pw.elka.postsearch.service.harvesting;

import org.testng.Assert;
import pl.edu.pw.elka.postsearch.model.Post;
import pl.edu.pw.elka.postsearch.model.Posts;

import java.util.List;

public final class PostSearchAssert extends Assert {
    public static void assertEquals(Posts actual, Posts expected) {
        final List<Post> expectedPosts = expected.getPostList();
        final List<Post> actualPosts = actual.getPostList();

        assertEquals(actualPosts.size(), expectedPosts.size());

        assertEquals(actualPosts, expectedPosts);
    }
}
