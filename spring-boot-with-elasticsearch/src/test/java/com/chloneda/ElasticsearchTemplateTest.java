package com.chloneda;

import com.chloneda.model.Customer;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTemplateTest {

    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testInsert() {
        Customer customer = new Customer();
        customer.setId("1501009005");
        customer.setUsername("吐司面包");
        customer.setAge(36);
        customer.setAddress("Shanghai");
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(customer).build();
        elasticsearchTemplate.index(indexQuery);
    }

    @Test
    public void testQuery() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", "吐司"))
                .build();
        List<Customer> list = elasticsearchTemplate.queryForList(searchQuery, Customer.class);
        System.out.println(list);
    }

}
