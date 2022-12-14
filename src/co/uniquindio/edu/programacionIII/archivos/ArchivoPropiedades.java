package co.uniquindio.edu.programacionIII.archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author JaemT1
 */
public class ArchivoPropiedades {

    public static final String ARCHIVO = "C:\\Users\\JaemT1\\archivos\\archivo_properties.properties";

    public static void main(String[] args) {
        manipularArchivoPropiedades();
    }

    public static void manipularArchivoPropiedades() {
        // Escritura de archivo de propiedades:
        System.out.println("Escribiendo sobre un archivo de propiedades:");
        try (OutputStream salida = new FileOutputStream(ARCHIVO)) {

            Properties propiedades = new Properties();

            propiedades.setProperty("bd.url", "localhost");
            propiedades.setProperty("bd.usuario", "root");
            propiedades.setProperty("bd.password", "p@ssw0rd");

            propiedades.store(salida, null);

            System.out.println(propiedades);
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }

        System.out.println("\nLeyendo desde un archivo de propiedades:");

        try (InputStream lectura = new FileInputStream(ARCHIVO)) {
            Properties propiedades = new Properties();

            propiedades.load(lectura);

            System.out.println("URL: " + propiedades.getProperty("bd.url"));
            System.out.println("Usuario: " + propiedades.getProperty("bd.usuario"));
            System.out.println("contraseña: " + propiedades.getProperty("bd.password"));
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

}
