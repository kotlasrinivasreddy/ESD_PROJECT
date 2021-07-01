package erp.dal;

import erp.model.*;
import erp.utilities.Factory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdminServicesDAOImpl implements AdminServicesDAO {
    @Override
    public List<String> getFaculty() {
        Session session = Factory.getSession();
        List<String> fac = new ArrayList<>();
        try {
            for (Object emp : session.createQuery("from Employees E where E.department in (from Department where dept_id=1 or dept_id=2)").list()) {
                //courses.add((Department) course);
                String name = ((Employees) emp).getFirst_name();
                name = name.concat(" ");
                name = name.concat(((Employees) emp).getLast_name());

                //System.out.println(name);

                if (fac.contains(name) == false)
                    fac.add(name);
            }
            //System.out.println(fac.get(0));
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return fac;
    }


    @Override
    public List<String> getDomains() {
        Session session = Factory.getSession();
        List<String> domains = new ArrayList<>();
        try {
            for (Object domain : session.createQuery("from Domains ").list()) {
                //courses.add((Department) course);
                if (!domains.contains(((Domains) domain).getProgram()))
                    domains.add(((Domains) domain).getProgram());
            }
            //System.out.println(domains.get(0));
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return domains;
    }

    @Override
    public List<Integer> getYears() {
        Session session = Factory.getSession();
        List<Integer> years = new ArrayList<>();
        try {
            for (Object year : session.createQuery("from Courses ").list()) {
                //courses.add((Department) course);
                if (!years.contains(((Courses) year).getYear()))
                    years.add(((Courses) year).getYear());
            }
            //System.out.println(depts.get(0));
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return years;
    }

    @Override
    public List<Integer> getCapacity() {
        Session session = Factory.getSession();
        List<Integer> caps = new ArrayList<>();
        try {
            for (Object cap : session.createQuery("from Courses ").list()) {
                //courses.add((Department) course);
                if (!caps.contains(((Courses) cap).getCapacity()))
                    caps.add(((Courses) cap).getCapacity());
            }
            //System.out.println(depts.get(0));
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return caps;
    }

    @Override
    public List<String> getSpecializations() {
        Session session = Factory.getSession();
        List<String> specs = new ArrayList<>();
        try {
            for (Object spec : session.createQuery("from Specialization ").list()) {
                //courses.add((Department) course);
                specs.add(((Specialization) spec).getName());
            }
            //System.out.println(depts.get(0));
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return specs;
    }

    // getCourses stored proc starts here
    @Override
    public List<Courses> getCourses(ButtonsRequest buttonsRequest) {
        Session session = Factory.getSession();
        List<Courses> courses = new ArrayList<>();

        //Object domain, year, faculty, capacity, specialization;
        if (buttonsRequest.getDomain().equals("select Domain"))
            buttonsRequest.setDomain(null);
//        else
//            domain= buttonsRequest.getDomain();
        if (buttonsRequest.getYear().equals("select Academic Year"))
            buttonsRequest.setYear(null);
//        else
//            year= buttonsRequest.getYear();
        if (buttonsRequest.getFaculty().equals("select Subject Faculty"))
            buttonsRequest.setFaculty(null);
//        else
//            faculty= buttonsRequest.getFaculty();
        if (buttonsRequest.getCapacity().equals("select Capacity"))
            buttonsRequest.setCapacity(null);
//        else
//            capacity= buttonsRequest.getCapacity();
        if (buttonsRequest.getSpecialization().equals("select Course Specialization"))
            buttonsRequest.setSpecialization(null);
//        else
//            specialization= buttonsRequest.getSpecialization();

        //if none of the buttons are chosen, reply with no courses available
        // for specified option. No need to invoke db also
        if (buttonsRequest.getDomain() == null && buttonsRequest.getYear() == null &&
                buttonsRequest.getFaculty() == null && buttonsRequest.getCapacity() == null &&
                buttonsRequest.getSpecialization() == null)
            return courses;
//        System.out.println(buttonsRequest.getDomain());
//        System.out.println(buttonsRequest.getYear());
//        System.out.println(buttonsRequest.getFaculty());
//        System.out.println(buttonsRequest.getCapacity());
//        System.out.println(buttonsRequest.getSpecialization());
        try {
            Query query = session.createSQLQuery(
                    "CALL usp_showAdmin(:domain, :year, :faculty, :capacity, :specialization)")
                    .addEntity(Courses.class)
                    .setParameter("domain", (Object) buttonsRequest.getDomain())
                    .setParameter("year", (Object) buttonsRequest.getYear())
                    .setParameter("faculty", (Object) buttonsRequest.getFaculty())
                    .setParameter("capacity", (Object) buttonsRequest.getCapacity())
                    .setParameter("specialization", (Object) buttonsRequest.getSpecialization());

//            Query query= session.createSQLQuery(
//                    "CALL usp_showAdmin(:i_domain, :i_year, :i_faculty, :i_capacity, :i_spec)")
//                    .addEntity(Courses.class)
//                    .setParameter("i_domain", domain)
//                    .setParameter("i_year", year)
//                    .setParameter("i_faculty", faculty)
//                    .setParameter("i_capacity", capacity)
//                    .setParameter("i_spec", specialization);

//            Query query= session.createSQLQuery(
//                    "CALL usp_showAdmin(:i_domain, :i_year, :i_faculty, :i_capacity, :i_spec)")
//                    .addEntity(Courses.class)
//                    .setParameter("i_domain", (Object)buttonsRequest.getDomain())
//                    .setParameter("i_year", (Object)buttonsRequest.getYear())
//                    .setParameter("i_faculty", (Object) buttonsRequest.getFaculty())
//                    .setParameter("i_capacity", (Object) buttonsRequest.getCapacity())
//                    .setParameter("i_spec", (Object) buttonsRequest.getSpecialization());

            //System.out.println(query.list());
            for (Object course : query.list()) {
                courses.add(((Courses) course));
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return courses;
    } // end of getCourses method


    @Override
    public List<String> getCourseNamesDropdown(ButtonsRequest buttonsRequest) {
        Session session = Factory.getSession();
        List<String> course_names = new ArrayList<>();

        System.out.println("inside get course names dropdown java dao method");
        // if specialization is not selected, then don't fill course dropdown
        if(buttonsRequest.getSpecialization().equals("select User Course Specialization"))
            return course_names;

        System.out.println(buttonsRequest.getSpecialization());
        String specialization= (String)buttonsRequest.getSpecialization();

        try {
            Query query = session.createQuery(
                    "select c.name from Courses c where c.course_id in " +
                            "(select course_id from SpecializationCourse where specialization_id in " +
                            "(select specialization_id from Specialization where name = '"+
                             specialization + "'))");

            for (Object course_name : query.list()) {
                course_names.add((String)course_name);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return course_names;
    } // get courses drop down method end


    //get students by ordering stored proc call
    //using same buttonrequest java class 2 variables
    // domain as coursename, faculty as ordering
    @Override
    public List<StudentOutput> getStudentsByOrdering(ButtonsRequest buttonsRequest)
    {
        Session session = Factory.getSession();
        List<StudentOutput> students = new ArrayList<>();

        System.out.println("inside get students by ordering");
        System.out.println(buttonsRequest.getDomain());
        System.out.println(buttonsRequest.getFaculty());

        if (buttonsRequest.getFaculty().equals("select ordering"))
            buttonsRequest.setFaculty("ascending");

        try {
            Query query = session.createSQLQuery(
                    "CALL usp_showStudent(:coursename, :ordertype)")
                    .addEntity(StudentOutput.class)
                    .setParameter("coursename", (String)buttonsRequest.getDomain())
                    .setParameter("ordertype", (String) buttonsRequest.getFaculty());

//            Query query = session.createSQLQuery(
//                    "CALL usp_showStudent(:coursename, :ordertype)")
//                    .addEntity(StudentOutput.class)
//                    .setParameter("coursename", "Machine Learning")
//                    .setParameter("ordertype", "descending");


            for (Object student : query.list()) {
                students.add((StudentOutput)student);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return students;
    }


    @Override
    public List<String> checkStudentEmail(ButtonsRequest buttonsRequest) {
        Session session = Factory.getSession();
        List<String> result = new ArrayList<>();
        try {
            Query query =  session.createQuery("from Students where email = :email_ID")
                    .setParameter("email_ID", buttonsRequest.getDomain());
            List<Object> emails = query.list();
            //courses.add((Department) course);

            //System.out.println(name);
            if(emails.size() > 0){
                result.add("success");
                return result;
            }
            result.add("fail");

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public List<String> checkAdminEmail(ButtonsRequest buttonsRequest) {
        Session session = Factory.getSession();
        List<String> result = new ArrayList<>();
        try {
            Query query =  session.createQuery("from Employees E where E.email = :email_ID and E.department in (from Department where dept_id = 3)")
                    .setParameter("email_ID", buttonsRequest.getDomain());
            List<Object> emails = query.list();
            //courses.add((Department) course);

            //System.out.println(name);
            if(emails.size() > 0){
                result.add("success");
                return result;
            }
            result.add("fail");

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return result;
    }

}
