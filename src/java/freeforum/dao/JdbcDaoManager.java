package freeforum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcDaoManager implements IDaoManager 
{
    Connection conexao;
    jdbcAssuntoDAO assuntoDao;
    jdbcTopicoDAO topicoDao;
    jdbcMensagemDAO mensagemDao;
    
    public JdbcDaoManager()
    {
        assuntoDao = new jdbcAssuntoDAO(conexao);
        topicoDao = new jdbcTopicoDAO(conexao);
        mensagemDao = new jdbcMensagemDAO(conexao);
    }
    
    
    @Override
    public void iniciar() throws DaoException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/forum";
            conexao = DriverManager.getConnection(url, "root", "");
            conexao.setAutoCommit(false);
            assuntoDao.setConexao(conexao);
            topicoDao.setConexao(conexao);
            mensagemDao.setConexao(conexao);
        }
        catch( Exception ex )
        {
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados:" + 
                    ex.getMessage());
        }
    }

    @Override
    public void encerrar() 
    {
        try {
            if(!conexao.isClosed())
                conexao.close();
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void confirmarTransacao() {
        try{
            conexao.commit();            
        }catch(SQLException ex){
            throw new DaoException("Erro" + ex.toString());
        }
        
    }

    @Override
    public void abortarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAssuntoDAO getAssuntoDao() 
    {
        return assuntoDao;
    }

    @Override
    public ITopicoDAO getTopicoDao() {
       return topicoDao;
    }
    
    @Override
    public IMensagemDAO getMensagemDao() {
       return mensagemDao;
    }


}
