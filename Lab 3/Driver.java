class Driver {
	private final String license;
    private final int waitingTime;

    Driver(String license, int waitingTime) {
        this.license = license;
        this.waitingTime = waitingTime;
    }

    String getLicense() {
        return this.license;
    }

    int getWaitingTime() {
        return this.waitingTime;
    }
}