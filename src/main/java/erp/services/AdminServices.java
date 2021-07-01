package erp.services;

import erp.model.ButtonsRequest;
import erp.model.Courses;
import erp.model.StudentOutput;
import org.hibernate.sql.OracleJoinFragment;

import java.util.List;

public interface AdminServices {
    public List<String> getFaculty();

    public List<String> getDomains();

    public List<Integer> getYears();

    public List<Integer> getCapacity();

    public List<String> getSpecializations();

    public List<Courses> getCourses(ButtonsRequest buttonsRequest);

    public List<String> getCourseNamesDropdown(ButtonsRequest buttonsRequest);

    public List<StudentOutput> getStudentsByOrdering(ButtonsRequest buttonsRequest);

    public List<String> checkStudentEmail(ButtonsRequest buttonsRequest);

    public List<String> checkAdminEmail(ButtonsRequest buttonsRequest);

}
