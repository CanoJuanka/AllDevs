package Repository;

import java.time.LocalTime;
import java.util.Map;

import Beans.PicoPlacaConfiguration;
import Beans.Placa;

public class PicoPlacaRepository {
	public int messageCode;

	public String checkPicoPlaca(String licencePlate, String day, String hour) {
		Validations va = new Validations();
		PicoPlacaConfiguration co = new PicoPlacaConfiguration();
		Placa pa = new Placa();
		Map<String, String> TimeTableConfig = co.TimeTableConfig();
		Map<Integer, String> PicoPlacaConfig = co.PicoPlacaConfig();
		char lastDigit;
		boolean hourFlag;
		int checkFlag; 
		String message;

		message = va.validateNull(licencePlate, day, hour);
		if (message != null) {
			messageCode = 2;
			return message;
		}

		message = va.validateFormat(licencePlate, day, hour);
		if (message != null) {
			messageCode = 3;
			return message;
		}

		pa.setLicensePlate(licencePlate);
		lastDigit = pa.getLastDigit();

		hourFlag = this.checkHour(va.nowTime, TimeTableConfig);

		if ((va.nowDay == 1 || va.nowDay == 7) || hourFlag == false) {
			messageCode = 0;
			message = "Felicidades, puede circular";
		} else {
			checkFlag = PicoPlacaConfig.get(va.nowDay).indexOf(lastDigit);

			if (checkFlag != -1) {
				messageCode = 1;
				message = "No Puede circular, el dia de hoy solo circulan los vehiculos cuyas placas no terminen en "
						+ PicoPlacaConfig.get(va.nowDay)
						+ ". Recuerde que el pico y placa solo aplica desde las 07:00 a 09:30 y de 16:00 a 19:30";				
			} else {
				messageCode = 0;
				message = "Felicidades, puede circular";				
			}
		}
		return message;
	}

	public boolean checkHour(LocalTime nowTime, Map<String, String> TimeTableMap) {
		LocalTime morStart = LocalTime.parse(TimeTableMap.get("MorningStart"));
		LocalTime morEnd = LocalTime.parse(TimeTableMap.get("MorningEnd"));
		LocalTime aftStart = LocalTime.parse(TimeTableMap.get("AfternoonStart"));
		LocalTime aftEnd = LocalTime.parse(TimeTableMap.get("AfternoonEnd"));
		if ((nowTime.compareTo(morStart) >= 0 && nowTime.compareTo(morEnd) <= 0)
				|| (nowTime.compareTo(aftStart) >= 0 && nowTime.compareTo(aftEnd) <= 0)) {
			return true;
		} else {
			return false;
		}
	}
}
