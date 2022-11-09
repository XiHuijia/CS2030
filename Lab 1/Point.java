class Point {
    //properties
    private final double x;
    private final double y;

    //constructor
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "point (" + String.format("%.3f", this.x)
            + ", " + String.format("%.3f", this.y) + ")";
    }

    Point midPoint(Point q) {
        double disX = this.x - q.x;
        double disY = this.y - q.y;
        double midX = this.x - 0.5 * disX;
        double midY = this.y - 0.5 * disY;
        return new Point(midX, midY);
    }

    double angleTo(Point q) {
        double ang = Math.atan2(q.y - this.y, q.x - this.x);
        return ang;
    }

    Point moveTo(double theta, double d) {
        double newx = this.x + d * Math.cos(theta);
        double newy = this.y + d * Math.sin(theta);
        return new Point(newx, newy); 
    }

    double distanceTo(Point q) {
        double disX = this.x - q.x;
        double disY = this.y - q.y;
        return Math.sqrt(disX * disX + disY * disY);
    }
}
