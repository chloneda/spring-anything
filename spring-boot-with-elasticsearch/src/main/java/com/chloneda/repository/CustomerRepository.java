package com.chloneda.repository;

import com.chloneda.domain.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chloneda
 * @description:
 */
@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

}
