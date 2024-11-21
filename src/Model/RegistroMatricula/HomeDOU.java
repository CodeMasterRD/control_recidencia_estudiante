
package Model.RegistroMatricula;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.ConexionDB;
import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.ResultSet;

public class HomeDOU {
    //definimos los atributos
    public int matricula;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
    //metodo que validad la entrada
    // resive un parametro tipo String
    // retorna un true or false
    public static boolean validarMatricula(int matricula) throws SQLException, FileNotFoundException{
        
        String SQL = "{call validarMatriculaEstudiante(?)}";
        
        try { 
            Connection conexion = ConexionDB.getConexion();
            CallableStatement callableStatement = (CallableStatement) conexion.prepareCall(SQL);
            
            //stablecer el parametro de entrada 
            
            callableStatement.setInt(1, matricula);
            
            boolean resultada = callableStatement.execute();
            
            //procesar resutado
            if(resultada){
                try {
                    ResultSet resultset = callableStatement.getResultSet();
                    while (resultset.next()) { 
                        int matriculaObtenida = resultset.getInt("Matricula");
                        
                        System.out.println("Matrícula encontrada: " + matriculaObtenida);
                    }
                    
                } catch (SQLException e) {
                    
                }
            }else{
                
            
            }
            
            
            
        } catch (SQLException e) {
        }
        return false;
        
    }
    
    
}
