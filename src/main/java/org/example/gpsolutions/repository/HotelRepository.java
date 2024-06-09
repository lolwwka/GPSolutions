package org.example.gpsolutions.repository;

import org.example.gpsolutions.dto.repository.CountDto;
import org.example.gpsolutions.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel> {
    @Query("select new org.example.gpsolutions.dto.repository.CountDto(e.brand, count(e)) from Hotel e" +
            " group by e.brand order by count(e) desc")
    List<CountDto> countAndGroupByBrand();
}
