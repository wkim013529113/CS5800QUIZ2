package com.example.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDeepCopyTest {

    private BookDeepCopy createOriginal() {
        List<String> chapters = new ArrayList<>();
        chapters.add("Intro to Prototypes");
        chapters.add("Instructions of Book Deep Copy");
        chapters.add("What is a DeepCopy and what is a ShallowCopy");
        chapters.add("Why DeepCopy");
        return new BookDeepCopy("Design Patterns (Deep)", "William Lee", chapters);
    }

    @Test
    @DisplayName("Deep clone should be a different object and have a different chapters list reference")
    void deepClone_createsNewListReference() {
        BookDeepCopy original = createOriginal();
        BookDeepCopy clone = original.clone();

        // Objects should be distinct
        assertNotSame(original, clone, "Clone should be a different object instance");
        // Value fields copied
        assertEquals(original.getTitle(), clone.getTitle());
        assertEquals(original.getAuthor(), clone.getAuthor());
        // Chapters list should NOT share same reference
        assertNotSame(original.getChapters(), clone.getChapters(),
                "Chapters list should be a different object for deep copy");
        // But contents should be equal
        assertEquals(original.getChapters(), clone.getChapters(),
                "Chapter contents should initially be identical");
    }

    @Test
    @DisplayName("Modifying original chapters should NOT affect clone (independent list)")
    void modifyingOriginalDoesNotAffectClone() {
        BookDeepCopy original = createOriginal();
        BookDeepCopy clone = original.clone();

        original.getChapters().add("Deep Copy: Case Studies");

        // Original changed, clone unchanged
        assertEquals(5, original.getChapters().size(),
                "Original should now have one additional chapter");
        assertEquals(4, clone.getChapters().size(),
                "Clone should remain with original 4 chapters");
        assertFalse(clone.getChapters().contains("Deep Copy: Case Studies"),
                "Clone should NOT contain the new chapter");
    }

    @Test
    @DisplayName("Modifying clone chapters should NOT affect original (independent list)")
    void modifyingCloneDoesNotAffectOriginal() {
        BookDeepCopy original = createOriginal();
        BookDeepCopy clone = original.clone();

        clone.getChapters().remove("Why DeepCopy");

        // Verify only clone changed
        assertEquals(4, original.getChapters().size(),
                "Original should remain with 4 chapters");
        assertEquals(3, clone.getChapters().size(),
                "Clone should have one fewer chapter");
        assertTrue(original.getChapters().contains("Why DeepCopy"),
                "Original should still contain 'Why DeepCopy'");
    }
}
