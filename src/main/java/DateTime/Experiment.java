package DateTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Experiment {
	
	static LocalDateTime convertStringToDate(String dateTime){
		
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		LocalDateTime l = LocalDateTime.parse(dateTime, formatter);
		
		System.out.println(l);
		return l;
		
	}
	
	public static void main(String[] args) {
		
		convertStringToDate("2024-01-02T17:28:03.000Z");
		LocalDate date = convertStringToDate("2024-01-02T17:28:03.123Z").toLocalDate();
//		System.out.println(date.toString());
//		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		System.out.println(Instant.now().toString());
		
//		Instant instant = Instant.parse("2024-01-02T17:28:03.123Z");
//		System.out.println(instant);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
//		String formattedInstant = formatter.format(Instant.now());
//		System.out.println(formattedInstant);
		
//		String s = "0123456789";
//		System.out.println(s.substring(0,9));
//		System.out.println(s.substring(10,10));
//		System.out.println(s.length());
//		
//		DateTimeFormatter formatter2 =  DateTimeFormatter.ofPattern("dd-MMM-yy").withLocale(Locale.getDefault());
//		System.out.println(date.format(formatter2).toUpperCase());
		System.out.println("hello");
		List<String> names = new ArrayList<>();
		names.forEach(s -> {
			System.out.println(s);
		});
	}

}
