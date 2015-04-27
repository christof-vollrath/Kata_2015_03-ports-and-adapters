package com.schmeisky.apikata;

import java.util.Map;

public class WeatherApplication {
    private final APIAccess apiAccess;
    private final OutputPort port;

    public WeatherApplication(APIAccess apiAccess, OutputPort port) {
        this.apiAccess = apiAccess;
        this.port = port;
    }

    public void convertWeather() {
        Weather weather = apiAccess.readWeather();
        Map<String, Object> data = weather.getData();
        String[] timeData = data.get("time").toString().split(" ");
        String weatherString = "" + data.get("id") + ','
                + data.get("name") + ','
                + timeData[0] + ','
                + timeData[1] + ','
                + data.get("T") + ','
                + data.get("P") + ','
                + data.get("D");
        port.writeWeatherString(weatherString);
    }
}
