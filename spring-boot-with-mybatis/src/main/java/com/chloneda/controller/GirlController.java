package com.chloneda.controller;

import com.chloneda.model.Girl;
import com.chloneda.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Created by chloneda
 * @Description:
 */
@RestController
@RequestMapping(value = "/girls")
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/{girlId}",method = RequestMethod.GET)
    public Girl getGirlById(@PathVariable("girlId") String girlId) {
        Girl girl = this.girlService.getGirlById(girlId);
        return girl;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int create(@RequestBody Girl girl) {
        return girlService.create(girl);
    }

    @RequestMapping(value = "/{girlId}", method = RequestMethod.DELETE)
    public int delete(@PathVariable(value = "girlId") String girlId) {
        return girlService.delete(girlId);
    }

    @RequestMapping(value = "/{girlId}", method = RequestMethod.PUT)
    public int update(@PathVariable(value = "girlId") String girlId,@RequestParam String girlName) {
        return girlService.update(girlId,girlName);
    }

}
