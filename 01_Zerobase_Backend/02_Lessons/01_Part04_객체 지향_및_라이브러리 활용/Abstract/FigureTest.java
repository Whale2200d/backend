package Abstract;

public class FigureTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1, 1, 3, 4);
        triangle.draw();
        triangle.init();
        triangle.draw();
    }
}