package biblioteca.controller;

import biblioteca.model.LibroModel;
import java.sql.*;
import java.util.ArrayList;
import biblioteca.interfaces.CRUDI;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


/**
 *
 * @author Marco <marc.barrera@duocuc.cl>
 */
public class LibroController extends ConexionController implements CRUDI {

    public LibroModel objLibroM;
    private static final String tabla = "appdb_libro";

    public LibroController() {
        this.objLibroM = new LibroModel();
    }

    @Override
    public Integer insert() {
        Integer claveGenerada = 0;
        try {
            String sql = "INSERT INTO " + tabla + " (nombre, editorial, autor, fecha_de_ingreso, cantidad) VALUES (?,?,?,?,?)";
            this.prepareStatement(sql);
            this.prepareStatement.setString(1, this.objLibroM.getNombre());
            this.prepareStatement.setString(2, this.objLibroM.getEditorial());
            this.prepareStatement.setString(3, this.objLibroM.getAutor());
            java.util.Date fecha = Date.from(this.objLibroM.getFechaDeIngreso().atStartOfDay().atZone(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant());
            this.prepareStatement.setDate(4, new java.sql.Date(fecha.getTime()));
            this.prepareStatement.setInt(5, this.objLibroM.getCantidad());
            this.prepareStatement.executeUpdate();
            // Obtener la clave generada
            ResultSet rs = this.prepareStatement.getGeneratedKeys();
            while (rs.next()) {
                claveGenerada = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Excepción al insertar el libro " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción al insertar libro " + e.getMessage());
        }
        return claveGenerada;
    }

    @Override
    public Integer update() {

        Integer filasAfectadas = 0;
        try {
            
            String sql = "UPDATE " + tabla + " set nombre = ?, editorial=?, autor = ?, fecha_de_ingreso = ?, cantidad = ? WHERE id = ? ";
            
            this.prepareStatement(sql);
            
            this.prepareStatement.setString(1, this.objLibroM.getNombre());
            this.prepareStatement.setString(2, this.objLibroM.getEditorial());
            this.prepareStatement.setString(3, this.objLibroM.getAutor());
            java.util.Date fecha = Date.from(this.objLibroM.getFechaDeIngreso().atStartOfDay().atZone(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant());
            this.prepareStatement.setDate(4, new java.sql.Date(fecha.getTime()));
            this.prepareStatement.setInt(5, this.objLibroM.getCantidad());
            this.prepareStatement.setInt(6, this.objLibroM.getId());
            this.prepareStatement.executeUpdate();
            filasAfectadas = this.prepareStatement.getUpdateCount();

        } catch (SQLException e) {
            System.out.println("Excepción al actualizar el libro " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción al actualizar el libro " + e.getMessage());
        }
        return filasAfectadas;
    }

    @Override
    public Integer delete() {

        Integer filasAfectadas = 0;
        try {
            String sql = "DELETE FROM " + tabla + " WHERE id = ? ";
            this.prepareStatement(sql);
            this.prepareStatement.setInt(1, this.objLibroM.getId());
            this.prepareStatement.executeUpdate();
            filasAfectadas = this.prepareStatement.getUpdateCount();

        } catch (SQLException e) {
            System.out.println("Excepción al eliminar el libro " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción al eliminar el libro " + e.getMessage());
        }
        return filasAfectadas;
    }

    @Override
    public ArrayList<LibroModel> list() {

        ArrayList datos = new ArrayList<LibroModel>();

        try {
            String sql = "SELECT id, nombre, editorial, autor, fecha_de_ingreso, cantidad FROM " + tabla + " ";
            this.prepareStatement(sql);
            ResultSet rs = this.prepareStatement.executeQuery();

            while (rs.next()) {

                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String editorial = rs.getString("editorial");
                String autor = rs.getString("autor");
                Integer cantidad = rs.getInt("cantidad");
                LocalDate fecha = Instant.ofEpochMilli(rs.getDate("fecha_de_ingreso").getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                LibroModel libro = new LibroModel();

                libro.setId(id);
                libro.setNombre(nombre);
                libro.setFecha_de_ingreso(fecha);
                libro.setAutor(autor);
                libro.setCantidad(cantidad);
                libro.setEditorial(editorial);

                datos.add(libro);

            }

        } catch (SQLException e) {
            System.out.println("excepción al listar libros " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción al listar libros " + e.getMessage());
        }

        return datos;

    }
    
    
    public ArrayList<LibroModel> buscarPorNombre(String nombreBuscado) {

        ArrayList datos = new ArrayList<LibroModel>();

        try {
            String sql = "SELECT id, nombre, editorial, autor, fecha_de_ingreso, cantidad FROM " + tabla + " WHERE nombre like '%"+nombreBuscado+"%' ";
            this.prepareStatement(sql);
            ResultSet rs = this.prepareStatement.executeQuery();

            while (rs.next()) {

                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String editorial = rs.getString("editorial");
                String autor = rs.getString("autor");
                Integer cantidad = rs.getInt("cantidad");
                LocalDate fecha = Instant.ofEpochMilli(rs.getDate("fecha_de_ingreso").getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                LibroModel libro = new LibroModel();

                libro.setId(id);
                libro.setNombre(nombre);
                libro.setFecha_de_ingreso(fecha);
                libro.setAutor(autor);
                libro.setCantidad(cantidad);
                libro.setEditorial(editorial);

                datos.add(libro);

            }

        } catch (SQLException e) {
            System.out.println("excepción al listar libros " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción al listar libros " + e.getMessage());
        }

        return datos;

    }
    
    

}
