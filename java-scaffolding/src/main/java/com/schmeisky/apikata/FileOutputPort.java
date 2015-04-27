package com.schmeisky.apikata;

public class FileOutputPort implements OutputPort {

    private String weatherString;

    @Override
    public void writeWeatherString(String weatherString) {
        this.weatherString = weatherString;
        // Write File
    }

    public String getWeatherString() {
        return weatherString;
    }
}
