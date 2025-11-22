package xcom.retro.RetroShield;

import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class ReceiveDataFromArduino {

	static String port = "COM7";
	static int baudRate = 115200;

	public class TimerScheduleHandler extends TimerTask implements SerialPortDataListener {

		private final long timeStart;

		public TimerScheduleHandler(long timeStart) {
			this.timeStart = timeStart;
		}

		@Override
		public void run() {
			System.out.println(" Time elapsed : " + (System.currentTimeMillis() - this.timeStart) + " milliseconds ");
		}

		@Override
		public int getListeningEvents() {
			return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
		}

		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			if (serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
				System.out.println(new String(serialPortEvent.getReceivedData(), StandardCharsets.UTF_8));
			}
		}
	}

	public static void main(String[] args) {

		long timeStart = System.currentTimeMillis();

		SerialPort sp = SerialPort.getCommPort(port);
		sp.setComPortParameters(baudRate, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
		sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

		if (!sp.openPort()) {
			throw new IllegalStateException(" Failed to open serial port ");
		}

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			sp.closePort();
		}));

		Timer timer = new Timer();
		TimerScheduleHandler timedSchedule = new ReceiveDataFromArduino().new TimerScheduleHandler(timeStart);

		sp.addDataListener(timedSchedule);

		System.out.println(" Listen : " + timedSchedule.getListeningEvents());
		timer.schedule(timedSchedule, 0, 1000);
	}
}
