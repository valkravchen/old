package com.deepdive.model;

import com.deepdive.model.enums.MediaType;

public class Video extends MediaContent {
    private int durationMinutes;        // продолжительность в минутах
    private String director;             // режиссер
    private String productionCountry;    // страна производства
    private String studio;
    private String language;             // язык оригинала
    private int episodesTotal;          // всего эпизодов (для сериалов)
    private int episodesWatched;        // просмотрено эпизодов

    public Video(String title, int year, MediaType type) {
        super(title, year, type);
        if (type != MediaType.DOCUMENTARY && type != MediaType.DOCUMENTARY_SERIES) {
            throw new IllegalArgumentException(
                    "Video может быть только DOCUMENTARY или DOCUMENTARY_SERIES, получен: " + type);
        }
    }

    @Override
    public String getFormattedInfo() {
        StringBuilder info = new StringBuilder();
        info.append(getType().getDescription())
                .append(": ")
                .append(getTitle())
                .append(" (").append(getYear()).append("), ")
                .append(durationMinutes).append(" мин");
        if (studio != null && !studio.isEmpty()) {
            info.append(", ").append(studio);
        }
        return info.toString();
    }

    @Override
    public double getProgress() {
        if (isSeries()) {
            if (episodesTotal == 0) return 0.0;
            return (double) (episodesWatched * 100) / episodesTotal;
        } else {
            return isCompleted() ? 100.0 : 0.0;
        }
    }

    public String getFormattedDuration() {
        return (durationMinutes / 60) + "ч " + (durationMinutes % 60) + "мин ";
    }

    public boolean isSeries() {
        return getType() == MediaType.DOCUMENTARY_SERIES;
    }
}

