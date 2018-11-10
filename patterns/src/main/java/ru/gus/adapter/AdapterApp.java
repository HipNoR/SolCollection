package ru.gus.adapter;

/**
 * AdapterPattern.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 10.11.2018
 */
public class AdapterApp {
}

interface VectorGraphicInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("I am line!");
    }

    void drawRasterSquare() {
        System.out.println("i am square!");
    }
}

// через наследование
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

//через композицию

class VectorAdapterFromRasterCompose  implements VectorGraphicInterface {
    RasterGraphics raster;

    public VectorAdapterFromRasterCompose(RasterGraphics raster) {
        this.raster = raster;
    }

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
       raster.drawRasterSquare();
    }
}