package Lab04.BTNhom17.Service;

import Lab04.BTNhom17.Model.Course;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private List<Course> listCourse = new ArrayList<>();
    public void add(Course newProduct) {
        listCourse.add(newProduct);
    }

    public List<Course> GetAll() {
        return listCourse;
    }

    public List<Course> getUpcomingCourses() {
        LocalDate currentDate = LocalDate.now();
        return listCourse.stream()
                .filter(course -> course.getStartDate().isAfter(currentDate))
                .collect(Collectors.toList());
    }
}
