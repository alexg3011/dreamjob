package ru.job4j.dream.servlet;

import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteCandidateServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.valueOf(req.getParameter("id"));
            DbStore.instOf().removeCandidate(id);
            resp.sendRedirect(req.getContextPath() + "/candidates.do");
            File file = new File("c:\\images\\" + id);
            file.delete();
        }
}
