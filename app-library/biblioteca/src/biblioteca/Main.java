package biblioteca;

import biblioteca.view.JFrameUsuarioIniciarUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Marco <marc.barrera@duocuc.cl>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            java.awt.EventQueue.invokeLater(() -> {

                new JFrameUsuarioIniciarUI().setVisible(true);


            });

        } catch (Exception e) {
            System.out.println("excepción" + e.getMessage());
        }

    }

}
