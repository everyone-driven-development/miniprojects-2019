package com.woowacourse.edd.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_name")
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;

    private boolean isDeleted;

    public User() {
    }

    public User(String name, String email, String password, boolean isDeleted) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isDeleted = isDeleted;
    }

    public void update(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void delete() {
        this.isDeleted = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public boolean isNotMatchPassword(String password) {
        return !this.password.equals(password);
    }
}
