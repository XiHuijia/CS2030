import java.util.HashMap;

class Student extends KeyableMap<Module> implements Keyable {

    Student(String stuName) {
        super(stuName);      
    }

    Student put(Module module) {
        super.put(module);
        return (Student)this;
    }
    
    public String getKey() {
        return super.getKey();
    }
}