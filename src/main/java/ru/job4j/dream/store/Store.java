package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    Candidate findCandidateById(int id);

    Post findPostById(int id);

    void deleteCandidate(int id);

    void deletePost(int id);

    void saveUser(User user);

    void removeUser(User user);

    User findUserByEmail(String email);
}