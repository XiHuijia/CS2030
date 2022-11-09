Circle createUnitCircle(Point p, Point q){
    double lenPQ = p.distanceTo(q);
    double lenMidToCentre = Math.sqrt(1 - 0.25*lenPQ*lenPQ);
    double angTheta = p.angleTo(q);
    Point mid = p.midPoint(q);
    Point newCentre = mid.moveTo(angTheta + Math.PI/2, lenMidToCentre);
    return new Circle(newCentre, 1);
}

int findMaxDiscCoverage(Point[] points) {
    int maxDiscCoverage = 0;

    for (int i = 0; i < points.length - 1; i++) {

        for (int j = i + 1; j < points.length; j++) {
            int discCoverage = 0;

            if (points[i].distanceTo(points[j]) <= 2){
                Circle unitCircle = createUnitCircle(points[i], points[j]);

                for (Point p: points){
                    if (unitCircle.contains(p)){discCoverage++;}
                }

                if (discCoverage > maxDiscCoverage){maxDiscCoverage = discCoverage;}
            }
        }
    }
    return maxDiscCoverage;
}

