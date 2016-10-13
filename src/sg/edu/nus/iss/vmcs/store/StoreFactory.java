package sg.edu.nus.iss.vmcs.store;

public class StoreFactory {
	/**
	 * This methos accepts a string and based on it, returns the type of Store.
	 * @param storeType
	 * @return
	 */
	public Store getStore(String storeType)
	{
		String type= storeType.toUpperCase();
		switch(type)
		{
		case "CASH":
			return new CashStore();
		case "DRINKS":
			return new DrinksStore();
		default:
			return null;
		}
	}

}
