package com.schmeisky.apikata;

import java.util.Map;


public class Weather {

    public Weather(Map<String, Object> data) {
        this.data = data;
    }
    public Map<String, Object> getData() {
        return data;
    }

    private Map<String, Object> data;
}
