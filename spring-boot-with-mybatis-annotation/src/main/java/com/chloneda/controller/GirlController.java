package com.chloneda.controller;

import com.chloneda.model.Girl;
import com.chloneda.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chloneda
 * @description:
 */
@RestController
@RequestMapping(value = "/girls")
public class GirlController {

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/{girlId}", method = RequestMethod.GET)
    public Girl getGirlById(@PathVariable(value = "girlId") String girlId) {
        return girlService.findGirlById(girlId);
    }

}
