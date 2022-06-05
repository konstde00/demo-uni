package com.konstde00.medicinefacultymodule.repository;

import com.konstde00.medicinefacultymodule.domain.entity.Ordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdinatorRepository extends JpaRepository<Ordinator, Long> {

    @Query(value = """

    select distinct email
    from ordinators
    where speciality = ?1

    """, nativeQuery = true)
    List<String> getAllEmailsBySpeciality(@Param("speciality") String speciality);
}
