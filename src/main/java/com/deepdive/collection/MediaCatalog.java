package com.deepdive.collection;

import com.deepdive.model.MediaContent;

import java.util.ArrayList;
import java.util.List;

public class MediaCatalog {
    private List<MediaContent> catalog;     // основное хранилище (ArrayList)
    private int totalItems;

    public MediaCatalog() {
        this.catalog = new ArrayList<>();
        this.totalItems = 0;
    }

    public boolean addMedia(MediaContent media) {
        catalog.add(media);
        totalItems++;
        return true;
    }

    public boolean removeMedia(String id) {
        return true;
    }
}
