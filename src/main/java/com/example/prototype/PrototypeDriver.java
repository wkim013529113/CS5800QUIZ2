package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDriver {
    public static void main(String[] args) {
        // 1) Create original book
        List<String> chapters = new ArrayList<>();
        chapters.add("Introduction");
        chapters.add("How to Start Design Patterns");
        chapters.add("First Topic");

        BookShallowCopy originalBook =
                new BookShallowCopy("Design Patterns", "Bill Kim", chapters);

        // 2) Clone the book (shallow copy)
        BookShallowCopy clonedBook = originalBook.clone();

        System.out.println("=== Before modifying chapters ===");
        System.out.println("Original: " + originalBook);
        System.out.println("Clone:    " + clonedBook);

        // 3) Modify original's chapters
        originalBook.getChapters().add("New Chapter on Prototype Pattern");

        System.out.println("\n=== After modifying original's chapters ===");
        System.out.println("Original: " + originalBook);
        System.out.println("Clone:    " + clonedBook);
    }
}
