package com.deepdive.model;

import com.deepdive.model.enums.MediaType;

public class AudioBook extends MediaContent {
    private String author;               // автор
    private String narrator;             // диктор/чтец
    private int durationMinutes;         // длительность в минутах
    private int currentMinute;           // текущая позиция прослушивания
    private String language;             // язык аудиокниги
    private String publisher;            // издатель аудиокниги

    public AudioBook(String title, String author, int year) {
        super(title, year, MediaType.AUDIOBOOK);
        this.author = author;
    }

    @Override
    public String getFormattedInfo() {
        StringBuilder info = new StringBuilder();
        info.append(getType().getDescription())
                .append(": ")
                .append(getTitle()).append(", ")
                .append(author).append(" (")
                .append(getYear()).append(")")
                .append(narrator).append(", ");
        if (narrator != null && !narrator.isEmpty()) {
            info.append(", читает ").append(narrator);
        }
        return info.toString();
    }

    @Override
    public double getProgress() {
        if (durationMinutes == 0) return 0.0;
        return (double) (currentMinute * 100) / durationMinutes;
    }

    public void updateListeningProgress(int minutesListened) {
        currentMinute = minutesListened;
    }

    public String getTimeRemaining() {
        int remainingMinutes = durationMinutes - currentMinute;
        return (remainingMinutes / 60) + "ч " + (remainingMinutes % 60) + "мин ";
    }
}
