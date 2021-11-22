package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.savePost(new Post(0, "Java Job"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        Post post = store.findPostById(0);
        System.out.println(post.toString());
        store.saveCandidate(new Candidate(0, "Alex"));
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.toString());
        }
        System.out.println(store.findCandidateById(0).toString());
        store.deleteCandidate(0);
        store.deletePost(0);
    }
}