package DateTime;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Experiment {
	
	static LocalDateTime convertStringToDate(String dateTime){
		
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		LocalDateTime l = LocalDateTime.parse(dateTime, formatter);
		
		System.out.println(l);
		return l;
		
	}
	
	public static void main(String[] args) {
		
//		convertStringToDate("2024-01-02T17:28:03.000Z");
//		convertStringToDate(null);
//		LocalDate date = convertStringToDate("2024-01-02T17:28:03.123Z").toLocalDate();
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
//		System.out.println("hello");
//		List<String> names = new ArrayList<>();
//		names.forEach(s -> {
//			System.out.println(s);
//		});
		
//		LocalDateTime t = convertStringToDate("2024-01-02T17:28:03.000Z");
//		Instant i =Instant.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
//	//	ZonedDateTime zonedDateTime = ZonedDateTime.of(i, ZoneId.systemDefault());
//		ZonedDateTime zonedDateTime =i.atZone(ZoneId.systemDefault());
//				//.withZone(ZoneId.systemDefault());
//		System.out.println(zonedDateTime.format(formatter));
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneId.systemDefault());
//				//.withZone(ZoneId.of());
//		Instant instant = Instant.parse(Instant.now().toString());
//		System.out.println(formatter.format( instant));
//		System.out.println(LocalDate.now().getYear());
//		String s =null;
//		System.out.println(s.toString());
		String date = "2024-04-01 00:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
		DateTimeFormatter formatter2 =  DateTimeFormatter.ofPattern("dd-MMM-yyyy");
				//.withLocale(Locale.getDefault());
		System.out.println(dateTime.format(formatter2).toUpperCase());
//
//		DateFormatter ddmmmyyHhMmSsWithhyp = DateFormatter.DDMMMYY_HH_MM_SS_WITHHYP;
//		ddmmmyyHhMmSsWithhyp.getFormatString();

		//List<Employee> employeeList = VariablesAndTechniques.getLargeEmployeeList().subList(0,10);
//		List<Employee> convertedEmployeeList = employeeList.stream()
//		.map(eachEmployee -> {
//			System.out.println(eachEmployee);
//
//			return convertDate(eachEmployee);
//
//		}).collect(Collectors.toList());
//		System.out.println(employeeList+"\n\n");
//		employeeList.forEach(Experiment::convertDate);
//		System.out.println(employeeList);
		//System.out.println(employeeList.equals(convertedEmployeeList));

	}

	public void operation(){
		List<Employee> employeeList = VariablesAndTechniques.getLargeEmployeeList().subList(0,10);
		System.out.println(employeeList+"\n\n");
		employeeList.forEach(Experiment::convertDate);
		System.out.println(employeeList);
	}

	private  static void convertDate(Employee eachEmployee) {
		String presentDate = eachEmployee.getDob();
		DateTimeFormatter formatter =  new DateTimeFormatterBuilder()
				.appendPattern("yyyy-MM-dd")
				.parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
				.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
				.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
				.toFormatter();;

		LocalDateTime dateTime = LocalDateTime.parse(presentDate,formatter);
		DateTimeFormatter formatter2 =  DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String convertedDate = dateTime.format(formatter2).toUpperCase();
		eachEmployee.setDob(convertedDate);
		//return eachEmployee;
	}

}
