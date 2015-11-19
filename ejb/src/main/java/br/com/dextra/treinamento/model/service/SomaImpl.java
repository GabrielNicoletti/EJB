package br.com.dextra.treinamento.model.service;

import javax.ejb.Stateless;

@Stateless
public class SomaImpl implements SomaLocal{

	@Override
	public int soma(int a, int b) {
		int x = a + b;
		return x;
	}

	
}
