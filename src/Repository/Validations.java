package Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public LocalTime nowTime;
	public int nowDay;

	public String validateNull(String licencePlate, String nowDate, String hour) {
		String message = null;
		if (licencePlate.trim().length() == 0) 
			message = "Debe ingresar la placa vehicular";
		else if (nowDate.trim().length() == 0)
			message = "Debe ingresar la fecha";
		else if (hour.trim().length() == 0)
			message = "Debe ingresar la hora de circulacion";
		return message;
	}

	public String validateFormat(String licencePlate, String nowDate, String hour) {
		String message = null;
		GregorianCalendar gcal = new GregorianCalendar();
		Pattern pat = Pattern.compile("[A|W|S|B|G|P|U|I|Q|C|L|Y|X|R|J|H|M|K|O|V|T|E|N|Z]{3}[-]*[0-9]{3,4}");
		Matcher mat = pat.matcher(licencePlate);

		if (mat.matches()) {
			message = null;
		} else {
			message = "La placa vehicular es incorrecta, ingrese en el formato correcto: ABC-1234 o ABC1234";
			return message;
		}

		try {		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			gcal.setTime(sdf.parse(nowDate));
			nowDay = gcal.get(Calendar.DAY_OF_WEEK);
		} catch (DateTimeParseException | ParseException e) {
			message = "La fecha ingresada es incorrecta, ingrese la fecha en el formato correcto: 1989-01-01";
			return message;
		}
		
		try { 
			nowTime = LocalTime.parse(hour);
		} catch (DateTimeParseException e) {
			message = "La hora ingresada es incorrecta, ingrese la hora en el formato correcto: 00:00";
			return message;
		}		
		return message;
	}
}
