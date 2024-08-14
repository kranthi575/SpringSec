package com.example.demo.Repo;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long>{

    Customer findByemail(String email);
}
