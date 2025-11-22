

package xcom.retro.RetroShield ;


import java.io.IOException ;
import java.util.Arrays ;

import com.fazecast.jSerialComm.SerialPort ;


public class SendDataToArduino {

	static String port = "COM7" ;
	static int baudRate = 115200 ;

	public static void main(String[] args) throws IOException, InterruptedException {

		System.err.println(Arrays.asList(SerialPort.getCommPorts())) ;

		SerialPort sp = SerialPort.getCommPort(port) ;
		sp.setComPortParameters(baudRate, 8, 1, 0) ; // default connection settings for Arduino
		sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0) ; // block until bytes can be written

		if ( sp.openPort() ) {
			System.out.println("Port is open " + port) ;
		}
		else {
			System.out.println("Failed to open port " + port) ;
			return ;
		}

		for ( Integer i = 0; i < 10; ++i ) {
			sp.getOutputStream().write(i.byteValue()) ;
			sp.getOutputStream().flush() ;
			System.out.println("Sent number: " + i) ;
			Thread.sleep(2000) ;
		}

		if ( sp.closePort() ) {
			System.out.println("Port is closed :)") ;
		}
		else {
			System.out.println("Failed to close port :(") ;
			return ;
		}
	}
}
