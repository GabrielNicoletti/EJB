package br.com.dextra.treinamento.controller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dextra.treinamento.model.domain.Categoria;
import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.PostServiceLocal;

@ManagedBean(name = "listarPostsMB")
@SessionScoped
public class ListarPostsMB {

	private String titulo;
	
	private String descricao;
	
	private Categoria categoria;

	private List<Categoria> possiveisCategorias;
	
	List<Post> posts;

	private Post novoPost;
	
	public String listar() {
		PostServiceLocal postService;
		try {
			InitialContext initialContext = new InitialContext();
			postService = (PostServiceLocal) initialContext.lookup("blog/PostServiceImpl/local");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		} 
		
		posts = postService.listar();
		
		return "listarPosts.xhtml";
	}
	
	public void adicionarMensagem(String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		FacesMessage facesMessage = new FacesMessage(mensagem);
		facesContext.addMessage(null, facesMessage);
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String incluir() {
		this.novoPost = new Post();
		
		return "incluirPost.xhtml";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Categoria> getPossiveisCategorias() {
		return possiveisCategorias;
	}

	public void setPossiveisCategorias(List<Categoria> possiveisCategorias) {
		this.possiveisCategorias = possiveisCategorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String salvar() {
		PostServiceLocal postService;
		try {
			InitialContext initialContext = new InitialContext();
			postService = (PostServiceLocal) initialContext.lookup("blog/PostServiceImpl/local");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		
		postService.salvar(novoPost);
		
		posts = postService.listar();
		
		return "listarPosts.xhtml";
	}
	
	public String cancelar() {
		return "listarPosts.xhtml";
	}

	public Post getNovoPost() {
		return novoPost;
	}

	public void setNovoPost(Post novoPost) {
		this.novoPost = novoPost;
	}
}
