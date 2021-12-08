package biblioteca.model;

import java.time.LocalDate;
/**
 *
 * @author Marco <marc.barrera@duocuc.cl>
 */
public class LibroModel {

    private String nombre;
    private String editorial;
    private String autor;
    private LocalDate fechaDeIngreso;
    private Integer cantidad;
    private Integer id;
    /**
     * 
     */
    public LibroModel(){
        
    }
    /**
     * 
     * @param nombre
     * @param editorial
     * @param autor
     * @param fechaDeIngreso
     * @param cantidad
     * @param id 
     */
    public LibroModel(String nombre, String editorial, String autor, LocalDate fechaDeIngreso, Integer cantidad, Integer id) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.fechaDeIngreso = fechaDeIngreso;
        this.cantidad = cantidad;
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the fechaDeIngreso
     */
    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    /**
     * @param fechaDeIngreso the fechaDeIngreso to set
     */
    public void setFecha_de_ingreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    

}
