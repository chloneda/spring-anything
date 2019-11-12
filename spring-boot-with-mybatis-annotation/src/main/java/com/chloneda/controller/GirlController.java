package com.chloneda.controller;

import com.chloneda.model.Girl;
import com.chloneda.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chloneda
 * @description:
 */
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/api/girl", method = RequestMethod.GET)
    public Girl findOneCity(@RequestParam(value = "girlName") String girlName) {
        return girlService.findGirlByName(girlName);
    }

}
