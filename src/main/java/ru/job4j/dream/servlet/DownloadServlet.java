package ru.job4j.dream.servlet;

import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String candidateId = req.getParameter("id");
        File downloadFile = null;
        for (File file : new File("c:\\images\\").listFiles()) {
            String fileName = FilenameUtils.getBaseName(file.getName());
            if (candidateId.equals(fileName)) {
                downloadFile = file;
                break;
            }
        }
        resp.setContentType("application/octet-stream");
        if (downloadFile != null) {
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
            try (FileInputStream stream = new FileInputStream(downloadFile)) {
                resp.getOutputStream().write(stream.readAllBytes());
            }
        }
    }
}
