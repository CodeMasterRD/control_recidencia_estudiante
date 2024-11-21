
package recidencia_contro;

import Model.ConexionDB;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;


public class Recidencia_contro {

   
    public static void main(String[] args) throws SQLException, FileNotFoundException{
        ConexionDB conexionDB = new ConexionDB();
        Connection conexion = ConexionDB.getConexion();
    }
    
}
