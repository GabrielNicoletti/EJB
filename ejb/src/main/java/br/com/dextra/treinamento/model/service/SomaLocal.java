package br.com.dextra.treinamento.model.service;

import javax.ejb.Local;

@Local
public interface SomaLocal {

	public int soma(int a, int b);
	
}
