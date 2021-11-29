package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Post> findAllTodayPosts();

    Collection<Candidate> findAllCandidates();

    Collection<Candidate> findAllTodayCandidates();

    Post savePost(Post post);

    void saveCandidate(Candidate candidate);

    Candidate findCandidateById(int id);

    Post findPostById(int id);

    void deleteCandidate(int id);

    void deletePost(int id);

    void saveUser(User user);

    void removeUser(User user);

    void removeCandidate(int id);

    void removePost(int id);

    User findUserByEmail(String email);

    Collection<City> findAllCities();

    City findCityById(int id);

    City findCityByName(String name);
}