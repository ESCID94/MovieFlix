package services;

import java.sql.SQLException;

import data.DAOCatalog;
import data.DAOMovie;
import data.DAOSubscription;
import data.DAOUser;
import data.DAOWatchlist;
import model.Catalog;
import model.Movie;
import model.Subscription;
import model.User;
import model.Watchlist;

public class ServicesImp<T> implements IServices<T> {

	//Implementacion de servicios que redirige cada metodo a su respectivo DAO
	
	private User user = new User();
	private Movie movie = new Movie();
	private Catalog catalog = new Catalog();
	private Subscription sub = new Subscription();
	private Watchlist watchlist = new Watchlist();
	
	@Override
	public void add(T t) throws SQLException {
		// TODO Auto-generated method stub
		
		if (t.getClass().equals(user.getClass())){
			((User) t).createUser();
			DAOUser<T> daoUser = new DAOUser<T>();
			daoUser.add(t);
		}
		else if (t.getClass().equals(movie.getClass())){
			((Movie) t).createMovie();
			DAOMovie<T> daoMov = new DAOMovie<T>();
			daoMov.add(t);
		}
		else if (t.getClass().equals(catalog.getClass())){
			((Catalog) t).createCatalog();
			DAOCatalog<T> daoCat = new DAOCatalog<T>();
			daoCat.add(t);
		}
		else if (t.getClass().equals(sub.getClass())){
			((Subscription) t).createSubscription();
			DAOSubscription<T> daoSub = new DAOSubscription<T>();
			daoSub.add(t);
		}
		else if (t.getClass().equals(watchlist.getClass())){
			((Watchlist) t).createWatchList();
			DAOWatchlist<T> daoWatchlist = new DAOWatchlist<T>();
			daoWatchlist.add(t);
		}
		
		
		
	}

	@Override
	public void drop(T t) throws SQLException {
		// TODO Auto-generated method stub
		
		if (t.getClass().equals(user.getClass())){
			((User) t).deleteAccount();
			DAOUser<T> daoUser = new DAOUser<T>();
			daoUser.drop(t);
		}
		else if (t.getClass().equals(movie.getClass())){
			((Movie) t).deleteMovie();
			DAOMovie<T> daoMov = new DAOMovie<T>();
			daoMov.drop(t);
		}
		else if (t.getClass().equals(catalog.getClass())){
			((Catalog) t).deleteCatalog();
			DAOCatalog<T> daoCat = new DAOCatalog<T>();
			daoCat.drop(t);
		}
		else if (t.getClass().equals(sub.getClass())){
			((Subscription) t).deleteSubscription();
			DAOSubscription<T> daoSub = new DAOSubscription<T>();
			daoSub.drop(t);
		}
		else if (t.getClass().equals(watchlist.getClass())){
			((Watchlist) t).deleteWatchlist();
			DAOWatchlist<T> daoWatchlist = new DAOWatchlist<T>();
			daoWatchlist.drop(t);
		}
		
	}

	@Override
	public void update(T t) throws SQLException {
		// TODO Auto-generated method stub
		if (t.getClass().equals(user.getClass())){
			((User) t).updateUser((User) t);
			DAOUser<T> daoUser = new DAOUser<T>();
			daoUser.update(t);
		}
		else if (t.getClass().equals(movie.getClass())){
			((Movie) t).updateMovie((Movie) t);
			DAOMovie<T> daoMov = new DAOMovie<T>();
			daoMov.update(t);
		}
		else if (t.getClass().equals(catalog.getClass())){
			((Catalog) t).updateCatalog((Catalog) t);
			DAOCatalog<T> daoCat = new DAOCatalog<T>();
			daoCat.update(t);
		}
		else if (t.getClass().equals(sub.getClass())){
			((Subscription) t).updateSub((Subscription) t);
			DAOSubscription<T> daoSub = new DAOSubscription<T>();
			daoSub.update(t);
		}
		else if (t.getClass().equals(watchlist.getClass())){
			((Watchlist) t).updateWatchlist((Watchlist) t);
			DAOWatchlist<T> daoWatchlist = new DAOWatchlist<T>();
			daoWatchlist.update(t);
		}
	}

	

}
