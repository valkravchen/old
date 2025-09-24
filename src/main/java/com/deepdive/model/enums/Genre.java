package com.deepdive.model.enums;

public enum Genre {
    NATURE("Природа"),
    UNDERWATER("Подводный мир"),
    SPACE("Космос"),
    HISTORY("История"),
    SCIENCE("Наука"),
    TRAVEL("Путешествия"),
    PSYCHOLOGY("Психология"),
    BIOLOGY("Биология"),
    PHYSICS("Физика"),
    ARCHAEOLOGY("Археология");
    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
