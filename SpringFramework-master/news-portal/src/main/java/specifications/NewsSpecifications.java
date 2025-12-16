package specifications;
import entity.News;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@NoArgsConstructor
public final class NewsSpecifications {
    public static Specification<News> hasAuthor(Long authorId) {
        return (root, query, cb) ->
                cb.equal(root.get("author").get("id"), authorId);
    }

    public static Specification<News> hasCategory(Long categoryId) {
        return (root, query, cb) ->
                cb.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<News> createdAfter(LocalDateTime created) {
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("createDate"), created);
    }

    public static Specification<News> findNewsById(Long newsId) {
        return (root, query, cb) -> cb.equal(root.get("id"), newsId);
    }
}
