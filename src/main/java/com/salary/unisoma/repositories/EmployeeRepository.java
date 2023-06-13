package com.salary.unisoma.repositories;


import com.salary.unisoma.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>, JpaSpecificationExecutor<EmployeeModel> {
    EmployeeModel findByCpf(String cpf);

    Optional<EmployeeModel> findById(Long id);
}

