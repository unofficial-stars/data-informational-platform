package com.unoffstars.dip.datacollection.repository;

import com.unoffstars.dip.datacollection.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
