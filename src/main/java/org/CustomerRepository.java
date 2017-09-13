package org;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

interface CustomerRepository extends Repository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Optional<Customer> findOne(Long id);

    Iterable<Customer> findAll();

    Customer save(Customer customer);
}