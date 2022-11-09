class NormalCab extends Driver {
    NormalCab(String license, int waitingTime) {
        super(license, waitingTime);
    }

    @Override
    public String toString() {
        return this.getLicense() + " (" + this.getWaitingTime() + " mins away) NormalCab";
    }
}
