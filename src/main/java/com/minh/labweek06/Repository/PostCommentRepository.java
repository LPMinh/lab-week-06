package com.minh.labweek06.Repository;

import com.minh.labweek06.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment,Long> {
    public List<PostComment> findAllByPostId(Long id);
    public List<PostComment> findAllByPostIdAndParentNull(Long id);
}
