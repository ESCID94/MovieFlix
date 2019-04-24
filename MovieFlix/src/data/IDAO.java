package data;

import java.sql.SQLException;

public interface IDAO <T> {

	public void add(T t) throws SQLException;
	public void drop(T t) throws SQLException;
	public void alter(T t) throws SQLException;
}
