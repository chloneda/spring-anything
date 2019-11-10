package com.chloneda;

import com.chloneda.model.Customer;
import com.chloneda.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {
    
    @Autowired
    private CustomerService customerService;

    @Test
    public void contextLoads() {
        System.out.println(customerService.count());
    }

    @Test
    public void testInsert() {
        Customer customer = new Customer();
        customer.setId("1501009001");
        customer.setUsername("面包");
        customer.setAddress("BeiJing");
        customer.setAge(38);
        customerService.save(customer);

        customer = new Customer();
        customer.setId("1501009002");
        customer.setUsername("Lisi");
        customer.setAddress("BeiJing");
        customer.setAge(28);
        customerService.save(customer);

        customer = new Customer();
        customer.setId("1501009003");
        customer.setUsername("Lili");
        customer.setAddress("BeiJing");
        customer.setAge(18);
        customerService.save(customer);

    }

    @Test
    public void testDelete() {
        Customer customer = new Customer();
        customer.setId("1501009002");
        customerService.delete(customer);
    }

    @Test
    public void testGetAll() {
        Iterable<Customer> iterable = customerService.getAll();
        iterable.forEach(e->System.out.println(e.toString()));
    }

    @Test
    public void testGetByName() {
        List<Customer> list = customerService.getByName("面包");
        System.out.println(list);
    }

    @Test
    public void testPage() {
        Page<Customer> page = customerService.pageQuery(0, 10, "面");
        System.out.println(page.getTotalPages());
        System.out.println(page.getNumber());
        System.out.println(page.getContent());
    }

}
