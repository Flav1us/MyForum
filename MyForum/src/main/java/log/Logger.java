package log;

import java.time.LocalDateTime;

public class Logger {
	public static void console(String message) {
		System.out.println(LocalDateTime.now().toString() + "  \t" + message);
	}
}
