			package sg.edu.nus.iss.vmcs.system;
			
			import java.awt.event.ActionEvent;
			import java.awt.event.ActionListener;
			
			public class SimulationListener implements ListenerStrategy,ActionListener{
			private SimulationController ctrl;
			
			
				
			public SimulationListener(SimulationController ct) {
				ctrl = ct;
				}
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				switch(e.getActionCommand())
				{
				case SimulatorControlPanel.L_ACT_CUSTOMER:
					ctrl.setupCustomer();
					break;
					
				case SimulatorControlPanel.L_ACT_MACHINERY:
					ctrl.setupSimulator();
					break;
					
				case SimulatorControlPanel.L_ACT_MAINTAINER:
					ctrl.setupMaintainer();
					break;
					
				case SimulatorControlPanel.L_SIMUL_BEGIN:	
					ctrl.start();
					break;
					
				default:
					break;
				}
			}

}