package sg.edu.nus.iss.vmcs.store;

public   class Property {
	PropertyLoader propertyLoader;
	public  Property(PropertyLoader propertyLoader){
		this.propertyLoader = propertyLoader;
	}
	public PropertyLoader getLoader(){
			return propertyLoader;
	}
}
