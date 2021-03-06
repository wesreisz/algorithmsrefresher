package com.wesleyreisz.samples.patterns.observer.weatherstation.displays;

import java.util.Observable;
import java.util.Observer;

import com.wesleyreisz.samples.patterns.observer.weatherstation.DisplayElement;
import com.wesleyreisz.samples.patterns.observer.weatherstation.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {

	Observable observable;
	private float temperature;
	private float humidity;

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println(
				" Current forcast: " + temperature + 
				" F degrees and " + humidity + " % humidity"
			);
	}

}
