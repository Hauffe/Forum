/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.model;

import freeforum.dao.IDaoManager;
import freeforum.dao.IMensagemDAO;
import freeforum.dao.ITopicoDAO;
import freeforum.dao.JdbcDaoManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class MensagemMng implements IMensagemMng{

    IDaoManager maneger = new JdbcDaoManager();
    IMensagemDAO dao = maneger.getMensagemDao();
    
    @Override
    public List<Mensagem> selecionarPorTopico(Topico topico, Assunto assunto) {
        List<Mensagem> mensagens = new ArrayList<Mensagem>();
        
        try {
            maneger.iniciar();
            mensagens = dao.selecionarPorTopico(topico, assunto);
            maneger.confirmarTransacao();
            maneger.encerrar();
            return mensagens;
        } catch (Exception e){
            maneger.abortarTransacao();
            throw e;
        }
    }

    @Override
    public Mensagem inserirMensagem(Mensagem mesagem) {
        Mensagem mensagem = null;
        try {
            maneger.iniciar();
            mensagem = dao.inserirMensagem(mesagem);
            maneger.confirmarTransacao();
            maneger.encerrar();
            return mensagem;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }
    
}
