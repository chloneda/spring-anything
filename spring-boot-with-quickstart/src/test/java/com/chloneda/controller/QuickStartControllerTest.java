package com.chloneda.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@WebMvcTest(QuickStartController.class)
public class QuickStartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(new RequestBuilder() {
            @Override
            public MockHttpServletRequest buildRequest(ServletContext servletContext) {
                return new MockHttpServletRequest(RequestMethod.GET.name(), "/index");
            }
        }).andExpect(status().isOk()).andExpect(content().string("Quick start Spring Boot 2.1.x!"));
        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        Assert.assertEquals(contentAsString, "Quick start Spring Boot 2.1.x!");
    }

}
