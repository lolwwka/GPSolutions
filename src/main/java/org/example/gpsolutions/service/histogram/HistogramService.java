package org.example.gpsolutions.service.histogram;

import java.util.Map;

public interface HistogramService {
    public Map<String, Long> countAndGroupByParam(String param);
}
