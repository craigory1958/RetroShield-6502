

package xcom.retro.RetroShield.frontpanel ;


import xcom.utils4j.logging.aspects.api.annotations.Log ;
import xcom.utils4j.tasks.ExecutiveScaffold ;


public class RetroFrontPanel extends ExecutiveScaffold {

	public RetroFrontPanel(final String[] args) {
		super(args) ;
	}


	@Log
	public static void main(final String[] args) {

		final RetroFrontPanel $ = new RetroFrontPanel(args) ;
		$.bootstrapSwing($.getWindow(), $.getProps(), $.getManager(), $.getSettings()) ;
	}
}
