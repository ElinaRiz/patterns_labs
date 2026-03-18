public class DataPoint {
    private double x;
    private double y;

    public DataPoint(double x) {
        this.x = x;
        this.y = calculateY(x);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        this.y = calculateY(x);
    }

    public double getY() {
        return y;
    }

    private double calculateY(double x) {
        return x * x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof DataPoint))
            return false;
        DataPoint point = (DataPoint) obj;
        return x == point.getX() && y == point.getY();
    }
}
