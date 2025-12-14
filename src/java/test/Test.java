/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.MovieDAO;
import dao.MovieDAOImpl;
import java.util.List;
import modelo.Movie;

/**
 *
 * @author ASUS
 */
public class Test {
    public static void main(String[] args) {
        MovieDAO dao = (MovieDAO) new MovieDAOImpl();

        Movie movie1 = new Movie();
        movie1.setTitle("Spider-Man: Across the Spider-Verse");
        movie1.setSlug("spider-man-across-spider-verse");
        movie1.setDescription("Miles Morales regresa para la próxima aventura del Spider-Verse");
        movie1.setYear(2023L);
        movie1.setType("movie");
        movie1.setStatus("published");
        movie1.setCategory("Acción");
        movie1.setImageUrl("https://hips.hearstapps.com/hmg-prod/images/spider-man-cruzando-el-multiverso-across-the-spider-verse-mejor-pelicula-647913cda5109.jpeg");
        movie1.setCarousel(true);
        movie1.setRating(new java.math.BigDecimal("8.7"));
        movie1.setDuration(140L);
        dao.agregar(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("Oppenheimer");
        movie2.setSlug("oppenheimer");
        movie2.setDescription("La historia del físico J. Robert Oppenheimer");
        movie2.setYear(2023L);
        movie2.setType("movie");
        movie2.setStatus("published");
        movie2.setCategory("Drama");
        movie2.setImageUrl("https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_.jpg");
        movie2.setCarousel(true);
        movie2.setRating(new java.math.BigDecimal("8.4"));
        movie2.setDuration(180L);
        dao.agregar(movie2);

        Movie movie3 = new Movie();
        movie3.setTitle("Barbie");
        movie3.setSlug("barbie");
        movie3.setDescription("Barbie vive en Barbieland donde todo es perfecto");
        movie3.setYear(2023L);
        movie3.setType("movie");
        movie3.setStatus("published");
        movie3.setCategory("Comedia");
        movie3.setImageUrl("https://m.media-amazon.com/images/M/MV5BNjU3N2QxNzYtMjk1NC00MTc4LTk1NTQtMmUxNTljM2I0NDA5XkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_.jpg");
        movie3.setCarousel(true);
        movie3.setRating(new java.math.BigDecimal("7.0"));
        movie3.setDuration(114L);
        dao.agregar(movie3);

        Movie movie4 = new Movie();
        movie4.setTitle("The Dark Knight");
        movie4.setSlug("the-dark-knight");
        movie4.setDescription("Batman enfrenta al Joker en Gotham City");
        movie4.setYear(2008L);
        movie4.setType("movie");
        movie4.setStatus("published");
        movie4.setCategory("Acción");
        movie4.setImageUrl("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg");
        movie4.setCarousel(false);
        movie4.setRating(new java.math.BigDecimal("9.0"));
        movie4.setDuration(152L);
        dao.agregar(movie4);

        Movie movie5 = new Movie();
        movie5.setTitle("Inception");
        movie5.setSlug("inception");
        movie5.setDescription("Un ladrón que roba secretos a través de los sueños");
        movie5.setYear(2010L);
        movie5.setType("movie");
        movie5.setStatus("published");
        movie5.setCategory("Ciencia Ficción");
        movie5.setImageUrl("https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg");
        movie5.setCarousel(false);
        movie5.setRating(new java.math.BigDecimal("8.8"));
        movie5.setDuration(148L);
        dao.agregar(movie5);

        System.out.println("Películas agregadas correctamente");
        System.out.println("\nListado de películas:");
        dao.listar().forEach(System.out::println);
    }
}
