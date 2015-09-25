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
public interface ITopicoMng {
    
    Topico novoTopico(Topico topico);
    List<Topico> selecionarPorAssunto(Assunto assunto);
    
}
