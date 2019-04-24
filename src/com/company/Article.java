package com.company;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

class Article {
    private final Long id;
    private final String title;
    private final String text;
    private final LocalDateTime publishedDate;
    private final List<String> tags;
    private final String category;
    private final String author;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", publishedDate=" + publishedDate +
                ", tags=" + tags +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    Article(Long id, String title, String text, LocalDateTime publishedDate, List<String> tags, String category, String author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.publishedDate = publishedDate;
        this.tags = tags;
        this.category = category;
        this.author = author;
    }
    
    static NeedId builder() {
        return new Builder();
    }
    
    private static class Builder implements NeedId, NeedTitle, NeedText, NeedPublishedDate, AddTag, CanBeBuilt {
        private Long id;
        private String title;
        private String text;
        private LocalDateTime publishedDate;
        private List<String> tags = new LinkedList<>();
        private String category;
        private String author;
        
        
        @Override
        public NeedTitle id(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public NeedText title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public NeedPublishedDate text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public AddTag tag(String tag) {
            tags.add(tag);
            return this;
        }

        @Override
        public CanBeBuilt and() {
            return this;
        }

        @Override
        public CanBeBuilt category(String category) {
            this.category = category;
            return this;
        }

        @Override
        public CanBeBuilt author(String author) {
            this.author = author;
            return this;
        }

        @Override
        public Article build() {
            return new Article(
                    id, title, text,publishedDate, tags, category, author);
        }

        @Override
        public AddTag publishedDate(LocalDateTime dateTime) {
            this.publishedDate = dateTime;
            return this;
        }
    }

    interface NeedId {
        NeedTitle id(Long id);
    }

    interface NeedTitle {
        NeedText title(String title);
    }

    interface NeedText {
        NeedPublishedDate text(String text);
    }

    interface NeedPublishedDate {
        AddTag publishedDate(LocalDateTime dateTime);
    }

    interface AddTag {
        AddTag tag(String tag);
        CanBeBuilt and();
    }

    interface CanBeBuilt {
        CanBeBuilt category(String category);
        CanBeBuilt author(String author);

        Article build();
    }

}
