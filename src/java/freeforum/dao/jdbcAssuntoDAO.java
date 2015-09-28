/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.dao;

import freeforum.model.Assunto;
import freeforum.model.Mensagem;
import freeforum.model.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre
 */
public class jdbcAssuntoDAO implements IAssuntoDAO{

    private Connection conexao;

    public jdbcAssuntoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    
    @Override
    public List<Assunto> selecionarTodos() {
        String sql = "SELECT * FROM assunto";
        PreparedStatement ps;
        ResultSet rs = null;
        List<Assunto> assuntos = new ArrayList<Assunto>();
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                assuntos.add(populateObject(rs));
            }
            return assuntos;
        } catch (Exception e) {
            throw new DaoException(e.toString());
        }
    }
    
    @Override
    public Assunto selecionarPorId(int id) {
            String sql = "SELECT * FROM assunto "
                    + "WHERE "
                    + "id = ?";
            PreparedStatement ps;
            ResultSet rs;
            Assunto assunto = null;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                assunto = populateObject(rs);
            }
        } catch (Exception e) {
            throw new DaoException(e.toString());
        }
            return assunto;
    }
    
    public Assunto populateObject(ResultSet rs) throws SQLException{
       Assunto assunto = new Assunto(rs.getString("nome"));
       assunto.setId(rs.getInt("id"));
       return assunto;
    }


}
