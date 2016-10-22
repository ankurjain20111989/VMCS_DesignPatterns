package sg.edu.nus.iss.vmcs.system;

import java.io.IOException;

import sg.edu.nus.iss.vmcs.store.PropertyLoader;
import sg.edu.nus.iss.vmcs.store.StoreItem;

/*
 * DBPropertyLoader -  The class is abstract for further implementation. Currently the persistent values are from Files , could be alternatively implemented by DB SQL Queries
 */
public abstract class DBPropertyLoader implements PropertyLoader {

	@Override
	public void initialize() throws IOException {
		
	}

	@Override
	public void saveProperty() throws IOException {
		
	}

	@Override
	abstract public int getNumOfItems() ;
	

	@Override
	abstract public void setNumOfItems(int numItems);

	@Override
	abstract public StoreItem getItem(int index);

	@Override
	abstract public void setItem(int index, StoreItem item) ;
		
	

	
}
