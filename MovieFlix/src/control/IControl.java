package control;

import java.sql.SQLException;

public interface IControl <T> {
	
	public void add(T t) throws SQLException;
	public void drop(T t) throws SQLException;
	public void alter(T t) throws SQLException;
}
