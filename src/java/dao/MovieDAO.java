/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.List;
import modelo.Movie;

/**
 *
 * @author ASUS
 */
public interface MovieDAO {
    boolean agregar(Movie movie);
    List<Movie> listar();
    Movie buscar(Long id);
    boolean actualizar(Movie movie);
    boolean eliminar(Long id);
}
