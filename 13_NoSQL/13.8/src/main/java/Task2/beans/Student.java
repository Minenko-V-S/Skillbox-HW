package Task2.beans;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@NoArgsConstructor
public class Student {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String courses;
    private List<Course> courseList = new ArrayList<>();

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }



    public Document createDoc() {
        Document document = new Document();
        document.put("Name", this.name);
        document.put("Age", this.age);
        document.put("Courses", this.courseList.stream()
                .map(course -> new Document().append("course:", course.getName())).collect(Collectors.toList()));
        return document;
    }

    public String getCourses() {
        return null;
    }
}
