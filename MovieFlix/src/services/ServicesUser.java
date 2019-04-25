package services;

import java.sql.SQLException;

import data.DAOUser;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicesUser.
 *
 * @param <T> the generic type
 */
public class ServicesUser<T> implements IServices<T> {

	/* (non-Javadoc)
	 * @see services.IServices#add(java.lang.Object)
	 */
	@Override
	public void add(T t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see services.IServices#drop(java.lang.Object)
	 */
	@Override
	public void drop(T t) throws SQLException {
		// TODO Auto-generated method stub
		DAOUser<T> daou= new DAOUser<T>();
		daou.drop(t);
		
	}

	/* (non-Javadoc)
	 * @see services.IServices#alter(java.lang.Object)
	 */
	@Override
	public void alter(T t) throws SQLException {
		// TODO Auto-generated method stub
		DAOUser<T> daou= new DAOUser<T>();
		daou.alter(t);
		
	}



}
