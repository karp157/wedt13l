package pl.edu.pw.elka.postsearch.service.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pl.edu.pw.elka.postsearch.model.Post;

public interface PostSearchRepository extends ElasticsearchRepository<Post, Long> {
    Page<Post> findByMessage(final String message, final Pageable pageable);
}
