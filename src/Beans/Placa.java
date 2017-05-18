package Beans;

public class Placa {
	private String licensePlate;

	public Placa(){
		 licensePlate = "";
    } 

	public Placa(String psLicensePlate){
		 licensePlate = psLicensePlate;
    }

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String psLicensePlate) {
		this.licensePlate = psLicensePlate;
	}

	public char getLastDigit() {
		int numberLength;
		char lastDigit;
		numberLength = licensePlate.length();
		lastDigit = licensePlate.charAt(numberLength - 1);
		return lastDigit;
	}
}
