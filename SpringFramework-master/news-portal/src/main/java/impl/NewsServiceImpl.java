package impl;

import entity.News;
import exceptions.NewsNotFoundException;
import static java.util.Arrays.stream;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.NewsRepository;
import service.NewsService;
import specifications.NewsSpecifications;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Override
    public News findById(Long id) {
       return newsRepository.findById(id).orElseThrow(() -> new NewsNotFoundException(id));
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.findById(Math.toIntExact(id));
        newsRepository.deleteById(Math.toIntExact(id));
    }
}