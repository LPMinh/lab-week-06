package com.minh.labweek06.Repository;

import com.minh.labweek06.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    public List<Post> findAllByAuthorId(Long id);
    public List<Post> findAllGetAllByPublishedTrue();
    public Page<Post> findAllByPublishedTrue(Pageable pageable);
    Page<Post> findByContentContainingAndPublishedIsTrue(String content, Pageable pageable);
}
