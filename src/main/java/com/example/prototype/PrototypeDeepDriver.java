package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDeepDriver {
    public static void main(String[] args) {
        // 1) Create original BookDeepCopy
        List<String> chapters = new ArrayList<>();
        chapters.add("Intro to Prototypes");
        chapters.add("Instructions of Book Deep Copy");
        chapters.add("What is a DeepCopy and what is a ShallowCopy");
        chapters.add("Why DeepCopy");

        BookDeepCopy original =
                new BookDeepCopy("Design Patterns (Deep)", "William Lee", chapters);

        // 2) Clone (deep)
        BookDeepCopy clone = original.clone();

        System.out.println("=== Before modifying chapters ===");
        System.out.println("Original: " + original);
        System.out.println("Clone:    " + clone);

        // 3) Modify ONLY the original's chapters
        original.getChapters().add("Deep Copy: Case Studies");

        System.out.println("\n=== After modifying original's chapters ===");
        System.out.println("Original: " + original);
        System.out.println("Clone:    " + clone);   // should NOT reflect the new chapter
    }
}
