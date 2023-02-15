package mk.ukim.finki.zaKrajIspitni.ClusterTest;

import java.util.ArrayList;
import java.util.List;

public class Cluster<T extends Point2D> {

    List<T> point2DList;

    public Cluster() {
        this.point2DList = new ArrayList<>();
    }

    public void addItem(T point2D) {
        point2DList.add(point2D);
    }

    public void near(int id, int top) {
        point2DList.stream().filter(i->i.calculateNearestPath(point2DList.get(id))>0).forEach(i-> System.out.println(i.getID()+" "+i.calculateNearestPath(point2DList.get(id))));
    }
}
