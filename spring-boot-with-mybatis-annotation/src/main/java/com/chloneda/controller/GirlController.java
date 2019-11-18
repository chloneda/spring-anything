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
    public Girl findGirlById(@PathVariable(value = "girlId") String girlId) {
        return girlService.findGirlById(girlId);
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
    public int update(@PathVariable(value = "girlId") String girlId, @RequestParam String girlName) {
        return girlService.update(girlId, girlName);
    }

}
