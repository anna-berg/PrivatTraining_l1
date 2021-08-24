package Lesson3.Adapter;

public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphicInterface vector = new VectorAdapterFromRaster();
        vector.drawLine();
        vector.drawSquare();

        VectorAdapterFromRaster2 vector2 = new VectorAdapterFromRaster2(new RasterGraphic());
        vector2.drawLine();
        vector2.drawSquare();
    }
}
interface VectorGraphicInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphic{
    void drawRasterLine(){
        System.out.println("Draw Raster Line");
    }
void drawRasterSquare(){
        System.out.println("Draw Raster Square");
    }
}

class VectorAdapterFromRaster extends  RasterGraphic implements VectorGraphicInterface{
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
class VectorAdapterFromRaster2 implements VectorGraphicInterface{
    RasterGraphic rasterGraphic = null; //new RasterGraphic();

    public VectorAdapterFromRaster2(RasterGraphic rasterGraphic) {
        this.rasterGraphic = rasterGraphic;
    }

    @Override
    public void drawLine() {
        rasterGraphic.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphic.drawRasterSquare();
    }
}