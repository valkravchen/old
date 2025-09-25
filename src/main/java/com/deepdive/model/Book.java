package com.deepdive.model;

import com.deepdive.model.enums.MediaType;

public class Book extends MediaContent {
    private String author;               // автор
    private String isbn;                 // ISBN код
    private int totalPages;              // всего страниц
    private int currentPage;             // текущая страница
    private String publisher;            // издательство
    private String language;             // язык издания

    public Book(String title, String author, int year) {
        super(title, year, MediaType.BOOK);
        this.author = author;
    }

    @Override
    public String getFormattedInfo() {
        StringBuilder info = new StringBuilder();
        info.append(getType().getDescription())
                .append(": ")
                .append(getTitle()).append(", ")
                .append(author).append(" (")
                .append(getYear()).append("), ")
                .append(totalPages).append(" стр.");
        return info.toString();
    }

    @Override
    public double getProgress() {
        if (totalPages == 0) return 0.0;
        return (double) (currentPage * 100) / totalPages;
    }

    public void updateProgress(int pagesRead) {
        currentPage = pagesRead;
        if (currentPage >= totalPages) {
            setCompleted(true);
        }
    }
}
