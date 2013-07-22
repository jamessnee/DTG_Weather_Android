package uk.ac.cam.dtg.weather;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.TextView;
import uk.ac.cam.dtg.weather.connections.*;
import uk.ac.cam.dtg.weather.models.Weather;

public class CurrentWeather extends Activity {
	
	private Weather currWeather;

    /*
     * This is where we receive notifications to update the UI
     *
     */
    Handler handler = new Handler() {
       @Override
        public void handleMessage(Message message) {
           if(message.what == 0) {
               TextView temp = (TextView) findViewById(R.id.temp_id);
               temp.setText(currWeather.getTemp() + "\u00B0C");

               TextView humid = (TextView) findViewById(R.id.humid_id);
               humid.setText(currWeather.getHumidity()+"%");

               TextView rain = (TextView) findViewById(R.id.rain_id);
               rain.setText(currWeather.getRain() + "mm");

               TextView dew = (TextView) findViewById(R.id.dew_id);
               dew.setText(currWeather.getDewPoint() + "\u00B0C");

               TextView wind = (TextView) findViewById(R.id.wind_id);
               wind.setText(currWeather.getWindSpeed() + "kts");

               TextView pressure = (TextView) findViewById(R.id.pressure_id);
               pressure.setText(currWeather.getPressure() + "mBar");
           }
       }
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_weather);

        startUpdates();
	}

    public void startUpdates() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                setCurrWeather(DTGWSConnection.getCurrentWeather());
                handler.sendEmptyMessage(0);
            }
        };
        Thread t = new Thread(run);
        t.start();
    }

    /*
	private void updateUI(){
		TextView temp = (TextView) findViewById(R.id.temp_id);
		temp.setText(currWeather.getTemp() + "\u00B0C");
		
		TextView humid = (TextView) findViewById(R.id.humid_id);
		humid.setText(currWeather.getHumidity()+"%");
		
		TextView rain = (TextView) findViewById(R.id.rain_id);
		rain.setText(currWeather.getRain() + "mm");
		
		TextView dew = (TextView) findViewById(R.id.dew_id);
		dew.setText(currWeather.getDewPoint() + "\u00B0C");
		
		TextView wind = (TextView) findViewById(R.id.wind_id);
		wind.setText(currWeather.getWindSpeed() + "kts");
		
		TextView pressure = (TextView) findViewById(R.id.pressure_id);
		pressure.setText(currWeather.getPressure() + "mBar");
	}
	*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.current_weather, menu);
		return true;
	}
	
	public Weather getCurrWeather() {
		return currWeather;
	}

	public void setCurrWeather(Weather currWeather) {
		this.currWeather = currWeather;
	}
}
