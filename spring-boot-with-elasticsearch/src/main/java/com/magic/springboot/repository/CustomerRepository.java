package com.magic.springboot.repository;

import com.magic.springboot.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chloneda
 * @description:
 */
@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

}
