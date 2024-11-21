

package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
     private  static  Connection conexion = null;// variable de tipo Connection que guarda la conexion
    // metodo para obtener la conixion a la base de dato
    public static Connection getConexion() throws FileNotFoundException, SQLException{
        
        // verificamos si la conexion ya existe
        if(conexion != null && !conexion.isClosed()){
            return conexion;// si exixte retornara la conexion
            
        }else {
            //si no existe intetara relizar la conexion
        try {
            String directorioActual = System.getProperty("user.dir");// obtenemos el directorio actual
            String rutaArchivo = directorioActual + File.separator + "\\src\\model\\configuracion.txt"; // localizamos la ruta que contiene la url, user y password
            
            //creamos una intancia tipo file
            File archivo = new File(rutaArchivo); //resive la ruta como argumento
            // creamos otra intacia tipo filereader para leer lo que tiene el archivo
            
            FileReader lector = new FileReader(archivo);//creamos una intancia tipo file
            
            // creamos las variable para guardar lo que tiene el archivo
            String url;
            String user;
            String pass;
            
            // utilizamos bufferRader para la lectura del archivo
            BufferedReader buffer;
            buffer = new BufferedReader(lector);
            //lemos el archivo lipor linea y seguardan los valores en el mismo orden de archivo txt
            url = buffer.readLine();
            user = buffer.readLine();
            pass = buffer.readLine();
                    
            buffer.close();//cerramo el buffer
            //obtenemos la conexion y la guardamoe en la variable de tipo Connection
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("conexion exitosa");// verificamo por cosola que la conexion fue exitosa
            return conexion; // retornamo la conexion
            
          // si algo sale mal enviamo  manejamos el error y 
        } catch (IOException e) {
            System.out.println("ERROR DE CONEXION: " + e.getMessage());
            return  null;
        }
    }
        
    }
}
