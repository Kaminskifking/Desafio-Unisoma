## Desafio-Unisoma

## Rotas

**Criar Funcionário** | /api/employee
------------ | -------------
    
> exemplo de json a ser enviado:


 ```json
{
 "name": "Test Funcionario",
 "cpf": "42115812321",
 "birthday": "10/09/2000",
 "address": "Rua Test, 300",
 "phoneNumber": "11 99999-9999",
 "salary": 3000.00
}
```

Percentual Salario | /api/adjust/42115812321 
------------ | -------------

> **CPF utilizando no exemplo acima, rota atualiza o salario do funcionario**

Imposto Salario | /api/tax/42115812321 
------------ | -------------

> **CPF utilizando no exemplo acima, rota faz calculo do imposto**
