package com.project.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.register.entity.RegModel;



@Repository
public interface IRegisterRepo extends JpaRepository<RegModel,Long> {

}
