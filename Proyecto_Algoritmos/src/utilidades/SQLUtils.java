package utilidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtils {
    
    public static void setNullableString (
            PreparedStatement ps, 
            int indice, 
            String valor, 
            int tipoSql
    ) throws SQLException {
         
        if (valor == null || valor.isBlank()) {
                ps.setNull(indice, tipoSql);
        } else {
            ps.setString(indice, valor);
        }
    }
    
    
}
