package uk.ac.cam.dtg.weather;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CurrentWeather extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_weather);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.current_weather, menu);
		return true;
	}

}
