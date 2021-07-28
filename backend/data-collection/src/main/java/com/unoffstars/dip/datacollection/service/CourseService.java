package com.unoffstars.dip.datacollection.service;

import com.unoffstars.dip.datacollection.model.Account;
import com.unoffstars.dip.datacollection.model.Course;
import com.unoffstars.dip.datacollection.model.dto.request.RequestAccount;
import com.unoffstars.dip.datacollection.model.dto.request.RequestCourse;
import com.unoffstars.dip.datacollection.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    private final AccountService accountService;

    public CourseService(CourseRepository courseRepository, AccountService accountService) {
        this.courseRepository = courseRepository;
        this.accountService = accountService;
    }

    public void save(List<RequestAccount> requestAccounts) {
        ArrayList<Course> courses = new ArrayList<>();
        for (RequestAccount requestAccount : requestAccounts) {
            Account account = accountService.save(requestAccount);
            for (RequestCourse requestCourse : requestAccount.getCourses()) {
                Course course = createCourse(0, requestCourse.getTittle(), requestCourse.getInstructor(), account);
                courses.add(course);
            }
            courseRepository.saveAllAndFlush(courses);

            courses.clear();
        }
    }

    public Course createCourse(Integer id, String tittle, String instructor, Account account) {
        Course course = new Course();
        course.setTitle(tittle);
        course.setInstructor(instructor);
        course.setAccount(account);

        if (id != 0) {
            course.setId(id);
        } else {
            course.setCreatedDate(new Date());
        }
        course.setUpdatedAt(new Date());

        return course;
    }

}
