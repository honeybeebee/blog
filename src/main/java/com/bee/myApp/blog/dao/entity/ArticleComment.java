package com.bee.myApp.blog.dao.entity;

import java.util.Date;

public class ArticleComment {
    private Long id;

    private String commentEmail;

    private String commentName;

    private Long articleId;

    private Long originalCommentId;

    private String originalCommentName;

    private Date createTime;

    private Integer status;

    private String commentContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail == null ? null : commentEmail.trim();
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName == null ? null : commentName.trim();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getOriginalCommentId() {
        return originalCommentId;
    }

    public void setOriginalCommentId(Long originalCommentId) {
        this.originalCommentId = originalCommentId;
    }

    public String getOriginalCommentName() {
        return originalCommentName;
    }

    public void setOriginalCommentName(String originalCommentName) {
        this.originalCommentName = originalCommentName == null ? null : originalCommentName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}