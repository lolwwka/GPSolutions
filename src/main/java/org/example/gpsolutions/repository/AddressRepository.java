package org.example.gpsolutions.repository;

import org.example.gpsolutions.dto.repository.CountDto;
import org.example.gpsolutions.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Contacts, Long> {
    @Query("select new org.example.gpsolutions.dto.repository.CountDto(e.city, count(e)) from Address e" +
            " group by e.city order by count(e) desc ")
    List<CountDto> countAndGroupByCity();

    @Query("select new org.example.gpsolutions.dto.repository.CountDto(e.country, count(e)) " +
            "from Address e group by e.country order by count(e) desc")
    List<CountDto> countAndGroupByCountry();
}
