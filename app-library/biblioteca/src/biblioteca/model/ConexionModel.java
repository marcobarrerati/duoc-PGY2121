package biblioteca.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco <marc.barrera@duocuc.cl>
 */
public class ConexionModel {

    private String host = "localhost";
    private String puerto = "3307";
    private String basededatos = "app_db";
    private String basededatosusuario = "db_user";
    private String basededatosclave = "db_user_pass";

    Connection con = null;

    public PreparedStatement prepareStatement = null;

    public ConexionModel() {
        getConexion();
    }

    public PreparedStatement prepareStatement(String sql) {

        try {

            this.prepareStatement = this.con == null ? null : this.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Exception al crear  prepareStatement" + ex.getMessage());
        }

        return this.prepareStatement;
    }

    public final void getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + basededatos + "", basededatosusuario, basededatosclave);
            System.out.println("Conectado a la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println( "Exception al crear  conexión" + ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Exception al crear  conexión" + ex.getMessage());
        }

    }

}
