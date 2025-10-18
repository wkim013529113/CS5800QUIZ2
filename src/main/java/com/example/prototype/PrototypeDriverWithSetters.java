package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDriverWithSetters {
    public static void main(String[] args) {
        // Prepare chapter list
        List<String> chapters = new ArrayList<>();
        chapters.add("Introduction");
        chapters.add("How to Start Design Patterns");
        chapters.add("First Topic");

        // Build via setters
        BookShallowCopy originalBook = new BookShallowCopy("", "", new ArrayList<>());
        originalBook.setTitle("Design Patterns");
        originalBook.setAuthor("Bill Kim");
        originalBook.setChapters(chapters); // setter instead of constructor

        // Clone (shallow copy)
        BookShallowCopy clonedBook = originalBook.clone();

        System.out.println("=== Before modifying chapters (Shallow) ===");
        System.out.println("Original: " + originalBook);
        System.out.println("Clone:    " + clonedBook);

        // Mutate ONLY the original's chapters (will affect clone due to shared list)
        originalBook.getChapters().add("New Chapter on Prototype Pattern");

        System.out.println("\n=== After modifying original's chapters (Shallow) ===");
        System.out.println("Original: " + originalBook);
        System.out.println("Clone:    " + clonedBook);
    }
}
