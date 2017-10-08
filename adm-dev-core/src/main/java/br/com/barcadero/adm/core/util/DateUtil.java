package br.com.barcadero.adm.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtil {

	public static final int DAYS_OF_MONTH=30;
	public static final int DAYS_OF_QUARTER=91;
	public static final int DAYS_OF_HALF=182;
	public static final int DAYS_OF_YEARLY=365;

	public static final String  DD_MM_YYYY = "dd/MM/yyyy";
	/**
	 * FORMATO ddMMyyyy
	 */
	public static final String  DDMMYYYY = "ddMMyyyy";
	/**
	 * FORMATO yyyyMMdd
	 */
	public static final String  YYYYMMDD = "yyyyMMdd";
	
	public static Date addDays(Date date,int days){
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DAY_OF_MONTH,days);
		date = c.getTime();
		return date;
	}

	 
	
	
	public static String dateTo_ddMMYYYY(Date date){
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}

	public static Date addMonths(Date date,int months){
		int days = months*30;
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DAY_OF_MONTH,days);
		date = c.getTime();
		return date;
	}

	public static String formatar(Date data, String formatoSaida)
	{
		if(data == null)
			return "";
		Locale locale = new Locale("pt","br");
		SimpleDateFormat dataFormato = new SimpleDateFormat (formatoSaida, locale);   
		String dataFormatada = dataFormato.format(data);
		return dataFormatada;
	}
	
	public static DateTimeDiffer calculateTime(long seconds) {
	    int day = (int) TimeUnit.SECONDS.toDays(seconds);
	    long hours = TimeUnit.SECONDS.toHours(seconds) -
	                 TimeUnit.DAYS.toHours(day);
	    long minute = TimeUnit.SECONDS.toMinutes(seconds) - 
	                  TimeUnit.DAYS.toMinutes(day) -
	                  TimeUnit.HOURS.toMinutes(hours);
	    long second = TimeUnit.SECONDS.toSeconds(seconds) -
	                  TimeUnit.DAYS.toSeconds(day) -
	                  TimeUnit.HOURS.toSeconds(hours) - 
	                  TimeUnit.MINUTES.toSeconds(minute);
	    System.out.println("Day " + day + " Hour " + hours + " Minute " + minute + " Seconds " + second);
	    DateTimeDiffer dateTimeDiffer = new DateTimeDiffer();
	    dateTimeDiffer.setDay(day);
	    dateTimeDiffer.setHours(hours);
	    dateTimeDiffer.setMinutes(minute);
	    dateTimeDiffer.setSecond(second);
	    return dateTimeDiffer;
	}

	public static DateTimeDiffer getDateTimeDiffer(Date anterior, Date toCompare) {
		long seconds = (toCompare.getTime() - anterior.getTime())/1000;
		return calculateTime(seconds);
	}
	
	public static String getTempoEntreDatasPorExtenso(Date anterior, Date toCompare) {
		DateTimeDiffer dateTimeDiffer = getDateTimeDiffer(anterior, toCompare);
		if(dateTimeDiffer.getDay() > 0){
			return dateTimeDiffer.getDay() + " dias atrás";
		}else if(dateTimeDiffer.getHours() > 0){
			return dateTimeDiffer.getHours() + " horas atrás";
		}else if(dateTimeDiffer.getMinutes() > 0){
			String minuto = "";
			if(dateTimeDiffer.getMinutes() > 1){
				minuto = " minutos";
			}else{
				minuto = " minuto";
			}
			return dateTimeDiffer.getMinutes() + minuto+" e " + dateTimeDiffer.getSecond() +" segundos atrás";
		}else{
			return dateTimeDiffer.getSecond() + " segundos atrás"; 
		}
	}
}
