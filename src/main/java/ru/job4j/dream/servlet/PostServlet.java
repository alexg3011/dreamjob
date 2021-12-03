package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", new ArrayList<>(DbStore.instOf().findAllPosts()));
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Post post = DbStore.instOf().findPostById(id);
        Post newPost = new Post(
                id,
                req.getParameter("name"),
                req.getParameter("description"),
                Timestamp.from(Instant.now()));
        if (post == null ) {
            DbStore.instOf().savePost(newPost);
        } else {
            DbStore.instOf().updatePost(newPost);
        }
            resp.sendRedirect(req.getContextPath() + "/posts.do");
    }
}