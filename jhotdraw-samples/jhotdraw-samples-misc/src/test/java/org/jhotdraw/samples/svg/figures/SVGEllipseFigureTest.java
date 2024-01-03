package org.jhotdraw.samples.svg.figures;

import org.junit.Test;

import java.awt.geom.AffineTransform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SVGEllipseFigureTest {
    @Test
    public void EllipseCreationTest() {
        SVGEllipseFigure ellipse = new SVGEllipseFigure(10, 10, 15, 50);

        assertNotNull(ellipse);
        assertEquals(10.0, ellipse.getX(), 0.0);
        assertEquals(10.0, ellipse.getY(), 0.0);
        assertEquals(15.0, ellipse.getWidth(), 0.0);
        assertEquals(50.0, ellipse.getHeight(), 0.0);
    }

    @Test
    public void EllipseDefaultCreationTest(){
        SVGEllipseFigure ellipse =  new SVGEllipseFigure();

        assertNotNull(ellipse);
        assertEquals(0, ellipse.getX(), 0.0);
        assertEquals(0, ellipse.getY(), 0.0);
        assertEquals(0, ellipse.getWidth(), 0.0);
        assertEquals(0, ellipse.getHeight(), 0.0);
    }

    @Test
    public void EllipseTransformationTest() {
        SVGEllipseFigure ellipse = new SVGEllipseFigure(10, 10, 15, 50);
        ellipse.willChange();
        ellipse.transform(AffineTransform.getTranslateInstance(10, 10));
        ellipse.changed();

        assertEquals(20.0, ellipse.getX(), 0.0);
        assertEquals(20.0, ellipse.getY(), 0.0);
        assertEquals(15.0, ellipse.getWidth(), 0.0);
        assertEquals(50.0, ellipse.getHeight(), 0.0);
    }
}