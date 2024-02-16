package EX3;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    private String name;
    public Person(int _age, String _name) {
        age = _age;
        name = _name;
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
