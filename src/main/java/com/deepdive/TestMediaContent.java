package com.deepdive;

import com.deepdive.model.MediaContent;
import com.deepdive.model.enums.Genre;
import com.deepdive.model.enums.MediaType;

public class TestMediaContent {
    public static void main(String[] args) {
        MediaContent test1 = new MediaContent("Test", 2020, MediaType.BOOK) {
            @Override
            public String getFormattedInfo() {
                return "Test: " + getTitle();
            }

            @Override
            public double getProgress() {
                return 0.0;
            }
        };

        MediaContent test2 = new MediaContent("Test", 2020, MediaType.BOOK) {
            @Override
            public String getFormattedInfo() {
                return "Test: " + getTitle();
            }

            @Override
            public double getProgress() {
                return 0.0;
            }
        };
        System.out.println("=== Тест MediaContent ===");
        System.out.println("ID test1: " + test1.getId());
        System.out.println("ID test2: " + test2.getId());
        System.out.println("Разные ID: " + !test1.getId().equals(test2.getId()));
        System.out.println("\nEquals:" + test1.equals(test2));
        System.out.println("HashCode равны: " + (test1.hashCode() == test2.hashCode()));
        test1.addGenre(Genre.NATURE);
        test1.addGenre(Genre.NATURE);
        test1.addGenre(Genre.UNDERWATER);
        System.out.println("\nЖанры: " + test1.getGenres());
        System.out.println("Количество жанров: " + test1.getGenres().size());
        test1.addTag("интересное");
        test1.addTag("ИНТЕРЕСНОЕ");
        test1.addTag("  ");
        test1.addTag(null);
        System.out.println("\nТеги: " + test1.getTags());
        System.out.println("\ntoString(): " + test1);
    }
}
