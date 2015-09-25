/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.model;

import freeforum.dao.IAssuntoDAO;
import freeforum.dao.IDaoManager;
import freeforum.dao.JdbcDaoManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class AssuntoMng implements IAssuntoMng{

    IDaoManager maneger = new JdbcDaoManager();;
    
    @Override
    public List<Assunto> obterTodos() {
        List<Assunto> assuntos = new ArrayList<Assunto>();
        
        try {
            maneger.iniciar();
            IAssuntoDAO dao = maneger.getAssuntoDao();
            assuntos = dao.selecionarTodos();
            maneger.confirmarTransacao();
            maneger.encerrar();
            return assuntos;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }

    @Override
    public Assunto obterPorId(int id) {
        Assunto assunto;
        
        try {
            maneger.iniciar();
            IAssuntoDAO dao = maneger.getAssuntoDao();
            assunto = dao.selecionarPorId(id);
            maneger.confirmarTransacao();
            maneger.encerrar();
            return assunto;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }
    
    
}
