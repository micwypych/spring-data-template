package org;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

//    Optional<Customer> findOne(Long id);
}