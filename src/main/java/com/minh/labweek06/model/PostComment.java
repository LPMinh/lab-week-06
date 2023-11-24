package com.minh.labweek06.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post_comment")
public class PostComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "post_id")
    private Post post;
    @Column
    private String title;
    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "parent",fetch = FetchType.EAGER)
    private Set<PostComment> postComments=new LinkedHashSet<PostComment>();
    @Column
    private Boolean published;
    @Column
    private String content;
    @Column
    private Instant publishedAt;
    @Column
    private Instant createdAt;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "parent_id")
    private PostComment parent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public PostComment( Post post, String title, Set<PostComment> postComments, Boolean published, String content, PostComment parent, User user) {

        this.post = post;
        this.title = title;
        this.postComments = postComments;
        this.published = published;
        this.content = content;
        this.publishedAt = Instant.now() ;
        this.createdAt = Instant.now();
        this.parent = parent;
        this.user = user;
    }

    public PostComment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments) {
        this.postComments = postComments;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public PostComment getParent() {
        return parent;
    }

    public void setParent(PostComment parent) {
        this.parent = parent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
