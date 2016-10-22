package sg.edu.nus.iss.vmcs.store;

public interface Iterator {
	public StoreItem next();
	public boolean hasNext();
}
