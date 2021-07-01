package erp;

import erp.model.ButtonsRequest;
import erp.services.AdminServices;
import erp.services.AdminServicesImpl;

public class AcademicMain {

    public static void main(String[] args) {
        AdminServices adSrc = new AdminServicesImpl();
        //System.out.println(adSrc.getFaculty());
        //System.out.println(adSrc.getDomains());
        //System.out.println(adSrc.getYears());
        //System.out.println(adSrc.getCapacity());
        System.out.println(adSrc.getSpecializations());
        ButtonsRequest buttonsRequest=new ButtonsRequest("Masters", 2020, "Muralidhara", 160, "Machine Learning");
        System.out.println(adSrc.getCourses(buttonsRequest));
    }

}
