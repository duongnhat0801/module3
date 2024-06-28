package com.codegym.btss12.models;

public class Book {
    private int id;
    private String title;
    private int pageSize;
    private int category_id;
    private int authors_id;
    private Category category;
    private Author author;

    public Book() {
    }

    public Book(String title, int pageSize, int category_id, int authors_id, Category category, Author author) {
        this.title = title;
        this.pageSize = pageSize;
        this.category_id = category_id;
        this.authors_id = authors_id;
        this.category = category;
        this.author = author;
    }

    public Book(int id, String title, int pageSize, int category_id, int authors_id, Category category, Author author) {
        this.id = id;
        this.title = title;
        this.pageSize = pageSize;
        this.category_id = category_id;
        this.authors_id = authors_id;
        this.category = category;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(int authors_id) {
        this.authors_id = authors_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}



