package sg.edu.nus.iss.vmcs.store;

public class StoreFactory {
	public Store getStore(String type)
	{
		String typeUpper = type.toUpperCase();
		switch (typeUpper) {
		case "CASH":
			return new CashStore();
		case "DRINKS":
			return new DrinksStore();

		default:
			return null;
		}
	}

}
