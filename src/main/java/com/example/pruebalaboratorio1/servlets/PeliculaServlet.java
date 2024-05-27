package com.example.pruebalaboratorio1.servlets;

import com.example.pruebalaboratorio1.beans.pelicula;
import com.example.pruebalaboratorio1.daos.peliculaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "pelicula-servlet", value = "/listaPeliculas")
public class PeliculaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        peliculaDao peliculaDao = new peliculaDao();
        ArrayList<pelicula> listaPeliculas = peliculaDao.listarPeliculas();
        request.setAttribute("listaPeliculas", listaPeliculas);

        RequestDispatcher view = request.getRequestDispatcher("listaPeliculas.jsp");
        view.forward(request,response);
    }


}
