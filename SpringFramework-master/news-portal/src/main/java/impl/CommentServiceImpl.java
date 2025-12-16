package impl;

import entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.CommentRepository;
import service.CommentService;
import service.NewsService;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl  implements CommentService {
    private final CommentRepository commentRepository;
    private final NewsService newsService;

    @Override
    public long countCommentsForNews(Long id) {
        newsService.findById(id);
        return commentRepository.countByNewsId(id);
    }

    @Override
    public Page<Comment> getCommentsForNews(Long id, Pageable pageable) {
        newsService.findById(id);
        return commentRepository.findByNewsId(id, pageable);
    }
}
