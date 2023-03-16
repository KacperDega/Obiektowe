public class StrokeShapeDecorator extends ShapeDecorator{
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape shape, String color, double width){
        super(shape);
        this.color = color;
        this.width = width;
    };

    public String toSvg(String parameters){
        return super.toSvg(String.format("stroke=\"%s\" stroke-width=\"%f\" ",color, width));
    };
}
