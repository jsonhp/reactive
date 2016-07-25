package co.com.jsonhp.fly.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.jsonhp.fly.entities.Client;
import rx.Observable;

@RunWith(MockitoJUnitRunner.class)
public class ClientDaoTest {
	
	Client client1, client2;
	List<Client> expected;
	String queryFindAll = "client.findAll";
	List<Client> myListClients;
	
	@InjectMocks
	ClientDao clientDao;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	TypedQuery<Client> query;

	@Before
	public void setUp() {
		client1 = new Client();
		client1.setId(1);
		client1.setName("JSon");
		client1.setLastname("HP");
		
		client2 = new Client();
		client2.setId(2);
		client2.setName("Pinky");
		client2.setLastname("HP");
		
		expected =  new ArrayList<Client>();
		expected.add(client1);
		expected.add(client2);
	}
	
	@Test
	public void debeObtenerTodosLosClientes() {
		
		//Arrange
		Mockito.when(entityManager.createNamedQuery(queryFindAll, Client.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		//Act
		Observable<List<Client>> listClients = clientDao.getAll();
		listClients.subscribe(list -> myListClients = list);
		
		//Assert
		Mockito.verify(query).getResultList();
		assertEquals(expected, myListClients);
		
	}
	
}
