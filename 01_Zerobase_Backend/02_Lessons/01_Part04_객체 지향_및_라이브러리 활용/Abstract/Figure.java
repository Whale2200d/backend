package Abstract;

public abstract class Figure {
    protected int xValue;
    protected int yValue;

    public Figure(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public void init() {
        xValue = 0;
        yValue = 0;
    }

    public abstract void draw();
}
