/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.machinery;

import sg.edu.nus.iss.vmcs.system.*;
import sg.edu.nus.iss.vmcs.util.*;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import sg.edu.nus.iss.vmcs.store.*;

/**
 * This object controls the Change State use case.
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li, agarwal.puja
 */
//Observer Design Pattern - Observer
public class MachineryController implements Observer{
	/**This attribute reference to the MainController*/
	public MainController mainCtrl;
	/**This attribute reference to the StoreController*/
	public StoreController storeCtrl;

	private MachinerySimulatorPanel ml;
	private Door door;

	/**
	 * This constructor creates an instance of MachineryController.
	 */
	public MachineryController() {
		mainCtrl = MainController.getInstance();
		storeCtrl = MainController.getInstance().getStoreController();
		addToDrinkObservable(storeCtrl.getStoreItems(Store.DRINK));
		addToCoinObservable(storeCtrl.getStoreItems(Store.CASH));
	}

	/**
	 * This method returns the MainController.
	 * @return the MainController.
	 */
	public MainController getMainController() {
		return mainCtrl;
	}

	/**
	 * This method creates the Door.
	 * @throws VMCSException if fails to instantiate Door.
	 */
	public void initialize() throws VMCSException {
		door = new Door();
	}

	/**
	 * This method will close down the machinery functions of the vending machine.
	 */
	public void closeDown() {
		if (ml != null)
			ml.dispose();
	}

	/* ************************************************************
	 * Panel methods
	 */

	/**
	 * This method displays and initializes the MachinerySimulatorPanel.
	 */
	public void displayMachineryPanel() {
		SimulatorControlPanel scp = mainCtrl.getSimulatorControlPanel();
		if (ml == null)
			ml = new MachinerySimulatorPanel(scp, this);
		ml.display();
		scp.setActive(SimulatorControlPanel.ACT_MACHINERY, false);
	}

	/**
	 * This method close down the MachineryPanel.
	 */
	public void closeMachineryPanel() {
		if (ml == null)
			return;
		boolean ds = isDoorClosed();

		if (ds == false) {
			MessageDialog msg =
				new MessageDialog(ml, "Please Lock the Door before You Leave");
			msg.setVisible(true);
			return;
		}
		ml.dispose();
		SimulatorControlPanel scp = mainCtrl.getSimulatorControlPanel();
		scp.setActive(SimulatorControlPanel.ACT_MACHINERY, true);
	}

	/* ************************************************************
	 * Door methods
	 */

	/**
	 * This method determine whether the door is closed.
	 */
	public boolean isDoorClosed() {
		return door.isDoorClosed();
	}

	/**
	 * This method set the door state and display the door state.
	 * @param state TRUE to set the state to open, otherwise, set the state to closed.
	 */
	public void setDoorState(boolean state) {
		door.setState(state);
		displayDoorState();
		
		//Disable Activate Customer Panel Button
		mainCtrl.getSimulatorControlPanel().setActive(SimulatorControlPanel.ACT_CUSTOMER, false);
	}

	/* ************************************************************
	 * Display methods
	 */

	/**
	 * This method displays the current Door status (open or closed) on the Door Status display.
	 */
	public void displayDoorState() {
		if (ml == null)
			return;
		ml.setDoorState(door.isDoorClosed());
	}

	/**
	 * This method update drink stock view&#46;
	 * This method will get the stock values of drinks brands from the Drinks Store
	 * and display them on the Machinery SimulatorPanel.
	 * @throws VMCSException if fail to update drinks store display.
	 */
	public void displayDrinkStock() throws VMCSException {
		if (ml == null)
			return;
		ml.getDrinksStoreDisplay().update();
	}

	/**
	 * This method update coin stock view after transfer all cash&#46;
	 * This method will get the stock values of coin denominations from the CashStore and
	 * display them on the MachinerySimulatorPanel.
	 * @throws VMCSException if fail to update cash store display.
	 */
	public void displayCoinStock() throws VMCSException {
		if (ml == null)
			return;
		ml.getCashStoreDisplay().update();
	}

	/* ************************************************************
	 * Interactions with the Store that need to update the display
	 */

	/**
	 * This method will instruct the CashStore to store the Coin sent as input, and
	 * update the display on the MachinerySimulatorPanel.
	 * @throws VMCSException if fail to update cash store display.
	 */
	public void storeCoin(Coin c) throws VMCSException {
		System.out.println("store coin in mach ctrl being executed");
		storeCtrl.storeCoin(c);
		/*if (ml != null)
			ml.getCashStoreDisplay().update();*/
	}

	/**
	 * This method instructs the DrinksStore to dispense one drink, and then
	 * updates the MachinerySimulatorPanel.&#46; It returns TRUE or FALSE to indicate
	 * whether dispensing was successful.
	 * @param idx the index of the drinks store item.
	 * @throws VMCSException if fail to update cash store display.
	 */
	public void dispenseDrink(int idx) throws VMCSException {
		System.out.println("dispense drink in mach ctrl being executed");
		storeCtrl.dispenseDrink(idx);
		/*if (ml != null)
			ml.getCashStoreDisplay().update();*/

	}

	/**
	 * This method instructs the CashStore to issue a number of coins of a specific
	 * denomination, and then updates the MachinerySimulatorPanel&#46; It returns 
	 * TRUE or FALSE to indicate whether the change issue was successful.
	 * @param idx the index of the cash store item.
	 * @param numOfCoins the number of coins to change.
	 * @throws VMCSException if fail to update cash store display.
	 */
	public void giveChange(int idx, int numOfCoins) throws VMCSException {
		storeCtrl.giveChange(idx, numOfCoins);
		/*if (ml != null)
			ml.getCashStoreDisplay().update();*/
	}
	
	/**
	 * This method refresh the MachinerySimulatorPanel.
	 */
	public void refreshMachineryDisplay(){
		if(ml!=null){
			ml.refresh();
		}
	}
	
	/**
	 * This method adds this to observer list
	 */
	// Add this(observer) to all the store items - drinks (subjects)
	private void addToDrinkObservable(StoreItem[] storeItems){
		for(StoreItem item : storeItems)  
			item.addObserver(this);
	}
	
	/**
	 * This method adds this to observer list
	 */
	// Add this(observer) to all the store items - coins (subjects)
	private void addToCoinObservable(StoreItem[] storeItems){
		for(StoreItem item : storeItems)  
			item.addObserver(this);
	}

	/**
	 * update function to refresh the display items associated with it
	 */
	// Implementing the Observer pattern
	// - the following method is declared in the interface java.util.Observer
	@Override
	public void update(Observable storeItem, Object obj) {
		System.out.println("Quantity Observer being executed");
		if(ml != null){
			ml.refresh();
		}	
	}
	
}//End of class MachineryController