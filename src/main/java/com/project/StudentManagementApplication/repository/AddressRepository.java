package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{
}