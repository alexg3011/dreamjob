package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", DbStore.instOf().findAllCandidates());
        req.setAttribute("cities", DbStore.instOf().findAllCities());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Candidate candidate = DbStore.instOf().findCandidateById(id);
        Candidate newCandidate = new Candidate(id,
                req.getParameter("name"),
                DbStore.instOf().findCityByName(req.getParameter("city")),
                Timestamp.from(Instant.now()));
        if (candidate == null) {
            DbStore.instOf().saveCandidate(newCandidate);
        } else {
            DbStore.instOf().updateCandidate(newCandidate);
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
