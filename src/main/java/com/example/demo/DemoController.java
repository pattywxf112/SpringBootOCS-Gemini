package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DemoController {
    @CrossOrigin
    @GetMapping("/")
    public ArrayList<SciencePlan> getAllSciencePlans() {
        OCS o = new OCS();
        System.out.println(o.getAllSciencePlans());
        return o.getAllSciencePlans();
    }

    @GetMapping("/sp")
    public Object getSciencePlanById(@RequestParam(required = false) Integer id) {
        OCS o = new OCS();
        if (id != null) {
            SciencePlan plan = o.getSciencePlanByNo(id);
            if (plan != null) {
                return plan; //found ID
            } else {
                return id + " is not found"; //ID not found
            }
        }
        return o.getAllSciencePlans();
    }
}
