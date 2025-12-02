package service;
import entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface NewsService {
    Page<News> findAll(Pageable pageable,
                       Long authorId,
                       Long categoryId,
                       LocalDateTime createdAfter);
}
