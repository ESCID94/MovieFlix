package tests;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import connection.ConnectionBBDD;
import data.DAOMovie;
import data.DAOSubscription;
import data.DAOUser;
import model.Genre;
import model.Movie;
import model.Subscription;
import model.TypeCatalog;
import model.User;

public class TestSubscription {
	
	private static Logger logger; 
	
	// Inicializo
		static {
			try {
				logger = LogManager.getLogger(TestUser.class);
			} catch (Throwable e) {
				System.out.println("Don't work");
			}
		}

		@BeforeClass
		public static void onceExecutedBeforeAll() {
			logger.info("@BeforeClass: Al inicio de las pruebas");
		}

		@Before
		public void executedBeforeEach() {
			// Sustituye al setUp
			logger.info("@Before: Antes de cada prueba");
		
		}

		@AfterClass
		public static void onceExecutedAfterAll() {
			logger.info("@AfterClass: Al final de las pruebas");
		}

		@After
		public void executedAfterEach() {
			// Sustituye al tearDown
			logger.info("@After: Despues de cada prueba");
		
		}

		@Ignore
		//Puedes usarlo en vez de comentar el método para que no se ejecute
		//http://junit.sourceforge.net/javadoc/org/junit/Ignore.html
		public void executionIgnored() {
			logger.info("@Ignore: This execution is ignored");
		}

		// --------
		// TEST
		// --------

		@Test
		public void testConnection() throws SQLException {
			ConnectionBBDD connection = new ConnectionBBDD();
			logger.info("TestConnection()");
		}
		
		@Test
		public <T> void testAddSubscription() throws SQLException {
			Subscription s = new Subscription();
			s.createSubscription();
			DAOSubscription<T> dao = new DAOSubscription<T>();
			dao.add((T) s);
		} 
		
		@Test
		public <T> void testDropSubscription() throws SQLException {
			User u = new User();
			u.setNameUser("alvaro");
			u.setLastName("gonzalez");
			Subscription sub = new Subscription(100,136,20,"efectivo",TypeCatalog.BASIC);
			u.setSub(sub);
			u.deleteSubscription(u);
			DAOSubscription<T> dao = new DAOSubscription<T>();
			dao.drop((T) u);
		} 
		
		@Test
		public <T> void testUpdateSubscription() throws SQLException {
			User u = new User();
			u.setNameUser("alvaro");
			u.setLastName("gonzalez");
			Subscription sub = new Subscription(100,136,20,"efectivo",TypeCatalog.BASIC);
			u.setSub(sub);
			u.updateSubscription(u);
			DAOSubscription<T> dao = new DAOSubscription<T>();
			dao.update((T) u);
		} 
		
		

}
