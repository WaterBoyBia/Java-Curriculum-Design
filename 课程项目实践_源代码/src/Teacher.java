

import java.util.ArrayList;

public class Teacher {

    ArrayList<Lesson> MyLesson = new ArrayList<Lesson>();

    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public String getNum() {
        return number;
    }

    public void setNum(String s) {
        number = s;
    }
}
