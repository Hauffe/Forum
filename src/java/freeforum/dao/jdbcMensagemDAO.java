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
 *
 * @author Alexandre
 */
public class jdbcMensagemDAO implements IMensagemDAO{
    
    private Connection conexao;

    public jdbcMensagemDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    

    @Override
    public List<Mensagem> selecionarPorTopico(Topico topico, Assunto assunto) {
        List<Mensagem> mensagens = new ArrayList<Mensagem>();
        String sql = "SELECT * FROM mensagem "
                + "WHERE "
                + "topico_id = ? "
                + "ORDER BY data DESC";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, topico.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                mensagens.add(populateObject(rs, topico, assunto));
            }
            return mensagens;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }        
    }
        
    @Override
    public Mensagem inserirMensagem(Mensagem mensagem) {
        String sql = "INSERT INTO mensagem"
                + "(nome, data, conteudo, topico_id, topico_assunto_id) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, mensagem.getNome());
            ps.setDate(2, new java.sql.Date(mensagem.getData().getTime()));
            ps.setString(3, mensagem.getConteudo());
            ps.setInt(4, mensagem.getTopico().getId());
            ps.setInt(5, mensagem.getAssunto().getId());
            ps.executeUpdate();
            return mensagem;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
        
    }
        
    @Override
    public List<Mensagem> selecionarPorAssunto(Topico topico, Assunto assunto) {
        List<Mensagem> mensagens = new ArrayList<Mensagem>();
        String sql = "SELECT * FROM mensagem "
                + "WHERE "
                + "topico_assunto_id = ? "
                + "ORDER BY data DESC";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, assunto.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                mensagens.add(populateObject(rs, topico, assunto));
            }
            return mensagens;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }  
    }
    
    
        public Mensagem populateObject(ResultSet rs, Topico topico, Assunto assunto) throws SQLException{
            Mensagem mensagem = new Mensagem(topico, assunto);
            mensagem.setId(rs.getInt("id"));
            mensagem.setNome(rs.getString("nome"));
            mensagem.setData(rs.getDate("data"));
            mensagem.setConteudo(rs.getString("conteudo"));
            return mensagem;
        }


        
    }

