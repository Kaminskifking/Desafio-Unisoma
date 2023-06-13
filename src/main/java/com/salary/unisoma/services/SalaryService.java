package com.salary.unisoma.services;

import com.salary.unisoma.dtos.ReadjustmentDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface SalaryService {

    ReadjustmentDTO findByCpf(String cpf);
}
