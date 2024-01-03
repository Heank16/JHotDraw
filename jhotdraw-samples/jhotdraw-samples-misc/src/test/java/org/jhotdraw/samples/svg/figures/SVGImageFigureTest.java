package org.jhotdraw.samples.svg.figures;

import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
public class SVGImageFigureTest {

    Graphics2D g;
    SVGImageFigure imageFigure;

    @Before
    public void testImage() {
        g = mock(Graphics2D.class);
        imageFigure = new SVGImageFigure(95, 15, 50, 50);
        assertEquals(50, imageFigure.getBounds().getHeight(), 0);
    }


    @Test
    public void testImageInsertion(){
        //Tries to add an image from a folder to the canvas
        try{
            imageFigure.loadImage(new File("src/main/resources/pictures/billede.jpg"));
        }catch (IOException e){
            System.out.println("Error occurred");
        }
        imageFigure.setImage(imageFigure.getImageData(), imageFigure.getBufferedImage());
        assertFalse(imageFigure.isEmpty());
            if (imageFigure.isEmpty()) {
            System.out.println("No picture was added");
        } else {
            System.out.println("A picture was successfully added");
        }
    }

    @Test
    public void testImageCloneSize() {
        SVGImageFigure clone = imageFigure.clone();
        assertEquals(50, clone.getBounds().getHeight(), 0);
        if (imageFigure.getBounds().getHeight() == 50) {
            System.out.println("Perfect size");
        } else {
            System.out.println("Not the right size");
        }
    }

    @Test
    public void testImageTransform() {
        assertEquals(95, imageFigure.getBounds().getX(), 0);
        assertEquals(15, imageFigure.getBounds().getY(), 0);
        AffineTransform transformation = new AffineTransform();
        transformation.setToTranslation(13, 3);
        imageFigure.transform(transformation);
        assertNotEquals(1, imageFigure.getBounds().getX(), 0);
        assertNotEquals(1, imageFigure.getBounds().getY(), 0);
    }

}