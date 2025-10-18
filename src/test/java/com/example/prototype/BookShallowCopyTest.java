package com.example.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookShallowCopyTest {

    private BookShallowCopy createOriginal() {
        List<String> chapters = new ArrayList<>();
        chapters.add("Introduction");
        chapters.add("How to Start Design Patterns");
        chapters.add("First Topic");
        return new BookShallowCopy("Design Patterns", "Bill Kim", chapters);
    }

    @Test
    @DisplayName("Shallow clone should be a different object but share the same chapters list reference")
    void shallowClone_sharesListReference() {
        BookShallowCopy original = createOriginal();
        BookShallowCopy clone = original.clone();

        assertNotSame(original, clone, "Clone should be a different object");
        assertEquals(original.getTitle(), clone.getTitle(), "Title should be copied");
        assertEquals(original.getAuthor(), clone.getAuthor(), "Author should be copied");

        // Key shallow-copy assertion: same List reference
        assertSame(original.getChapters(), clone.getChapters(),
                "Chapters list should be the same reference for shallow copy");
    }

    @Test
    @DisplayName("Modifying original chapters should reflect in clone (shared list)")
    void modifyingOriginalReflectsInClone() {
        BookShallowCopy original = createOriginal();
        BookShallowCopy clone = original.clone();

        original.getChapters().add("New Chapter on Prototype Pattern");

        assertEquals(4, original.getChapters().size(), "Original should have 4 chapters");
        assertEquals(4, clone.getChapters().size(),
                "Clone should also show 4 chapters because the list is shared");
        assertTrue(clone.getChapters().contains("New Chapter on Prototype Pattern"),
                "Clone should reflect added chapter due to shared reference");
    }

    @Test
    @DisplayName("Modifying clone chapters should reflect in original (shared list)")
    void modifyingCloneReflectsInOriginal() {
        BookShallowCopy original = createOriginal();
        BookShallowCopy clone = original.clone();

        // Remove a chapter that actually exists in createOriginal()
        boolean removed = clone.getChapters().remove("How to Start Design Patterns");
        assertTrue(removed, "Expected chapter should be present and removed");

        assertEquals(2, original.getChapters().size(),
                "Original should reflect removal because list is shared");
        assertFalse(original.getChapters().contains("How to Start Design Patterns"),
                "Original should no longer have 'How to Start Design Patterns'");
    }

}
