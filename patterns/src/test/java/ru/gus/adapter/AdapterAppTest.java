package ru.gus.adapter;

import org.junit.Test;


public class AdapterAppTest {

    @Test
    public void inheritBased() {
        VectorGraphicInterface draw = new VectorAdapterFromRaster();
        draw.drawLine();
        draw.drawSquare();
    }

    @Test
    public void compositeBased() {
        VectorAdapterFromRasterCompose adapter = new VectorAdapterFromRasterCompose(new RasterGraphics());
        adapter.drawLine();
        adapter.drawSquare();
    }
}