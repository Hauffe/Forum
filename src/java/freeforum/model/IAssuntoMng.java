/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.model;

import java.util.List;

/**
 *
 * @author Alexandre
 */
public interface IAssuntoMng {
    
    List<Assunto> obterTodos();
    List<Topico> obterTopicos(Assunto assunto);
    List<Mensagem> obterMensagens(Topico topico, Assunto assunto);
    Assunto obterPorId(int id);
    
    
    
}
