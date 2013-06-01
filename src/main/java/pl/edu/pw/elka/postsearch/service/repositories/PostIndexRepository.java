package pl.edu.pw.elka.postsearch.service.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pl.edu.pw.elka.postsearch.model.Post;

public interface PostIndexRepository extends ElasticsearchRepository<Post, Long> {
    <S extends Post> S index(S entities);
}
