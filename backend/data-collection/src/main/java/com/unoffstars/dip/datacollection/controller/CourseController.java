package com.unoffstars.dip.datacollection.controller;

import com.unoffstars.dip.datacollection.model.dto.request.RequestDataCollection;
import com.unoffstars.dip.datacollection.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dip")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/coursewithaccount")
    @ResponseBody
    public String saveData(@RequestBody RequestDataCollection dataCollection) {
        courseService.save(dataCollection.getData());
        return "Data has been saved";
    }
}
