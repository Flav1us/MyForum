package log;

import java.time.LocalDateTime;

public class Logger {
	public static void console(String message) {
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time.toString() + "\t" + message);
	}
}
