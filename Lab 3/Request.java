class Request {
    private final int distance;
    private final int pax;
    private final int time;

    Request(int distance, int pax, int time) {
        this.distance = distance;
        this.pax = pax;
        this.time = time;
    }

    int getDistance() {
        return this.distance;
    }

    int getPax() {
        return this.pax;
    }

    int getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return this.distance + "km for " + this.pax + "pax @ " + this.time + "hrs";
    }
}
