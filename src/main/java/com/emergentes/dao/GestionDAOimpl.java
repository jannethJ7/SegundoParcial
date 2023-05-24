package com.emergentes.dao;

import com.emergentes.modelo.Gestion;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestionDAOimpl extends ConexionDB implements GestionDAO {

    @Override
    public void insert(Gestion gestion) throws Exception {
        String sql = "insert into productos (descripcion, cantidad, precio, categoria) values (?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, gestion.getDescripcion());
        ps.setInt(2, gestion.getCantidad());
        ps.setFloat(3, gestion.getPrecio());
        ps.setString(4, gestion.getCategoria());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Gestion gestion) throws Exception {
        String sql = "update productos set descripcion=?, cantidad=?, precio=?, categoria=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, gestion.getDescripcion());
        ps.setInt(2, gestion.getCantidad());
        ps.setFloat(3, gestion.getPrecio());
        ps.setString(4, gestion.getCategoria());
        ps.setInt(5, gestion.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from productos where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Gestion> getAll() throws Exception {
        List<Gestion> lista = null;
        String sql = "select * from productos";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Gestion>();
        while (rs.next()) {
            Gestion ges = new Gestion();

            ges.setId(rs.getInt("id"));
            ges.setDescripcion(rs.getString("descripcion"));
            ges.setCantidad(rs.getInt("cantidad"));
            ges.setPrecio(rs.getFloat("precio"));
            ges.setCategoria(rs.getString("categoria"));

            lista.add(ges);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Gestion getById(int id) throws Exception {
        Gestion ges = new Gestion();
        try {
            String sql = "select * from productos where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ges.setId(rs.getInt("id"));
                ges.setDescripcion(rs.getString("descripcion"));
                ges.setCantidad(rs.getInt("cantidad"));
                ges.setPrecio(rs.getFloat("precio"));
                ges.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ges;
    }

}
