package com.techindeck.cms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techindeck.cms.models.PostModel;
import com.techindeck.cms.services.PostService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostModel>> getAllPoste() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping
    public ResponseEntity<PostModel> createUser(@Valid @RequestBody PostModel postModel) {
        return ResponseEntity.ok(postService.createPost(postModel));
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<PostModel> getPostById(@PathVariable String id) {
        Optional<PostModel> user = postService.getPostById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostModel> updatePost(@PathVariable String id, @Valid @RequestBody PostModel postModel) {
        PostModel updatedPost = postService.updatePost(id, postModel);
        return updatedPost != null ? ResponseEntity.ok(updatedPost) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
