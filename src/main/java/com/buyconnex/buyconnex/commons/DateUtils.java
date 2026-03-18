package com.buyconnex.buyconnex.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	
	/**
	 * DD/MM/YYYY
	 */
	
	public static String getDateExecution() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	/**
	 * YYYYMMDD
	 */
	public static String getDateExecutionCsv() {
		Date date = new Date();
		return LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).toString().replace("-", "");
	}
	
	/**
	 * YYYYMM
	 */

	public static String getYearMonth() {
		LocalDate today = LocalDate.now();
		return today.format(DateTimeFormatter.ofPattern("YYYYMM"));
	}
	
	/**
	 * Mois précédent
	 */
	
	public static String getLastMonth() {
		Date date = new Date();
		if(date != null && LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).getDayOfMonth() == 1) {
			if(LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).getDayOfMonth() == 1) {
				return "12";
			}
			return String.valueOf(LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).getDayOfMonth() - 1);
		}
		return String.valueOf(LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).getDayOfMonth());
	}
	
	/**
	 * Format dd/MM/yyyy
	 */
	public static String getFormattedDate(Date date) {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
	/**
	 * Format yyyyMMdd
	 */
	
	public static String getFormattedDateOrderStyle(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	/**
	 * Format yyyy-MM-dd HH:mm:ss z
	 */
	
	public static String getFormattedDateForExactTime(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(date);
	}
	
	/**
	 * Format yyyy-MM-dd'T'HH:mm:ssz
	 */
	
	public static String getFormattedTime(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz").format(date);
	}
	
	/**
	 * Format dd/MM/yyyy HH:mm
	 */
	
	public static String getFormattedTimeWithHourssAndMinutes(Date date) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);
	}
	
	/**
	 * Format yyyy-MM-dd
	 */
	
	public static String getFormattedDateEnglish(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	/**
	 * Récupère la date de fin d'un évènement à partir de sa date de début et de sa durée
	 */
	
	public static Date computeEndDate(Date beginDate, Date length) {
		if(beginDate == null || length == null) {
			return beginDate;
		}
		return new Date(beginDate.getTime() + length.getTime() + 3600000);
	}
	
	public static Date addMinutesToDate(Date currentDate, int minuteDelta) {
		return addTimeToDate(currentDate, Calendar.MINUTE, minuteDelta);
	}
	
	public static Date addTimeToDate(Date currentDate, int typeDelta, int valeurDelta) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(typeDelta, valeurDelta);
		return calendar.getTime();
	}
	
	public static Date addHoursToDate(Date currentDate, int hourDelta) {
		return addTimeToDate(currentDate, Calendar.HOUR, hourDelta);
	}
	
	public static Date addDaysToDate(Date currentDate, int dayDelta) {
		return addTimeToDate(currentDate, Calendar.DAY_OF_MONTH, dayDelta);
	}
	
	public static Date addMonthsToDate(Date currentDate, int monthDelta) {
		return addTimeToDate(currentDate, Calendar.MONTH, monthDelta);
	}
	
	public static Date addYearsToDate(Date currentDate, int yearDelta) {
		return addTimeToDate(currentDate, Calendar.YEAR, yearDelta);
	}
	
	public static Long getDaysBetween(Date dateDebut, Date dateFin) {
		return Duration.between(getLocalDateTime(dateDebut), getLocalDateTime(dateFin)).toDays();
	}
	
	public static Long getMinutesBetween(Date dateDebut, Date dateFin) {
		return Duration.between(getLocalDateTime(dateDebut), getLocalDateTime(dateFin)).toMinutes();
	}
	
	public static Long getHoursBetween(Date dateDebut, Date dateFin) {
		return Duration.between(getLocalDateTime(dateDebut), getLocalDateTime(dateFin)).toHours();
	}
	
	public static LocalDateTime getLocalDateTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, Calendar.DAY_OF_MONTH, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE));
	}
	
	public static Date getLastDateOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dernierJour = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, dernierJour);
		return calendar.getTime();
	}
	
	/**
	 * Cast  LocalDate en Date
	 */
	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * Calcul le nombre de mois entre 2 dates
	 */
	public static int getNumberOfMonthsBetweenTwoDates(Date date1, Date date2) {
		BigDecimal ecart = new BigDecimal((date2.getTime() - date1.getTime()) / (1000*60*60*24));
		return ecart.divide(new BigDecimal(30), 0, RoundingMode.HALF_UP).intValueExact();
	}
	
	/**
	 * Retourne l'année d'une date
	 */
	public static int getYear(Date date) {
		return LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).getYear();
	}
	
	/**
	 * Retourne le mois d'une date
	 */
	public static int getMonth(Date date) {
		return LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).getMonth().getValue();
	}
	
	/**
	 * Retourne le jour d'une date
	 */
	public static int getDay(Date date) {
		return LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault())).getDayOfMonth();
	}
	
	/**
	 * Retourne le numéro du mois en fonction de son nom
	 */
	public static int getMonthNbFromName(String monthName) {
		try {
			Date date = new SimpleDateFormat("MMMM").parse(monthName);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.get(Calendar.MONTH) + 1;
		} catch (java.text.ParseException e) {
			return -1;
		}
	}
	
	public static Date today() {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String today = formatter.format(new Date());
			return formatter.parse(today);
		} catch (ParseException e) {
			logger.error("erreur détectée", e);
		}
		return new Date();
	}
	
	public static Date getCleanDate(Date date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String today = formatter.format(date);
			return formatter.parse(today);
		} catch (ParseException e) {
			logger.error("erreur détectée", e);
		}
		return new Date();
	}
	
	/**
	 * Vérifie si c'est une année bissextile
	 */
	public static boolean isLeapYear(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		return c.isLeapYear(c.get(Calendar.YEAR));
	}
	
	/**
	 * Récupérer une instance Date en String passé en paramètre
	 */
	public static Date getDateFromString(String datestr) {
		SimpleDateFormat formatter = new SimpleDateFormat();
		Date date = null;
		try {
			date = formatter.parse(datestr);
		} catch (ParseException e) {
			logger.error("Erreur", e);
		}
		return date;
	}
	
	/**
	 * Vérifie si la date est comprise entre 2 dates
	 */
	public static boolean isDateBetween(Date sourcedate, Date dateDebut, Date dateFin) {
		if(sourcedate == null || dateDebut == null || dateFin == null) {
			return false;
		} else {
			sourcedate = getCleanDate(sourcedate);
			dateDebut = getCleanDate(dateDebut);
			dateFin = getCleanDate(dateFin);
			
			return ((sourcedate.after(dateDebut) || sourcedate.equals(dateDebut) && 
					(sourcedate.before(dateFin) || sourcedate.equals(dateFin))));
		}
	}
	
	/**
	 * Retourne le trimestre
	 */
	public static int getTrimestre(Date date) {
		Calendar fin = Calendar.getInstance();
		fin.setTime(date);
		int mois = fin.get(Calendar.MONTH);
		if(mois <= 2 && mois >= 0) {
			return 1;
		} else if(mois <= 5 && mois >= 3) {
			return 2;
		} else if(mois <= 8 && mois >= 6) {
			return 3;
		} else {
			return 4;
		}
	}
	
	/**
	 * Retourne le semestre
	 */
	public static int getSemestre(Date date) {
		Calendar fin = Calendar.getInstance();
		fin.setTime(date);
		int mois = fin.get(Calendar.MONTH);
		if(mois < 6) {
			return 1;
		} else {
			return 2;
		}
	}
	
	/**
	 * Retourne le jour courrant en Calendar
	 */
	public static Calendar getCurrentDateAsCalendar() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		return cal;
	}
	
	/**
	 * Renvoie le mois actuel en chiffre (1 à 12)
	 */
	public static int getCurrentMonthAsInt() {
		return getCurrentDateAsCalendar().get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Renvoie l'année actuelle
	 */
	public static int getCurrentYearAsInt() {
		return getCurrentDateAsCalendar().get(Calendar.YEAR);
	}
	
}
