package sg.edu.nus.iss.vmcs.store;

public interface Iterator {
	public void next() ;
	public boolean hasNext();
	public boolean has(StoreItem i);
	public StoreItem getCurrent();
	public void reset();
}
