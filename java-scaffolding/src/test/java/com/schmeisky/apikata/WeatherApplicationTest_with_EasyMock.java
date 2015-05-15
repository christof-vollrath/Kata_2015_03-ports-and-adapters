package com.schmeisky.apikata;

import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test example with PowerMock 1.6.2, EasyMock and JUnit 4.12
 */
@RunWith(PowerMockRunner.class)
public class WeatherApplicationTest_with_EasyMock {
    
	private WeatherApplication underTest;

    @Mock private APIAccess apiAccess;
    @Mock private FileOutputPort outputPort;
    
    private Weather weather;

    private Map<String, Object> testData = new HashMap<String, Object>() {{
        put("id", 1); 
        put("name", "Berlin"); 
        put("time", "2015-04-27 23:00:00"); 
        put("T", 17.0); 
        put("P", 1000); 
        put("D", "N");
    }};

    @Before
    public void setUp() {
        underTest = new WeatherApplication(apiAccess, outputPort);
        weather = new Weather(testData);
    }

    @Test
    public void testConvertWeather(){

        expect(apiAccess.readWeather()).andReturn(weather);
        outputPort.writeWeatherString("1,Berlin,2015-04-27,23:00:00,17.0,1000,N");
        replayAll();

        underTest.convertWeather();

        verifyAll();
    }
}
