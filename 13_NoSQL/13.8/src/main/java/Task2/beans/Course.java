package Task2.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }
}
