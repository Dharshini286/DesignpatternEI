interface Shape {
    void drawShape();
}

class Rectangle implements Shape {
    @Override
    public void drawShape() {
        System.out.println("Drawing Rectangle");
    }
}

class OldRectangle {
    public void draw() {
        System.out.println("Drawing Old Rectangle");
    }
}

class RectangleAdapter implements Shape {
    private OldRectangle oldRect;

    public RectangleAdapter(OldRectangle oldRect) {
        this.oldRect = oldRect;
    }

    @Override
    public void drawShape() {
        oldRect.draw();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        Shape shape1 = new Rectangle();
        shape1.drawShape();

        OldRectangle oldRect = new OldRectangle();
        Shape shape2 = new RectangleAdapter(oldRect);
        shape2.drawShape();
    }
}
