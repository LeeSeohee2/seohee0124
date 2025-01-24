package com.himedia.spring0124.repository;

import com.himedia.spring0124.dto.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends
        JpaRepository<Comment, Long> {
}
