package erp.services;

import erp.dal.AdminServicesDAO;
import erp.dal.AdminServicesDAOImpl;
import erp.model.ButtonsRequest;
import erp.model.Courses;
import erp.model.StudentOutput;
import erp.utilities.Factory;

import java.util.List;

public class AdminServicesImpl implements AdminServices{
    @Override
    public List<String> getFaculty() {
        //AdminServicesDAO adminDAO = new AdminServicesDAOImpl();
        AdminServicesDAO adminDAO = Factory.getAdminDAO();
        return adminDAO.getFaculty();
    }
    @Override
    public List<String> getDomains() {
        AdminServicesDAO adminDAO = Factory.getAdminDAO();
        return adminDAO.getDomains();
    }
    @Override
    public List<Integer> getYears(){
        AdminServicesDAO adminDAO = Factory.getAdminDAO();
        return adminDAO.getYears();
    }
    @Override
    public List<Integer> getCapacity(){
        AdminServicesDAO adminDAO = Factory.getAdminDAO();
        return adminDAO.getCapacity();
    }
    @Override
    public List<String> getSpecializations() {
        AdminServicesDAO adminDAO = Factory.getAdminDAO();
        return adminDAO.getSpecializations();
    }
    @Override
    public List<Courses> getCourses(ButtonsRequest buttonsRequest)
    {
        AdminServicesDAO adminDAO= Factory.getAdminDAO();
        return adminDAO.getCourses(buttonsRequest);
    }
    @Override
    public List<String> getCourseNamesDropdown(ButtonsRequest buttonsRequest)
    {
        AdminServicesDAO adminDAO= Factory.getAdminDAO();
        return adminDAO.getCourseNamesDropdown(buttonsRequest);
    }
    @Override
    public List<StudentOutput> getStudentsByOrdering(ButtonsRequest buttonsRequest)
    {
        AdminServicesDAO adminDAO= Factory.getAdminDAO();
        return adminDAO.getStudentsByOrdering(buttonsRequest);
    }

    @Override
    public List<String> checkStudentEmail(ButtonsRequest buttonsRequest){
        AdminServicesDAO adminDAO = Factory.getAdminDAO();
        return adminDAO.checkStudentEmail(buttonsRequest);
    }
    @Override
    public List<String> checkAdminEmail(ButtonsRequest buttonsRequest){
        AdminServicesDAO adminDAO = Factory.getAdminDAO();
        return adminDAO.checkAdminEmail(buttonsRequest);
    }
}
