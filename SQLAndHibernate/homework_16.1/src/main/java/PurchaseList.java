import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
    @EmbeddedId
    private Key id;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Embeddable
    public static class Key implements Serializable {

        @Column(name = "student_name")
        private String studentName;
        @Column(name = "course_name")
        private String courseName;

        public String getStudentId() {
            return studentName;
        }

        public void setStudentId(String studentId) {
            this.studentName = studentId;
        }

        public String getCourseId() {
            return courseName;
        }

        public void setCourseId(String courseId) {
            this.courseName = courseId;
        }

        public Key(String studentName, String courseName) {
            this.studentName = studentName;
            this.courseName = courseName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(studentName, key.studentName) && Objects.equals(courseName, key.courseName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentName, courseName);
        }
    }
}
