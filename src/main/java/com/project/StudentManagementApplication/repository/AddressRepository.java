package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer>  {
}
