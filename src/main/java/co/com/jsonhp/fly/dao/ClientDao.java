package co.com.jsonhp.fly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.com.jsonhp.fly.entities.Client;
import rx.Observable;

public class ClientDao {
	
	String queryFindAll = "client.findAll";
	
	@PersistenceContext
	EntityManager entityManager;

	public Observable<List<Client>> getAll() {
		TypedQuery<Client> query = entityManager.createNamedQuery(queryFindAll, Client.class);
		return Observable.just(query.getResultList());
	}

}
