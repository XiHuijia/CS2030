class Circle {
    private final Point centre;
    private final double radius;
    
    //constructor
    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    boolean contains(Point a) {
        return this.centre.distanceTo(a) <= this.radius;
    }

    public String toString() {
        return "circle of radius " + this.radius + " centered at " + this.centre;
    }
}


