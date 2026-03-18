import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<DataPoint> data;

    public Model() {
        data = new ArrayList<>();
    }

    public void addX(double x) throws DuplicateXException {
        if (data.contains(new DataPoint(x))) {
            throw new DuplicateXException("Значение x=" + x + " уже есть в таблице.");
        }
        data.add(new DataPoint(x));
    }

    public void removeX(int index) {
        if (index >= 0 && index < data.size()) {
            data.remove(index);
        }
    }

    public void updateX(int index, double newX) throws DuplicateXException {
        if (index >= 0 && index < data.size()) {
            DataPoint point = data.get(index);
            if (point.getX() == newX || data.contains(new DataPoint(newX))) {
                throw new DuplicateXException("Значение x=" + newX + " уже есть в таблице.");
            }
            point.setX(newX);
        }
    }

    public List<DataPoint> getData() {
        return data;
    }
}
