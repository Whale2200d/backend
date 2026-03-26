package Abstract;

public class Triangle extends Figure {
    int width;
    int height;

    public Triangle (int xValue, int yValue, int width, int height) {
        super(xValue, yValue);
        this.width = width;
        this.height = height;
    }

    @Override
    public void init() {
        super.init();
        width = 0;
        height = 0;
    }

    @Override
    public void draw() {
        System.out.println("xValue: "+ xValue + ", yValue: " + yValue);
        System.out.println("move by " + this.width + " on the x-axis");
        System.out.println("move by " + this.height + " on the y-axis");
    }
}
