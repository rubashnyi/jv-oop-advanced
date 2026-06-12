package core.basesyntax;

import java.util.Random;

public class FigureSupplier {

    private final ColorSupplier colorSupplier = new ColorSupplier();
    private final Random random = new Random();

    private int getRandomSize() {
        return random.nextInt(10) + 1;
    }

    public Figure getRandomFigure() {
        String color = colorSupplier.getRandomColor();
        int type = random.nextInt(5);

        return switch (type) {
            case 0 -> new Square(color, getRandomSize());
            case 1 -> new Rectangle(color, getRandomSize(), getRandomSize());
            case 2 -> new RightTriangle(color, getRandomSize(), getRandomSize());
            case 3 -> new Circle(color, getRandomSize());
            default -> new IsoscelesTrapezoid(color,
                    getRandomSize(),
                    getRandomSize(),
                    getRandomSize());
        };
    }

    public Figure getDefaultFigure() {
        return new Circle("White", 10);
    }
}

