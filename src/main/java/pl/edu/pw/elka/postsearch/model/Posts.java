package pl.edu.pw.elka.postsearch.model;

import java.util.ArrayList;
import java.util.List;

public class Posts {
    private List<Post> postList = new ArrayList<Post>();

    public Posts() {
    }

    public Posts(final List<Post> postList) {
        this.postList = postList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(final List<Post> postList) {
        this.postList = postList;
    }

    public void add(final Post post) {
        postList.add(post);
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postList=" + postList +
                "} " + super.toString();
    }
}
