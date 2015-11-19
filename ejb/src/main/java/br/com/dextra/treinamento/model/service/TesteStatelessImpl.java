package br.com.dextra.treinamento.model.service;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.ejb.Stateless;

@Stateless
public class TesteStatelessImpl implements TesteStatelessLocal {

	private Integer contador = 0;
	
	public Integer adicionar() {
		contador++;
		try {
			int x = sortearTempo();
			
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return contador;
	}

	private static int sortearTempo() {
		Random r = new Random(System.currentTimeMillis());
		int x = r.nextInt() % 5;
		x = x * 1000;
		if (x < 0) {
			x = x * -1;
		}
		return x;
	}
}
