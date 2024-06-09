package org.example.gpsolutions.dto.repository;

public class CountDto {
    private String lineName;
    private Long count;

    public CountDto(String lineName, long count) {
        this.lineName = lineName;
        this.count = count;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
