public class TransformationDecorator extends ShapeDecorator{
    private String rotate,scale,translate;

    public TransformationDecorator(Shape shape){
        super(shape);
    }

    public static class Builder{
        private boolean translate = false;
        private Vec2 translateVector;

        private boolean rotate= false;
        private double rotateAngle;
        private Vec2 rotateCenter;
        private boolean scale= false;
        private Vec2 scaleVector;

        private Shape shape;

        public Builder translate(Vec2 translateVector){
            this.translateVector = translateVector;
            this.translate = true;
            return this;
        }
        public Builder rotate(Vec2 rotateCenter,double rotateAngle){
            this.rotateCenter = rotateCenter;
            this.rotateAngle = rotateAngle;
            this.rotate = true;
            return this;
        }
        public Builder scale(Vec2 scaleVector){
            this.scaleVector = scaleVector;
            this.scale = true;
            return this;
        }
        public Builder shape(Shape shape){
            this.shape = shape;
            return this;
        }
        public TransformationDecorator build(){
            TransformationDecorator decorator = new TransformationDecorator(shape);
            if(translate){
                decorator.translate = String.format("translate(%f %f) ", translateVector.x, translateVector.y);
            }else{
                decorator.translate = "";
            }
            decorator.rotate = rotate ? (String.format("rotate(%f %f %f) ", rotateAngle, rotateCenter.x, rotateCenter.y)):"";
            decorator.scale = scale ? (String.format("scale(%f %f) ", scaleVector.x, scaleVector.y)):"";

            return decorator;
        }
    }
}