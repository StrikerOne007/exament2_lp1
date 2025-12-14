/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Movie;
import util.Conexion;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class MovieDAOImpl implements MovieDAO {

    @Override
    public boolean agregar(Movie m) {
        String sql = "INSERT INTO movies (title, slug, description, year, type, status, category, image_url, carousel, rating, duration) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getTitle());
            ps.setString(2, m.getSlug());
            ps.setString(3, m.getDescription());
            ps.setLong(4, m.getYear());
            ps.setString(5, m.getType());
            ps.setString(6, m.getStatus());
            ps.setString(7, m.getCategory());
            ps.setString(8, m.getImageUrl());
            ps.setBoolean(9, m.getCarousel() != null ? m.getCarousel() : false);
            ps.setBigDecimal(10, m.getRating());
            ps.setLong(11, m.getDuration());

            ps.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("Ocurrió un error al agregar: " + ex.getMessage());
            
        }
        return false;
    }

    @Override
    public List<Movie> listar() {
         List<Movie> lista = new ArrayList<>();
            String sql = "SELECT * FROM movies";

            try (Connection con = Conexion.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Movie m = new Movie();
                    m.setId(rs.getLong("id"));
                    m.setTitle(rs.getString("title"));
                    m.setSlug(rs.getString("slug"));
                    m.setDescription(rs.getString("description"));
                    m.setYear(rs.getLong("year"));
                    m.setType(rs.getString("type"));
                    m.setStatus(rs.getString("status"));
                    m.setCategory(rs.getString("category"));
                    m.setImageUrl(rs.getString("image_url"));
                    m.setCarousel(rs.getBoolean("carousel"));
                    m.setRating(rs.getBigDecimal("rating"));
                    m.setDuration(rs.getLong("duration"));
                    m.setCreatedAt(rs.getObject("created_at", java.time.OffsetDateTime.class));

                    lista.add(m);
                }

            } catch (Exception e) {
                System.out.println("Error al listar movies: " + e.getMessage());
            }

            return lista;
        }
    

    @Override
    public Movie buscar(Long id) {
        String sql = "SELECT * FROM movies WHERE id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Movie(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("slug"),
                    rs.getString("description"),
                    rs.getLong("year"),
                    rs.getString("type"),
                    rs.getString("status"),
                    rs.getString("category"),
                    rs.getString("image_url"),
                    rs.getBoolean("carousel"),
                    rs.getBigDecimal("rating"),
                    rs.getLong("duration"),
                    rs.getObject("created_at", java.time.OffsetDateTime.class)
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar movie: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean actualizar(Movie movie) {
        if (buscar(movie.getId()) == null) return false;

        String sql = "UPDATE movies SET title = ?, slug = ?, description = ?, year = ?, type = ?, status = ?, category = ?, image_url = ?, carousel = ?, rating = ?, duration = ? WHERE id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        try {
                con = Conexion.getConnection();
                ps = con.prepareStatement(sql);

                ps.setString(1, movie.getTitle());
                ps.setString(2, movie.getSlug());
                ps.setString(3, movie.getDescription());
                ps.setLong(4, movie.getYear());
                ps.setString(5, movie.getType());
                ps.setString(6, movie.getStatus());
                ps.setString(7, movie.getCategory());
                ps.setString(8, movie.getImageUrl());
                ps.setBoolean(9, movie.getCarousel() != null ? movie.getCarousel() : false);
                ps.setBigDecimal(10, movie.getRating());
                ps.setLong(11, movie.getDuration());
                ps.setLong(12, movie.getId());

                int rows = ps.executeUpdate();
                return rows > 0;
        } catch (Exception ex) {
                System.out.println("Ocurrió un error al actualizar la película: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(Long id) {
        if (buscar(id) == null) return false;

        String sql = "DELETE FROM movies WHERE id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        try {
                con = Conexion.getConnection();
                ps = con.prepareStatement(sql);
                ps.setLong(1, id);

                int rows = ps.executeUpdate();
                return rows > 0;
        } catch (Exception ex) {
                System.out.println("Ocurrió un error al eliminar la película: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false;
    }
    
}
