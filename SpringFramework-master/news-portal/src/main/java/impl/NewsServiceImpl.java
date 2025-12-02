package impl;

import entity.News;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.NewsRepository;
import service.NewsService;
import specifications.NewsSpecifications;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public Page<News> findAll(Pageable pageable, Long authorId, Long categoryId, LocalDateTime createdAfter) {
        Specification<News> spec = Specification.where(null);
        if (authorId != null) {
            spec = spec.and(NewsSpecifications.hasAuthor(authorId));
        }
        if (categoryId != null) {
            spec = spec.and(NewsSpecifications.hasCategory(categoryId));
        }
        if (createdAfter != null) {
            spec = spec.and(NewsSpecifications.createdAfter(createdAfter));
        }
        return newsRepository.findAll(spec, pageable);
    }

}