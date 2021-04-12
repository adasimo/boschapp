package com.adamsimon.bosch.feladat1.repositories;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adamsimon.bosch.feladat1.domains.Szervizkonyv;

public interface ServiceBookRepository  extends JpaRepository<Szervizkonyv, Integer> {
	
	@Query("SELECT s.id, s.tulajdonos, a.megnevezes, s.garancialis, e.megnevezes, s.szerviz_kezdete FROM Szervizkonyv s LEFT OUTER JOIN s.auto a LEFT OUTER JOIN s.eletkor e WHERE s.szerviz_vege IS NULL ")
	List<Object[]> getActiveServices();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Szervizkonyv s SET s.szerviz_vege = :date WHERE s.id = :id ")
	void deleteService(@Param("id") Integer id, @Param("date") LocalDateTime date);
}
