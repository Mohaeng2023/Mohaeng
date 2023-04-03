package com.mohaeng.backend.place.repository;

import com.mohaeng.backend.place.domain.Place;
import com.mohaeng.backend.place.dto.FindAllPlacesDto;
import com.mohaeng.backend.place.dto.PlaceDetailsDto;
import com.mohaeng.backend.place.dto.PlaceSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceRepositoryCustom, QuerydslPredicateExecutor<Place> {
    List<Place> findByAddressContainingIgnoreCase(String searchValue);
    Page<PlaceSearchDto> findByNameContainingOrAddressContaining(String name, String address, Pageable pageable);
    Page<PlaceSearchDto> findByNameContaining(String name, Pageable pageable);
    Page<FindAllPlacesDto> findByAreaCodeEquals(String areaCode, Pageable pageable);
    List<PlaceDetailsDto> findByContentId(String contentId);
}
