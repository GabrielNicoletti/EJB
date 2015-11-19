package br.com.dextra.treinamento.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dextra.treinamento.model.service.HelloWorldLocal;

@RequestScoped
@ManagedBean(name = "helloWorldBean")
public class HelloWorldBean {

	private HelloWorldLocal service;
	
	public HelloWorldBean(){				
		try{
			InitialContext ctx = new InitialContext();
			service = (HelloWorldLocal) ctx.lookup("blog/HelloWorldImpl/local");
		}catch(NamingException e){
			System.out.println("Erro ao carregar EJB.");
		}		
	}
	
	public void sayHello() {
		System.out.println(service.sayHello());
	}
	
}
