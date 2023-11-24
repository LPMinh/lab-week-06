package com.minh.labweek06.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "post")

public class Post   implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean published;
    @Column
    private String content;
    @OneToMany(mappedBy = "post",cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PostComment> postComments=new LinkedHashSet<PostComment>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Post parent;
    @Column
    private String metaTitle;
    @Column
    private String summary;
    @Column
    private Instant createdAt;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
    private Set<Post> posts=new LinkedHashSet<Post>();
    @Column
    private String title;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    private User author;
    @Column
    private Instant updatedAt;
    @Column
    private Instant publishedAt;
    @Column
    private  String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Post( boolean published, String content, Post parent, String metaTitle, String summary, Instant createdAt, String title, User author, Instant updatedAt, Instant publishedAt, String image) {

        this.published = published;
        this.content = content;
        this.parent = parent;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createdAt = createdAt;
        this.title = title;
        this.author = author;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments) {
        this.postComments = postComments;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Post(Long id, boolean published, String content, Set<PostComment> postComments, Post parent, String metaTitle, String summary, Instant createdAt, Set<Post> posts, String title, User author, Instant updatedAt, Instant publishedAt) {
        this.id = id;
        this.published = published;
        this.content = content;
        this.postComments = postComments;
        this.parent = parent;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createdAt = createdAt;
        this.posts = posts;
        this.title = title;
        this.author = author;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
    }

    public Post(Long id, boolean published, String content, String metaTitle, String summary, String title,User user) {
        this.id = id;
        this.published = published;
        this.content = content;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createdAt = createdAt;
        this.title = title;
        this.updatedAt =Instant.now();
        this.publishedAt = Instant.now();
        this.createdAt=Instant.now();
        this.updatedAt=Instant.now();
        this.author=user;
        this.parent=null;



    }

    public Post() {
    }

}
