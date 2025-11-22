

package xcom.retro.RetroShield.frontpanel.api ;


import java.lang.annotation.ElementType ;
import java.lang.annotation.Retention ;
import java.lang.annotation.RetentionPolicy ;
import java.lang.annotation.Target ;


@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface AFrontPanel {

	boolean disabled() default false;

	String selector() default "MOS6502";

	String worker() default "xcom.retro.RetroShield.frontpanel.frontpanels.MOS6502";
}
