package br.com.dextra.treinamento.model.service;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldImpl implements HelloWorldLocal{
	

	@Override
	public String sayHello() {		
		return "Hello World";
	}
	

}
