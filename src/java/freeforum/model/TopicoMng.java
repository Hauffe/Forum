/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.model;

import freeforum.dao.IDaoManager;
import freeforum.dao.ITopicoDAO;
import freeforum.dao.JdbcDaoManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class TopicoMng implements ITopicoMng{

    IDaoManager maneger = new JdbcDaoManager();
    ITopicoDAO dao = maneger.getTopicoDao();
    
    @Override
    public Topico novoTopico(Topico topico) {
        try {
            maneger.iniciar();
            Topico t;
            t = dao.inserir(topico);
            maneger.confirmarTransacao();
            maneger.encerrar();
            return t;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
        
    }

    @Override
    public List<Topico> selecionarPorAssunto(Assunto assunto) {
        List<Topico> topicos = new ArrayList<Topico>();
        
        try {
            maneger.iniciar();
            topicos = dao.selecionarPorAssunto(assunto);
            maneger.confirmarTransacao();
            maneger.encerrar();
            return topicos;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }
    
}
