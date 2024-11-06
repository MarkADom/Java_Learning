package com.marco.joblisting.repository;

import com.marco.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}


