package exercise;

public class Flat implements Home {
    private final Double area;
    private final Double balconyArea;
    private final Integer floor;

    public Flat(Integer area, Integer balconyArea, Integer floor) {
        this.area = Double.parseDouble(area.toString());
        this.balconyArea = Double.parseDouble(balconyArea.toString());
        this.floor = floor;
    }

    public Flat(Double area, Double balconyArea, Integer floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }


    @Override
    public String toString() {
        return String.format("Квартира площадью %.1f метров на %d этаже", getArea(), floor);
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home home) {
        return this.getArea() - home.getArea() >= 0 ? 1 : -1;
    }
}