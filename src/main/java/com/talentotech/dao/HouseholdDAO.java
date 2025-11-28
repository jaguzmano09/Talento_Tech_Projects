package com.talentotech.dao;

import com.talentotech.model.Household;
import com.talentotech.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseholdDAO {

    private static final String INSERT =
            "INSERT INTO households (community_id, direccion, num_residentes, nivel_socioeco) VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL =
            "SELECT * FROM households ORDER BY household_id";

    private static final String SELECT_BY_ID =
            "SELECT * FROM households WHERE household_id = ?";

    private static final String DELETE =
            "DELETE FROM households WHERE household_id = ?";

    // INSERTAR
    public int insertar(Household h) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT)) {

            ps.setInt(1, h.getCommunityId());
            ps.setString(2, h.getDireccion());
            ps.setInt(3, h.getNumResidentes());
            ps.setString(4, h.getNivelSocioeco());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // LISTAR
    public List<Household> listarTodos() {
        List<Household> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Household h = new Household();
                h.setHouseholdId(rs.getInt("household_id"));
                h.setCommunityId(rs.getInt("community_id"));
                h.setDireccion(rs.getString("direccion"));
                h.setNumResidentes(rs.getInt("num_residentes"));
                h.setNivelSocioeco(rs.getString("nivel_socioeco"));

                lista.add(h);
            }
        } catch (SQLException e) { e.printStackTrace(); }

        return lista;
    }

    // BUSCAR POR ID
    public Household buscarPorId(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Household(
                            rs.getInt("household_id"),
                            rs.getInt("community_id"),
                            rs.getString("direccion"),
                            rs.getInt("num_residentes"),
                            rs.getString("nivel_socioeco")
                    );
                }
            }

        } catch (SQLException e) { e.printStackTrace(); }

        return null;
    }

    // ELIMINAR
    public int eliminar(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE)) {

            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) { return 0; }
    }
}
