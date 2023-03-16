public class SolidFillShapeDecorator extends ShapeDecorator{
    private String color;

    public SolidFillShapeDecorator(Shape shape, String color){
        super(shape);
        this.color = color;
    }

    public String toSvg(String parameters){
        return super.toSvg(String.format("fill=\"%s\" %s ",color, parameters));
    };
}
