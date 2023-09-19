package com.example.Booksdemo.domain;

public class Book {

        private Integer id;

        private String name;

        private Integer ISBN;

        private String author;

        public Book(Integer id, String name, Integer ISBN, String author) {
            super();
            this.id = id;
            this.name = name;
            this.ISBN = ISBN;
            this.author = author;
        }

        // REQUIRED
        public Book() {
            super();
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getISBN() {
            return ISBN;
        }

        public void setISBN(int ISBN) {
            this.ISBN = ISBN;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

