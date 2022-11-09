class Module extends KeyableMap<Assessment> implements Keyable {

    public Module(String key) {
        super(key);
    }

    @Override
    public String getKey() {
        return super.getKey();
    }

    @Override
    public Module put(Assessment assessment) {
        super.put(assessment);
        return (Module)this;
    }
}
