package com.iamgagansuri.spectrum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;


public class DurationAdd
{

  public static void main1(String[] args)
  {
    String dateFormat="MM/dd/yyyy";
    String date="07/07/2012";
    LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat));
    System.out.println(parsedDate);
    Duration duration = Duration.of(2, ChronoUnit.DAYS);
    LocalDate newDate = parsedDate.plus(duration.toDays(),ChronoUnit.DAYS);
    System.out.println("new Date :"+newDate);
  }

  public static void main(String[] args)
  {
    String format=DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).toString();
    System.out.println(format);
    DateTimeFormatter datetimFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);


  }

}
