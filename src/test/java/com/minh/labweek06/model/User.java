package com.minh.labweek06.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String mobile;
    @Column
    private Instant lastLogin;
    @Column
    private String lastName;
    @Column
    private String intro;
    @Column
    private String profile;
    @Column
    private Instant registeredAt;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<PostComment> comments=new LinkedHashSet<PostComment>();
    @Column
    private String passwordHash;
    @Column
    private String middleName;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Post> posts=new LinkedHashSet<Post>();
    @Column
    private String firstName;
    @Column
    private String email;

    public User(Long id, String mobile, Instant lastLogin, String lastName, String intro, String profile, Instant registeredAt, Set<PostComment> comments, String passwordHash, String middleName, Set<Post> posts, String firstName, String email) {
        this.id = id;
        this.mobile = mobile;
        this.lastLogin = lastLogin;
        this.lastName = lastName;
        this.intro = intro;
        this.profile = profile;
        this.registeredAt = registeredAt;
        this.comments = comments;
        this.passwordHash = passwordHash;
        this.middleName = middleName;
        this.posts = posts;
        this.firstName = firstName;
        this.email = email;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Instant getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Instant registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Set<PostComment> getComments() {
        return comments;
    }

    public void setComments(Set<PostComment> comments) {
        this.comments = comments;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
