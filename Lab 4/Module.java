import java.util.HashMap;

class Module extends KeyableMap<Assessment> implements Keyable {  

    Module(String moduleName) {
        super(moduleName);
    }

    Module put(Assessment assessment) {        
        super.put(assessment);
        return (Module)this;        
    }

    public String getKey() {
        return super.getKey();
    }         
}
