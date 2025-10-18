package com.example.prototype;

import java.lang.Cloneable;
import java.util.ArrayList;
import java.util.List;

public class BookDeepCopy implements Cloneable {
    private String title;
    private String author;
    private List<String> chapters;   // deeply copied

    public BookDeepCopy(String title, String author, List<String> chapters) {
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
    public BookDeepCopy clone() {
        try {
            BookDeepCopy copy = (BookDeepCopy) super.clone();
            // DEEP COPY — new list created
            copy.chapters = (this.chapters == null)
                    ? null
                    : new ArrayList<>(this.chapters);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "BookDeepCopy{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}
