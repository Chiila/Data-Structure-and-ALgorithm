public class StudentInformation {
    private String studentName;
    private String course;

    public StudentInformation(String studentName, String course) {
        this.studentName = studentName;
        this.course = course;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
