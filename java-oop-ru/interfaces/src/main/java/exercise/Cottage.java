package exercise;

public class Cottage implements Home {

    private final Double area;
    private final Integer floorCount;

    public Cottage(Double area, Integer floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public Cottage(Integer area, Integer floorCount) {
        this.area = Double.parseDouble(area.toString());
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home home) {
        return this.getArea() - home.getArea() >= 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return String.format("%d этажный коттедж площадью %.1f метров", floorCount, getArea());
    }
}