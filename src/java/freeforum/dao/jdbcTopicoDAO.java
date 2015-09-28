/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.dao;

import freeforum.model.Assunto;
import freeforum.model.Mensagem;
import freeforum.model.Topico;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class jdbcTopicoDAO implements ITopicoDAO{

    private Connection conexao;

    public jdbcTopicoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public Topico inserir(Topico topico) {
        String sql = "INSERT INTO topico "
                + "(titulo, nome, data, pergunta, assunto_id) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, topico.getTitulo());
            ps.setString(2, topico.getNome());
            ps.setDate(3, new java.sql.Date(topico.getData().getTime()));
            ps.setString(4, topico.getPergunta());
            ps.setInt(5, topico.getAssunto().getId());
            
            ps.executeUpdate();
            return topico;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public List<Topico> selecionarPorAssunto(Assunto assunto) {
        
        List<Topico> topicos = new ArrayList<Topico>();
        
        String sql = "SELECT * from topico "
                + "WHERE "
                + "assunto_id = ?";
        
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, assunto.getId());
            rs = ps.executeQuery();
            while (rs.next()) {                
                topicos.add(populateObject(rs, assunto));
            }
            return topicos;
        } catch (Exception e) {
            throw new DaoException(sql + "" + e.getMessage());
        }
    }
    
    @Override
    public Topico selecionarPorId(int id, Assunto assunto) {
        String sql = "SELECT * FROM topico "
                + "WHERE "
                + "id = ?";
        PreparedStatement ps;
        ResultSet rs;
        Topico topico = null;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                topico = populateObject(rs, assunto);
            }
        } catch (Exception e) {
            throw new DaoException(sql + "" + e.getMessage());
        }
        return topico;
        
    }
    
    
    public Topico populateObject(ResultSet rs, Assunto assunto) throws SQLException{
       Topico topico = new Topico(assunto);
       topico.setId(rs.getInt("id"));
       topico.setTitulo(rs.getString("titulo"));
       topico.setNome(rs.getString("nome"));
       topico.setData(rs.getDate("data"));
       topico.setPergunta(rs.getString("pergunta"));
       topico.setMensagens(null);
       return topico;
    }


    
}
