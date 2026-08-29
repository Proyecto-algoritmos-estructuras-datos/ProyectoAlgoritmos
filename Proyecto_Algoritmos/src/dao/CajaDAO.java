package dao;

import conexion.Conexion;
import interfaces.ICajaDAO;
import java.time.LocalDate;
import java.util.List;
import modelo.Caja;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import modelo.Empleado;

public class CajaDAO implements ICajaDAO{

    @Override
    public void abrirCaja(Caja caja) throws Exception {
        String sql = """
                 INSERT INTO Caja
                 (
                    id_empleado_apertura,
                    fecha,
                    hora_apertura,
                    monto_apertura
                 )
                 VALUES (?,?,?,?)
                 """;

        try (Connection conn = new Conexion().conectar(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setInt(1, caja.getEmpleadoApertura().getIdEmpleado());
            ps.setDate(2, Date.valueOf(caja.getFecha()));
            ps.setTime(3, Time.valueOf(caja.getHoraApertura()));
            ps.setDouble(4, caja.getMontoApertura());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {
                    caja.setIdCaja(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al abrir la caja: " + e.getMessage());
        }
    }

    @Override
    public void cerrarCaja(Caja caja) throws Exception {
        String sql = """
                 UPDATE Caja
                 SET
                    id_empleado_cierre = ?,
                    hora_cierre = ?,
                    monto_cierre = ?,
                    estado = 'Cerrada'
                 WHERE id_caja = ?
                 """;

        try (Connection conn = new Conexion().conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, caja.getEmpleadoCierre().getIdEmpleado());

            if (caja.getHoraCierre() != null) {
                ps.setTime(2, Time.valueOf(caja.getHoraCierre()));
            } else {
                ps.setNull(2, Types.TIME);
            }

            ps.setDouble(3, caja.getMontoCierre());
            ps.setInt(4, caja.getIdCaja());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al cerrar la caja: " + e.getMessage());
        }
    }

    @Override
    public Caja buscarCajaPorID(int id) throws Exception {
        Caja caja = null;
        
        String sql = """
                    SELECT c.*,
                    ea.apellidos AS apellidos_apertura, ea.nombres AS nombres_apertura, ea.dni AS dni_apertura,
                    ec.apellidos AS apellidos_cierre, ec.nombres AS nombres_cierre, ec.dni AS dni_cierre
                    FROM Caja c
                    LEFT JOIN Empleado ea ON c.id_empleado_apertura = ea.id_empleado
                    LEFT JOIN Empleado ec ON c.id_empleado_cierre = ec.id_empleado
                    WHERE c.id_caja = ?
                    ORDER BY c.fecha DESC, c.hora_apertura DESC""";

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    caja = mapearCaja(rs);
                }
            }
            
            return caja;
        } catch (SQLException e) {
            throw new Exception("Error al buscar la caja por ID: " + e.getMessage());
        }
    }

    @Override
    public Caja buscarCajaAbierta() throws Exception {
        Caja caja = null;
        
        String sql = """
                    SELECT c.*,
                    ea.apellidos AS apellidos_apertura, ea.nombres AS nombres_apertura, ea.dni AS dni_apertura,
                    ec.apellidos AS apellidos_cierre, ec.nombres AS nombres_cierre, ec.dni AS dni_cierre
                    FROM Caja c
                    LEFT JOIN Empleado ea ON c.id_empleado_apertura = ea.id_empleado
                    LEFT JOIN Empleado ec ON c.id_empleado_cierre = ec.id_empleado
                    WHERE c.estado = ?
                    ORDER BY c.fecha DESC, c.hora_apertura DESC""";

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, "Abierta");
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    caja = mapearCaja(rs);
                }
            }
            
            return caja;
        } catch (SQLException e) {
            throw new Exception("Error al buscar una caja abierta: " + e.getMessage());
        }
    }
    
    @Override
    public List<Caja> buscarCajasPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        List<Caja> listaCajas = new ArrayList<>();
        
        String sql = """
                    SELECT c.*,
                    ea.apellidos AS apellidos_apertura, ea.nombres AS nombres_apertura, ea.dni AS dni_apertura,
                    ec.apellidos AS apellidos_cierre, ec.nombres AS nombres_cierre, ec.dni AS dni_cierre
                    FROM Caja c
                    LEFT JOIN Empleado ea ON c.id_empleado_apertura = ea.id_empleado
                    LEFT JOIN Empleado ec ON c.id_empleado_cierre = ec.id_empleado
                    WHERE c.fecha BETWEEN ? AND ?
                    ORDER BY c.fecha DESC, c.hora_apertura DESC""";
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setDate(1, Date.valueOf(fechaInicio));
            ps.setDate(2, Date.valueOf(fechaFin));
            
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaCajas.add(mapearCaja(rs));
                }
            }
            
            return listaCajas;
        } catch (SQLException e) {
            throw new Exception("Error al buscar la caja por rango de fechas: " + e.getMessage());
        }
    }

    @Override
    public List<Caja> verTodasLasCajas() throws Exception {
        List<Caja> listaCajas = new ArrayList<>();
        
        String sql = """
                    SELECT c.*,
                    ea.apellidos AS apellidos_apertura, ea.nombres AS nombres_apertura, ea.dni AS dni_apertura,
                    ec.apellidos AS apellidos_cierre, ec.nombres AS nombres_cierre, ec.dni AS dni_cierre
                    FROM Caja c
                    LEFT JOIN Empleado ea ON c.id_empleado_apertura = ea.id_empleado
                    LEFT JOIN Empleado ec ON c.id_empleado_cierre = ec.id_empleado
                    ORDER BY c.fecha DESC, c.hora_apertura DESC""";
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
            
            while (rs.next()) {
                listaCajas.add(mapearCaja(rs));
            }
            
            return listaCajas;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de las cajas: " + e.getMessage());
        }
    }

    @Override
    public List<Caja> buscarCajaPorEstado(String estado) throws Exception {
        List<Caja> listaCajas = new ArrayList<>();
        
        String sql = """
                    SELECT c.*,
                    ea.apellidos AS apellidos_apertura, ea.nombres AS nombres_apertura, ea.dni AS dni_apertura,
                    ec.apellidos AS apellidos_cierre, ec.nombres AS nombres_cierre, ec.dni AS dni_cierre
                    FROM Caja c
                    LEFT JOIN Empleado ea ON c.id_empleado_apertura = ea.id_empleado
                    LEFT JOIN Empleado ec ON c.id_empleado_cierre = ec.id_empleado
                    WHERE c.estado = ?
                    ORDER BY c.fecha DESC, c.hora_apertura DESC""";

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, estado);
            
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaCajas.add(mapearCaja(rs));
                }
            }
            
            return listaCajas;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de las cajas filtrados por estado: " + e.getMessage());
        }
    }
    
    private Caja mapearCaja(ResultSet rs) throws SQLException {
        Caja caja = new Caja();

        caja.setIdCaja(rs.getInt("id_caja"));
        
        Empleado empApertura = new Empleado();
        empApertura.setIdEmpleado(rs.getInt("id_empleado_apertura"));
        empApertura.setNombres(rs.getString("nombres_apertura"));
        empApertura.setApellidos(rs.getString("apellidos_apertura"));
        empApertura.setDni(rs.getString("dni_apertura"));
        caja.setEmpleadoApertura(empApertura);

        int idCierre = rs.getInt("id_empleado_cierre");
        if (!rs.wasNull()) {
            Empleado empCierre = new Empleado();
            empCierre.setIdEmpleado(idCierre);
            empCierre.setNombres(rs.getString("nombres_cierre"));
            empCierre.setApellidos(rs.getString("apellidos_cierre"));
            empCierre.setDni(rs.getString("dni_cierre"));
            caja.setEmpleadoCierre(empCierre);
        }
        
        caja.setFecha(rs.getDate("fecha").toLocalDate());

        caja.setHoraApertura(rs.getTime("hora_apertura").toLocalTime());

        Time horaCierre = rs.getTime("hora_cierre");
        if (horaCierre != null) {
            caja.setHoraCierre(horaCierre.toLocalTime());
        }
        
        caja.setMontoApertura(rs.getDouble("monto_apertura"));
        
        double montoCierre = rs.getDouble("monto_cierre");
        if (!rs.wasNull()) {
            caja.setMontoCierre(montoCierre);
        }
        
        caja.setEstado(rs.getString("estado"));

        return caja;
    }
    
}
