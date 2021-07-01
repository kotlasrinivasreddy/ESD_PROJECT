package erp.model;

public class ButtonsRequest {
    private Object domain;
    private Object year;
    private Object faculty;
    private Object capacity;
    private Object specialization;

    public Object getDomain() {
        return domain;
    }

    public void setDomain(Object domain) {
        this.domain = domain;
    }

    public Object getYear() {
        return year;
    }

    public void setYear(Object year) {
        this.year = year;
    }

    public Object getFaculty() {
        return faculty;
    }

    public void setFaculty(Object faculty) {
        this.faculty = faculty;
    }

    public Object getCapacity() {
        return capacity;
    }

    public void setCapacity(Object capacity) {
        this.capacity = capacity;
    }

    public Object getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Object specialization) {
        this.specialization = specialization;
    }

    public ButtonsRequest()
    {

    }
    public ButtonsRequest(Object domain, Object year, Object faculty, Object capacity, Object specialization) {
        this.domain = domain;
        this.year = year;
        this.faculty = faculty;
        this.capacity = capacity;
        this.specialization = specialization;
    }

}
