package repository;

import entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Page<Comment> findByNewsId(Long newsId, Pageable pageable);
    long countByNewsId(Long newsId);
}
