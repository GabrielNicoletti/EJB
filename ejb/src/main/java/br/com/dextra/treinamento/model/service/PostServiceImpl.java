package br.com.dextra.treinamento.model.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dextra.treinamento.model.domain.Post;

@Stateless
public class PostServiceImpl implements PostServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Post> listar() {
		String hql = "FROM Post";
		
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	public void salvar(Post p) {
		em.merge(p);
	}
}
