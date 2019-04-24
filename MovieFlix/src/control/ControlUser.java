package control;

import model.User;

public class ControlUser implements IControl<User> {
	IControl data = new ControlUser();
	@Override
	public Object add() {
		// TODO Auto-generated method stub
		return data.add();
	}

	@Override
	public Object drop() {
		// TODO Auto-generated method stub
		return data.drop();
	}

	@Override
	public Object alter() {
		// TODO Auto-generated method stub
		 return data.add();
	}
}
