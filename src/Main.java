public class Main {

    public static void main(String[] args) {
        Shape poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});
        //Shape poly = new SolidFilledPolygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)},"red");
        Shape ellipse = new Ellipse(new Vec2(300,400),200,50);

        poly = new SolidFillShapeDecorator(poly, "blue");
        ellipse = new SolidFillShapeDecorator(ellipse, "red");
        ellipse = new StrokeShapeDecorator(ellipse,"orange",12 );

        SvgScene scene=new SvgScene();
        scene.add(poly);
        scene.add(ellipse);
        scene.saveHtml("scene.html");

        ellipse = new TransformationDecorator.Builder()
                .shape(ellipse)
                .rotate(new Vec2(60,250),90)
                .build();
    }
}
