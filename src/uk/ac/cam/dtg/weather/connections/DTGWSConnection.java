package uk.ac.cam.dtg.weather.connections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import android.util.Log;

import uk.ac.cam.dtg.weather.models.*;

public class DTGWSConnection {
	public static final String CONNECTIONURL = "http://www.cl.cam.ac.uk/research/dtg/weather/current-obs.txt";
	
	public static Weather getCurrentWeather(){
        ArrayList<String> fetchedWeather=null;
		try{
			fetchedWeather = fetchCurrentWeather();
		}catch(Exception e){
			Log.e("DTG_Weather", "There was a problem fetching the weather from the weather station");
			e.printStackTrace();
		}

        Weather weather = new Weather();
		if(fetchedWeather!=null){
			//Temperature 
			String tempFetched = fetchedWeather.get(2);
			String temp = tempFetched.split(":")[1];
			temp = temp.replaceAll("C", "").trim();
			weather.setTemp(Double.parseDouble(temp));
			
			//Pressure
			String pressureFetched = fetchedWeather.get(3);
			String pressure = pressureFetched.split(":")[1];
			pressure = pressure.replaceAll("mBar", "").trim();
			weather.setPressure(Integer.parseInt(pressure));
			
			//Humidity
			String humidFetched = fetchedWeather.get(4);
			String humid = humidFetched.split(":")[1];
			humid = humid.replaceAll("%", "").trim();
			weather.setHumidity(Integer.parseInt(humid));
			
			//Dewpoint
			String dewFetched = fetchedWeather.get(5);
			String dew = dewFetched.split(":")[1];
			dew = dew.replaceAll("C", "").trim();
			weather.setDewPoint(Double.parseDouble(dew));
			
			//Wind
			String windFetched = fetchedWeather.get(6);
			String wind = windFetched.split(":")[1].trim();
			String[] windA = wind.split(" ");
			wind = windA[0];
			weather.setWindSpeed(Double.parseDouble(wind));
			
			//Sunshine
			String sunFetched = fetchedWeather.get(7);
			String sun = sunFetched.split(":")[1].trim();
			String[] sunA = sun.split(" ");
			sun = sunA[0];
			weather.setSunHours(Double.parseDouble(sun));
			
			//Rainfall
			String rainFetched = fetchedWeather.get(8);
			String rain = rainFetched.split(":")[1].trim();
			String[] rainA = rain.split(" ");
			rain = rainA[0];
			weather.setRain(Double.parseDouble(rain));
			
			//Summary
			String summary = fetchedWeather.get(10);
			summary = summary.split(":")[1].trim();
			weather.setSummary(summary);
		}
		
		return weather;
	}
	
	private static ArrayList<String> fetchCurrentWeather() throws Exception{
		URL url = new URL(CONNECTIONURL);
		URLConnection connection = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		//OK so this is a horrid hack, but hey! 
		ArrayList<String>comps = new ArrayList<String>();
		
		String inLine;
		while((inLine = reader.readLine()) != null)
			comps.add(inLine);
		reader.close();
		return comps;
	}
}
