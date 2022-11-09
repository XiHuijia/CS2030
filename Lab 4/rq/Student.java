class Student extends KeyableMap<Module> implements Keyable {

    public Student(String name) {
        super(name);
    }

    public String getName() {
        return super.getKey();
    }

    @Override
    public Student put(Module module) {
        super.put(module);
        return (Student)this;
    }
}
