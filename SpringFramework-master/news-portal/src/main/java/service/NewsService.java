package service;
import entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface NewsService {
    Page<News> findAll(Pageable pageable,
                       Long authorId,
                       Long categoryId,
                       LocalDateTime createdAfter);

    Optional<News> findById(Long id);
    void deleteById(Long id);

}
