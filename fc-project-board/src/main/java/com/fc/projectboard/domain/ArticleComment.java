package com.fc.projectboard.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Long articleId; // 게시글 id
    private String content; // 댓글 본문

    private LocalDateTime createdAt; // 작성일자
    private String createdBy; // 작성자
    private LocalDateTime modifiedAt; // 수정일자
    private String modifiedBy; // 수정자
}
