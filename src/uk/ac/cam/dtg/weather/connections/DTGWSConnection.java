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
		System.out.println("GETTING THE WEATHER!");
		ArrayList<String> fetchedWeather=null;
		try{
			fetchedWeather = fetchCurrentWeather();
		}catch(Exception e){
			Log.e("DTG_Weather", "There was a problem fetching the weather from the weather station");
			e.printStackTrace();
		}
		
		Weather weather = new Weather();
		if(fetchedWeather!=null){
			System.out.println("HERE");
			//Temperature 
			String tempFetched = fetchedWeather.get(2);
			String temp = tempFetched.split(":")[1];
			temp = temp.replaceAll("C", "").trim();
			weather.setTemp(Double.parseDouble(temp));
			
			
			//Pressure
			
			//Humidity
			
			//Dewpoint
			
			//Wind
			
			//Sunshine
			
			//Rainfall
			
			//Summary
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
