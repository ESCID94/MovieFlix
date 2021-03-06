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

import data.DAOMovie;
import data.DAOWatchlist;
import model.Movie;
import model.Watchlist;
/**
 * The Class TestWatchlist
 * @author Lucas
 *
 */

public class TestWatchlist {
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
	public <T> void testAddWatchlist() throws SQLException {
		Watchlist w= new Watchlist();
		w.setIdMovie(42);
		w.setIdUser(136);
		DAOWatchlist<Watchlist> dao = new DAOWatchlist<Watchlist>();
		dao.add(w);
		
	}
		
}
