package com.adamsimon.bosch.feladat2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adamsimon.bosch.feladat2.domains.User;

public interface UserWithCarRepository extends JpaRepository<User, Integer>{
//same plain sql query --> select u.name, c.brand, c.model from user as u, car as c where c.id IN (select uc.car from user_car as uc where uc.user in :list) and u.id in :list;
	@Query(nativeQuery = true, value = "SELECT u.name, c.brand, c.model FROM User u, Car c WHERE c.id IN (SELECT uc.car from user_car uc WHERE uc.user IN :ids) AND u.id IN :ids ")
	List<Object[]> getUserCarForUserIds(@Param("ids") List<Integer> ids);
}
