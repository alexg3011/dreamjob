package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore  {

    private static AtomicInteger POST_ID = new AtomicInteger(4);
    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);
    private static AtomicInteger USER_ID = new AtomicInteger(4);
    private static AtomicInteger CITY_ID = new AtomicInteger(4);

    private static final MemStore INST = new MemStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    private final Map<Integer, City> cities = new ConcurrentHashMap<>();

    private MemStore() {
        City city1 = new City(1, "St. Petersburg");
        City city2 = new City(2, "Moscow");
        City city3 = new City(3, "Vladivostok");
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
        candidates.put(1, new Candidate(1, "Junior Java", city1));
        candidates.put(2, new Candidate(2, "Middle Java", city2));
        candidates.put(3, new Candidate(3, "Senior Java", city3));
    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }


    public Candidate findCandidatesById(int id) {
        return candidates.get(id);
    }

    public void deleteCandidate(int id) {
        if (candidates.get(id) != null) {
            candidates.remove(id, findCandidatesById(id));
        }
    }

    public void deletePost(int id) {
        if (posts.get(id) != null) {
            posts.remove(id, findPostById(id));
        }
    }

    public void saveUser(User user) {
        if (user.getId() == 0) {
            user.setId(USER_ID.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    public void removeUser(User user) {
        if (users.get(user.getId()) != null) {
            users.remove(user.getId(), findUserByEmail(user.getEmail()));
        }
    }

    public User findUserByEmail(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public Collection<City> findAllCities() {
        return cities.values();
    }

    public City findCityById(int id) {
        return cities.get(id);
    }

    public City findCityByName(String name) {
        for (City city : cities.values()) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }
}