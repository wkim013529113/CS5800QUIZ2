package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDeepDriverWithSetters {
    public static void main(String[] args) {
        // Prepare chapter list
        List<String> chapters = new ArrayList<>();
        chapters.add("Intro to Prototypes");
        chapters.add("Instructions of Book Deep Copy");
        chapters.add("What is a DeepCopy and what is a ShallowCopy");
        chapters.add("Why DeepCopy");

        // Build via setters
        BookDeepCopy original = new BookDeepCopy("", "", new ArrayList<>());
        original.setTitle("Design Patterns (Deep)");
        original.setAuthor("William Lee");
        original.setChapters(chapters); // setter instead of constructor

        // Clone (deep copy)
        BookDeepCopy clone = original.clone();

        System.out.println("=== Before modifying chapters (Deep) ===");
        System.out.println("Original: " + original);
        System.out.println("Clone:    " + clone);

        // Mutate ONLY the original's chapters (will NOT affect clone due to deep copy)
        original.getChapters().add("Deep Copy: Case Studies");

        System.out.println("\n=== After modifying original's chapters (Deep) ===");
        System.out.println("Original: " + original);
        System.out.println("Clone:    " + clone);
    }
}
