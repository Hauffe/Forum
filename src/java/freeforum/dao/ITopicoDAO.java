/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.dao;

import freeforum.model.Assunto;
import freeforum.model.Mensagem;
import freeforum.model.Topico;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public interface ITopicoDAO {
    
    public Topico inserir(Topico topico);
    public List<Topico> selecionarPorAssunto(Assunto assunto);
    public Topico selecionarPorId(int id, Assunto assunto);
    
}
