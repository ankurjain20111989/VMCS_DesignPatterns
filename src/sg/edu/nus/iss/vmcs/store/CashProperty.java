package sg.edu.nus.iss.vmcs.store;

public class CashProperty extends Property {
	
	//PropertyLoader propertyLoader;
	
	public CashProperty(PropertyLoader propertyLoader){
		super(propertyLoader);
	}
	public StoreItem getItem (int index) {
		StoreItem storeItem = propertyLoader.getItem(index);
		return storeItem;
	}
	public void setItem(int index, StoreItem cashItem) {
			propertyLoader.setItem(index, cashItem);
	}
	
	public int getNumOfItems() {
			int noOfItems = propertyLoader.getNumOfItems();
			return noOfItems;
	}
	public void setNumOfItems(int numItems){
		propertyLoader.setNumOfItems(numItems);
	}
	public void saveProperty(){
		try{
			propertyLoader.saveProperty();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
