package br.com.dextra.treinamento.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import br.com.dextra.treinamento.model.service.SomaLocal;

@RequestScoped
@ManagedBean(name = "somaBean")
public class SomaBean {

	private SomaLocal service;
	
	public SomaBean(){
		try{
			InitialContext ctx = new InitialContext();
			service = (SomaLocal) ctx.lookup("blog/SomaImpl/local");
		}catch(NamingException e){
			System.out.println("Erro ao carregar EJB.");
		}		
	}
	
	public void soma(){
		System.out.println(service.soma(1, 2));
	}
	
	
}
