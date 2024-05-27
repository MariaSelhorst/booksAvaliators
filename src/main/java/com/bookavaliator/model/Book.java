package com.bookavaliator.model;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "BookTitle")
    private String title;

    @Column(name = "BookAuthor")
    private String author;

    @Column(name = "Reviews")
    @OneToMany(mappedBy = "Book", cascade = CascadeType.ALL)
    private List<Review> review;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return title;
    }

    public void setBookTitle(String title) {
        this.title = title;
    }

    public String getBookAuthor() {
        return author;
    }

    public void setBookAuthor(String author) {
        this.author = author;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    
}