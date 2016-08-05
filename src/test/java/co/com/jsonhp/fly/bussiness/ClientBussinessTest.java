package co.com.jsonhp.fly.bussiness;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.jsonhp.fly.dao.ClientDao;
import co.com.jsonhp.fly.entities.Client;
import rx.Observable;

@RunWith(MockitoJUnitRunner.class)
public class ClientBussinessTest {

	Client client1, client2;
	List<Client> expected;
	
	@InjectMocks
	ClientBussiness clientBussiness;
	
	@Mock
	ClientDao clientDao;
	
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
		
		expected.add(client1);
		expected.add(client2);
	}
	
	@Test
	public void VerificarSiExisteClienteEspecifico() {
		//Arrange
		//Mockito.when(clientDao.getAll()).thenReturn(Observable.just(expected));
		
		
	}
	
	
	
}
