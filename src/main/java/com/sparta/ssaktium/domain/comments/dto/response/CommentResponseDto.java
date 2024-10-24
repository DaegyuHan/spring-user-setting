package com.sparta.ssaktium.domain.comments.dto.response;

import com.sparta.ssaktium.domain.comments.entity.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long boardId;
    private final Long userId;

    public CommentResponseDto(Long id, String content, LocalDateTime createdAt, LocalDateTime modifiedAt, Long boardId, Long userId) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.boardId = boardId;
        this.userId = userId;
    }

    // 객체 받아서 Dto 만들기
    public CommentResponseDto (Comments comments){
        this.id = comments.getId();
        this.content = comments.getContent();
        this.createdAt = comments.getCreatedAt();
        this.modifiedAt = comments.getModifiedAt();
        this.boardId = comments.getBoard().getId();
        this.userId = comments.getUser().getId();
    }

}




