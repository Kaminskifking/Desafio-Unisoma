package com.salary.unisoma.services;

import com.salary.unisoma.dtos.TaxDTO;

public interface TaxService {

    TaxDTO findByCpf(String cpf);
}
