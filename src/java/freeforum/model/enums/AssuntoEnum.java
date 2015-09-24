/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.model.enums;
/**
 * @author Alexandre
 */
public enum AssuntoEnum {
    
        JOGOS('J',"jogos"),
	FILMES('F',"filmes"),
	SERIES('S',"series"),
	COMIDA('C',"comida"),
	MUSICA('M',"musica");
	
	char tipo;
	String nome;
	
	private AssuntoEnum(char tipo, String nome) {
		this.tipo = tipo;
		this.nome = nome;
	}

	public char getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}
        
        
        public static AssuntoEnum getBy(char tipoAssunto) {
            for(AssuntoEnum tipo : AssuntoEnum.values()){
                if(tipo.getTipo() == tipoAssunto){
                        return tipo;
                }
            }
        return null;
	}
	
}
