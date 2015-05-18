package com.schmeisky.apikata;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WeatherApplicationTest_with_Mockito {
    private WeatherApplication weatherApplication;
    @Mock private APIAccess apiAccess;
    @Mock private OutputPort outputPort;

    Map<String, Object> testData = new HashMap<String, Object>() {{
        put("id", 1); put("name", "Berlin"); put("time", "2015-04-27 23:00:00"); put("T", 17.0); put("P", 1000); put("D", "N");
    }};

    @Before
    public void setUp() {
        weatherApplication = new WeatherApplication(apiAccess, outputPort);
    }

    @Test
    public void convertWeather(){
        when(apiAccess.readWeather()).thenReturn(new Weather(testData));
        weatherApplication.convertWeather();
        verify(outputPort).writeWeatherString(eq("1,Berlin,2015-04-27,23:00:00,17.0,1000,N")); // Checks that outputPort is called correctly
    }
}
