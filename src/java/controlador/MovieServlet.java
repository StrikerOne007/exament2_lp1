/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import dao.MovieDAO;
import dao.MovieDAOImpl;
import modelo.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/MovieServlet"})
public class MovieServlet extends HttpServlet {

    private static final List<Movie> lista = new ArrayList<>();
    private static long idCounter = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MovieDAO dao = new MovieDAOImpl();
        List<Movie> listaMovies = dao.listar();
        request.setAttribute("listaMovies", listaMovies);
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String slug = request.getParameter("slug");
        String description = request.getParameter("description");
        Long year = Long.valueOf(request.getParameter("year"));
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String category = request.getParameter("category");
        String imageUrl = request.getParameter("imageUrl");
        Boolean carousel = Boolean.valueOf(request.getParameter("carousel"));
        BigDecimal rating = new BigDecimal(request.getParameter("rating"));
        Long duration = Long.valueOf(request.getParameter("duration"));

        Movie movie = new Movie(title, slug, description, year, type, status,
                category, imageUrl, carousel, rating, duration
        );
        
        MovieDAO dao = new MovieDAOImpl();
        dao.agregar(movie);

        response.sendRedirect("MovieServlet");
    }
}
