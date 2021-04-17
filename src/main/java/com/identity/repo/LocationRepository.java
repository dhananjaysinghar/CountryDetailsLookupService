package com.identity.repo;

import com.identity.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Countries, Integer> {
    Optional<Countries> findByNameLikeIgnoreCase(String name);

    Optional<Countries> findBySortnameLikeIgnoreCase(String sortName);

    @Query("SELECT c.sortname from Countries c")
    List<String> findSortNames();
}
