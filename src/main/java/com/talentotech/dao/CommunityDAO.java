package com.talentotech.dao;

import com.talentotech.model.Community;
import com.talentotech.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommunityDAO {

    private static final String INSERT = "INSERT INTO communities (nombre, region, poblacion, anyo_inicio, meta_energia_MW) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM communities ORDER BY nombre";
    private static final String DELETE = "DELETE FROM communities WHERE community_id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM communities WHERE community_id = ?";

    public int insertar(Community c) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getRegion());
            ps.setInt(3, c.getPoblacion());
            ps.setInt(4, c.getAnyoInicio());
            ps.setDouble(5, c.getMetaEnergiaMW());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List listarTodos() {
        List lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Community c = new Community();
                c.setCommunityId(rs.getInt("community_id"));
                c.setNombre(rs.getString("nombre"));
                c.setRegion(rs.getString("region"));
                c.setPoblacion(rs.getInt("poblacion"));
                c.setAnyoInicio(rs.getInt("anyo_inicio"));
                c.setMetaEnergiaMW(rs.getDouble("meta_energia_MW"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Community buscarPorId(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Community(
                            rs.getInt("community_id"),
                            rs.getString("nombre"),
                            rs.getString("region"),
                            rs.getInt("poblacion"),
                            rs.getInt("anyo_inicio"),
                            rs.getDouble("meta_energia_MW")
                    );
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public int eliminar(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) { return 0; }
    }
}