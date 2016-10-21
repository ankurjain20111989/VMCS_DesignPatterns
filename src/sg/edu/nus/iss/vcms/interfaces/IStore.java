package sg.edu.nus.iss.vcms.interfaces;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;

public interface IStore  {

	public void setStoreSize(int sz) ;
	public StoreItem[] getItems() ;
	public void addItem(int idx, StoreItem object);
	public StoreItem getStoreItem(int idx) ;
	public StoreObject findObject(String name);
	public void setQuantity(int idx, int qty);
	public int getStoreSize() ;
	public int findCashStoreIndex (Coin c);

}
