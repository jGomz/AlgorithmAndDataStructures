package DependencyInjection;

public class Drawing {
    private Shape shape;

    public void setShape(Shape shape){
        this.shape = shape;
    }

    public static void main(String[] args){

        Drawing clasObj = new Drawing();
        Shape obj = new Triangle();

        clasObj.setShape(obj);
        clasObj.myDrawMethod();
    }

    public void myDrawMethod()
    {
        this.shape.draw();
    }

}
