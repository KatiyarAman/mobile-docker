package com.mobiledocker.mobiledocker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mobiledocker.mobiledocker.Dao.StateDao;

import com.mobiledocker.mobiledocker.entity.State;

public interface StateRepository extends  JpaRepository<State, Integer>,StateDao {

	//List<State> findByNameContaining(String query);
}
