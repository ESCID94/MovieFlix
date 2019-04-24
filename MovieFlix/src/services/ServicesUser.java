package services;

public class ServicesUser implements IServices {
	
	IServices <?> datos = new ServicesUser();
	
	@Override
	public Object add() {
		// TODO Auto-generated method stub
		return datos.add();
	}

	@Override
	public Object drop() {
		// TODO Auto-generated method stub
		return datos.drop();
	}

	@Override
	public Object alter() {
		// TODO Auto-generated method stub
		 return datos.add();
	}
}
