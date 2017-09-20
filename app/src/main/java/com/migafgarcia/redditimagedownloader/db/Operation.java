package com.migafgarcia.redditimagedownloader.db;


import java.util.List;

public interface Operation {
    int create(Object item);
    int update(Object item);
    int delete(Object item);
    Object findById(String id);
    List<?> findAll();
}
