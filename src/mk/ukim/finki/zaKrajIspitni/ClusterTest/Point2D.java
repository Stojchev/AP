package mk.ukim.finki.zaKrajIspitni.ClusterTest;

public class Point2D {
    long ID;
    double x;
    double y;

    public Point2D(long id, float x, float y) {
        this.ID = id;
        this.x = x;
        this.y = y;
    }

    public long getID() {
        return ID;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double calculateNearestPath(Point2D o) {
        return Math.sqrt((x - o.getX()) * (x - o.getX()) - (y - o.getY()) * (y - o.getY()));
    }

}
