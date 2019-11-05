package com.magic.springboot.service;

import com.magic.springboot.model.Customer;
import com.magic.springboot.repository.CustomerRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chloneda
 * @description: Spring Boot中集成Elasticsearch有4种方式：
 * 1、REST Client
 * 2、Jest
 * 3、Spring Data(ElasticsearchTemplate)
 * 4、Spring Data Elasticsearch Repositories
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> list = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<Customer> iterable = customerRepository.search(matchQueryBuilder);
        iterable.forEach(var -> list.add(var));
        return list;
    }

    @Override
    public Page<Customer> pageQuery(Integer pageNo, Integer pageSize, String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return customerRepository.search(searchQuery);
    }

}
