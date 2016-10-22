package sg.edu.nus.iss.vmcs.store;

public interface Iterator {
	public StoreItem next();
	public boolean hasNext();
	public boolean has(StoreItem i);
	
	
	public StoreItem getCurrent();
}
