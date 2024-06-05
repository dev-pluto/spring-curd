package com.techindeck.cms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techindeck.cms.models.PostModel;
import com.techindeck.cms.repositories.PostRepository;
import com.techindeck.cms.repositories.UserInterface;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserInterface userRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    // public List<PostModel> getAllPostsWithUserDetails() {
    //     List<PostModel> posts = getAllPosts();
    //     posts.forEach(post -> post.setUser(userRepository.findById(post.getUserId()).orElse(null)));
    //     return posts;
    // }

    public Optional<PostModel> getPostById(String id) {
        return postRepository.findById(id);
    }

    public PostModel createPost(PostModel post) {
        return postRepository.save(post);
    }

    public PostModel updatePost(String id, PostModel post) {
        PostModel existingPost = postRepository.findById(id).orElse(null);
        if (existingPost == null) {
            return null;
        }
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postRepository.save(existingPost);
    }

    public void deletePost(String id) {
        postRepository.deleteById(id);
    }

}
