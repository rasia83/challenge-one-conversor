package tiago.rasia.converter;

import java.util.HashMap;
import java.util.Map;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Rasia
 */
public class TimeConverter {
    
    
    public static void main(String[] args) {
        
        // Create a HashMap to store city names and their time zones
        Map<String, ZoneId> timeZoneMap = new HashMap<>();

        // Add some cities and their time zones to the map
        timeZoneMap.put("New York, USA", ZoneId.of("America/New_York"));
        timeZoneMap.put("London, UK", ZoneId.of("Europe/London"));
        timeZoneMap.put("Paris, France", ZoneId.of("Europe/Paris"));
        timeZoneMap.put("Tokyo, Japan", ZoneId.of("Asia/Tokyo"));
        
        // Add more cities and their time zones to the map
        timeZoneMap.put("Sydney, Australia", ZoneId.of("Australia/Sydney"));
        timeZoneMap.put("São Paulo, Brazil", ZoneId.of("America/Sao_Paulo"));
        timeZoneMap.put("Toronto, Canada", ZoneId.of("America/Toronto"));
        timeZoneMap.put("Shanghai, China", ZoneId.of("Asia/Shanghai"));
        timeZoneMap.put("Berlin, Germany", ZoneId.of("Europe/Berlin"));

        
        // Get the time zone for a specific city
        ZoneId timeZone = timeZoneMap.get("New York, USA");
        System.out.println("Time zone for New York, USA: " + timeZone);
        
        timeZone = timeZoneMap.get("Sydney, Australia");
        System.out.println("Time zone for Sydney, Australia: " + timeZone);
        
        
        
        
        // Define two dates in GMT
        LocalDateTime date1 = LocalDateTime.of(2023, 3, 7, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2023, 3, 8, 12, 0);

        // Calculate the difference between the dates in hours
        Duration duration = Duration.between(date1.toInstant(ZoneOffset.UTC), date2.toInstant(ZoneOffset.UTC));
        long hoursDifference = duration.toHours();

        // Print the difference in hours to the console
        System.out.println("Difference between dates in hours: " + hoursDifference);
        
        
        
        System.out.println();   


        // Get the current date and time in your local time zone
        ZonedDateTime localTime = ZonedDateTime.now();

        // Specify the time zone for Shanghai
        ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");

        // Get the current date and time in Shanghai time zone
        ZonedDateTime shanghaiTime = localTime.withZoneSameInstant(shanghaiZone);

        // Calculate the difference in hours between the two time zones
        long hoursDifference2 = ChronoUnit.HOURS.between(localTime, shanghaiTime);

        System.out.println("The time difference between your local time and Shanghai time is " + hoursDifference2 + " hours.");


        System.out.println();
        

        // Set the time zone for Shanghai
        TimeZone shanghaiTimeZone = TimeZone.getTimeZone("Asia/Shanghai");

        // Create a calendar object with the Shanghai time zone
        Calendar shanghaiCalendar = Calendar.getInstance(shanghaiTimeZone);

        // Get the current time in Shanghai
        Date shanghaiTime3 = shanghaiCalendar.getTime();

        // Print the current time in Shanghai
        System.out.println("The current time in Shanghai is " + shanghaiTime3);
        
        
        System.out.println();
        
    }
    
}
