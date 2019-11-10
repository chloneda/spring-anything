package com.chloneda.service;

import com.chloneda.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author chloneda
 * @description:
 */
public interface CustomerService {

    long count();

    Customer save(Customer customer);

    void delete(Customer customer);

    Iterable<Customer> getAll();

    List<Customer> getByName(String name);

    Page<Customer> pageQuery(Integer pageNo, Integer pageSize, String kw);

}
