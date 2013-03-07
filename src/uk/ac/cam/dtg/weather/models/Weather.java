package uk.ac.cam.dtg.weather.models;

public class Weather {
	private double time;
	private double temp;
	private int humidity;
	private double dewPoint;
	private double pressure;
	private double windSpeed;
	private String windDirection;
	private double sunHours;
	private double rain;
	private int maxWindSpeed;
	private String summary;
	
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public double getDewPoint() {
		return dewPoint;
	}
	public void setDewPoint(double dewPoint) {
		this.dewPoint = dewPoint;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public double getSunHours() {
		return sunHours;
	}
	public void setSunHours(double sunHours) {
		this.sunHours = sunHours;
	}
	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}
	public int getMaxWindSpeed() {
		return maxWindSpeed;
	}
	public void setMaxWindSpeed(int maxWindSpeed) {
		this.maxWindSpeed = maxWindSpeed;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
