package app;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
        LocalDate d07 = LocalDate.parse("20/07/2022", fmt1);
        LocalDateTime d08 = LocalDateTime.parse("20/07/2022 01:30", fmt2);

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06,ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7,ChronoUnit.DAYS);

        //Duration t1 = Duration.between(pastWeekLocalDate, nextWeekLocalDate);


        System.out.println("d01: " + d01);
        System.out.println("d02: " + d02);
        System.out.println("d03: " + d03);
        System.out.println("d04: " + d04);
        System.out.println("d05: " + d05);
        System.out.println("d06: " + d06);
        System.out.println("d07: " + d07);
        System.out.println("d08: " + d08);

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r3: " + r3);
        System.out.println("r4: " + r4);


        System.out.println("d04 day: " + d04.getDayOfMonth());
        System.out.println("d04 month: " + d04.getMonthValue());
        System.out.println("d04 year: " + d04.getYear());

        System.out.println("d05 hour: " + d05.getHour());
        System.out.println("d05 hour: " + d05.getMinute());

        System.out.println("pastWeekLocalDate: " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate: " + nextWeekLocalDate);

        System.out.println("pastWeekInstant: " + pastWeekInstant);
        System.out.println("nextWeekInstant: " + nextWeekInstant);

        //System.out.println("t1 dias: " + t1.toDays());


    }
}
