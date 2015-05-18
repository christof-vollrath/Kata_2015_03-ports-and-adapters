package com.schmeisky.apikata;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherApplicationTest_without_Mocking {
    private WeatherApplication weatherApplication;
    private FileOutputPort outputPort;


    @Before
    public void setUp() {
        outputPort = new FileOutputPort();
        weatherApplication = new WeatherApplication(new APIAccess(), outputPort);
    }

    @Test @Ignore // This test works not reproducable since weather data will change over time
    public void convertWeather() {
        weatherApplication.convertWeather();
        assertEquals("1,Reykjavík,2015-04-27,21:00:00,1.3,1012,NNE", outputPort.getWeatherString());
            // id,name,date,time,temperature,pressure,wind_direction
    }
}
