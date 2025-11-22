

package xcom.retro.RetroShield.frontpanel.frontpanels ;


import java.awt.BorderLayout ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.util.Properties ;

import javax.swing.BorderFactory ;
import javax.swing.JPanel ;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

import xcom.retro.RetroShield.frontpanel.api.AFrontPanel ;
import xcom.utils4j.logging.aspects.api.annotations.Log ;
import xcom.utils4j.tasks.ManagerScaffold ;
import xcom.utils4j.tasks.MonitorGUI ;
import xcom.utils4j.tasks.api.interfaces.IWorkerObserver ;
import xcom.utils4j.tasks.api.interfaces.IWorkerObserverEvent ;


@AFrontPanel
public class MOS6502 extends ManagerScaffold implements IWorkerObserver, ActionListener {

	private static final Logger Logger = LoggerFactory.getLogger(MOS6502.class) ;

	
	@Log
	MOS6502(final String[] args, final Properties props, final MonitorGUI gui) {

		super(args, props, gui) ;

		{
			final JPanel monitor = new JPanel() ;

			JPanel registers = new JPanel() ;
			registers
					.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Registers"), BorderFactory.createEmptyBorder(5, 5, 5, 5))) ;

			monitor.add(registers) ;

			gui.replaceDashboard(monitor) ;
		}
	}


	//
	// IWorkerObserver implementation ...
	//

	@Log
	@Override
	public void observeIWorkerObserver(final IWorkerObserverEvent event) {}


	//
	// ActionListener implementation ...
	//

	@Log
	@Override
	public void actionPerformed(final ActionEvent e) {}
}
