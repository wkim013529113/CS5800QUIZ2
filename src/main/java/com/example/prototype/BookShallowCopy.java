package com.example.prototype;

import java.lang.Cloneable;
import java.util.List;

public class BookShallowCopy implements Cloneable {
    private String title;
    private String author;
    private List<String> chapters;   // shared reference (shallow)

    public BookShallowCopy(String title, String author, List<String> chapters) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public List<String> getChapters() { return chapters; }
    public void setChapters(List<String> chapters) { this.chapters = chapters; }

    @Override
    public BookShallowCopy clone() {
        try {
            // SHALLOW COPY — chapters list reference is shared
            return (BookShallowCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "BookShallowCopy{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}
