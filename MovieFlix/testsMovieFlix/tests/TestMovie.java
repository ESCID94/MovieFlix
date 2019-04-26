package tests;

import java.io.File;
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
import data.DAOUser;
import model.Genre;
import model.Movie;
import model.User;

public class TestMovie {
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
	public <T> void testAddMovie() throws SQLException {
		Movie m = new Movie();
		m.createMovie();
		DAOMovie<T> dao = new DAOMovie<T>();
		dao.add((T) m);
	}//completar 
	
	@Test
	public <T> void testDropMovie() throws SQLException {
		Movie m = new Movie();
		m.deleteMovie();;
		DAOMovie<T> dao = new DAOMovie<T>();
		dao.drop((T) m);
	}
	
	@Test
	public <T> void testUpdateMovie() throws SQLException {
		Movie m = new Movie("it", 14, Genre.ANIMACION, 0);	
		DAOMovie<T> dao = new DAOMovie<T>();
		dao.update((T) m);
		
	}
	
	
	@Test
	public void testGenre() {
		Movie movie = new Movie();
		String nombre = "POLICIACA";
		Genre.exists(nombre);
		
	}
	
	@Test
	public <T> void testAddMoviesFromFileWithCat() throws SQLException {
	
		File file = new File("ficheros/peliculas_cat.txt");		
		DAOMovie<T> dao = new DAOMovie<T>();	
		dao.addMoviesBBDD(file);
		
		
	}
	
	@Test
	public <T> void testAddMoviesFromFileWithnumCat() throws SQLException {
	
		File file = new File("ficheros/peliculas_numCat.txt");		
		DAOMovie<T> dao = new DAOMovie<T>();	
		dao.addMoviesBBDD(file);
		
		
	}
	
}
