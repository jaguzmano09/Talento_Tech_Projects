package com.talentotech.dao;

import com.talentotech.model.EnergyProject;
import com.talentotech.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnergyProjectDAO {

    private static final String INSERT =
            "INSERT INTO energy_projects (community_id, tipo_proyecto, capacidad_MW, fecha_lanzamiento, estado) " +
                    "VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_ALL =
            "SELECT * FROM energy_projects ORDER BY fecha_lanzamiento DESC";

    private static final String SELECT_BY_ID =
            "SELECT * FROM energy_projects WHERE project_id = ?";

    private static final String DELETE =
            "DELETE FROM energy_projects WHERE project_id = ?";

    // INSERTAR
    public int insertar(EnergyProject p) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT)) {

            ps.setInt(1, p.getCommunity_id());
            ps.setString(2, p.getTipo_proyecto());
            ps.setDouble(3, p.getCapacidad_MW());

            // LocalDate → java.sql.Date
            ps.setDate(4, Date.valueOf(p.getFecha_lanzamiento()));
            ps.setString(5, p.getEstado());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // LISTAR TODOS
    public List<EnergyProject> listarTodos() {
        List<EnergyProject> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EnergyProject p = new EnergyProject();

                p.setProject_id(rs.getInt("project_id"));
                p.setCommunity_id(rs.getInt("community_id"));
                p.setTipo_proyecto(rs.getString("tipo_proyecto"));
                p.setCapacidad_MW(rs.getDouble("capacidad_MW"));

                // sql.Date → LocalDate
                Date fecha = rs.getDate("fecha_lanzamiento");
                if (fecha != null) {
                    p.setFecha_lanzamiento(fecha.toLocalDate());
                }

                p.setEstado(rs.getString("estado"));

                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // BUSCAR POR ID
    public EnergyProject buscarPorId(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    LocalDate fecha = null;
                    Date sqlDate = rs.getDate("fecha_lanzamiento");
                    if (sqlDate != null) fecha = sqlDate.toLocalDate();

                    return new EnergyProject(
                            rs.getInt("project_id"),
                            rs.getInt("community_id"),
                            rs.getString("tipo_proyecto"),
                            rs.getDouble("capacidad_MW"),
                            rs.getString("estado"),
                            fecha
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ELIMINAR
    public int eliminar(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE)) {

            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
