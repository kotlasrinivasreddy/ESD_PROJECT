package erp.dal;

import erp.model.ButtonsRequest;
import erp.model.Courses;
import erp.model.StudentOutput;

import java.util.List;

public interface AdminServicesDAO {
    List<String> getFaculty();

    List<String> getDomains();

    List<Integer> getYears();

    List<Integer> getCapacity();

    List<String> getSpecializations();

    List<Courses> getCourses(ButtonsRequest buttonsRequest);

    List<String> getCourseNamesDropdown(ButtonsRequest buttonsRequest);

    List<StudentOutput> getStudentsByOrdering(ButtonsRequest buttonsRequest);

    List<String> checkStudentEmail(ButtonsRequest buttonsRequest);

    List<String> checkAdminEmail(ButtonsRequest buttonsRequest);

}
