package Beans;

import java.util.HashMap;
import java.util.Map;

public class PicoPlacaConfiguration {

	public Map<Integer, String> PicoPlacaConfig() {
		Map<Integer, String> PicoPlacaMap = new HashMap<Integer, String>();
		PicoPlacaMap.put(1, "1,2");//Lunes
		PicoPlacaMap.put(2, "3,4");//Martes
		PicoPlacaMap.put(3, "5,6");//Miercoles
		PicoPlacaMap.put(4, "7,8");//Jueves
		PicoPlacaMap.put(5, "9,0");//Viernes
		return PicoPlacaMap; 
	} 

	public Map<String, String> TimeTableConfig() {
		Map<String, String> TimeTableMap = new HashMap<String, String>();
		TimeTableMap.put("MorningStart", "07:00");//Inicio PyP Mañana
		TimeTableMap.put("MorningEnd", "09:30");//Fin Pyp Mañana
		TimeTableMap.put("AfternoonStart", "16:00");//Inicio PyP Tarde
		TimeTableMap.put("AfternoonEnd", "19:30");//Fin PyP Tarde
		return TimeTableMap;
	}

}
