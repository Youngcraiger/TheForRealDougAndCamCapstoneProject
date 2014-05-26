// This is a STUB with some working methods and others you must complete yourself
// All method signatures below are correct - do not modify them.
package backend_models;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author cheng
 */
public class PicFile {

    // these are all the instance variables you need to have
    String path;
    BufferedImage fileContent;
    public Color color = Color.BLUE;

    // this constructor is completed for you
    public PicFile(String path) throws IOException {
        this.path = path;
        this.fileContent = readFile(path);
    }
    

    public int getWidth() {
        int i = fileContent.getWidth();
        return i;
        // how do you find and return the width of this.fileContent ?
    }

    public int getHeight() {
        int i = fileContent.getHeight();
        return i;
        // how do you find and return the height of this.fileContent ?
    }

    public int getPixelCount() {
        int i = fileContent.getTileHeight() * fileContent.getTileWidth();
        return i;
        // how do you calculate and return the total number of pixels in this.fileContent ?
    }

    public Color getColor(int x, int y) {
        if (x >= 0 || x <= this.fileContent.getWidth()) {
            if (y >= 0 || y <= this.fileContent.getHeight()) {
                return color;
            }
        }
        // for safety, you should check if x and y are within the proper range
        // of this.fileContent

        return null;
        // How do you get the RGB value at pixel (x, y) from this.fileContent ?
        // Then return that RGB value wrapped up as a Color object?
    }

    public Color getColor(int pIndex) {
        // What if we index the pixels from left to right, then top to bottom?
        // So a 2 by 2 pixels image has pixels indexed on the top row as 0 and 1
        // then pixels on the second row are indexed as 2 and 3.
        // Those indexes are called the pIndex.

        // How do you calculate the (x,y) pixel coordinate
        // based on the pIndex parameter above?

        int y = pIndex;
        int x = pIndex;
        return this.getColor(x, y); // this line is fine, fix the above 2 lines
    }

    public void setColor(int pIndex, Color c) {
        // Like getColor, this requires converting pIndex into (x,y) pixel
        // coordinates.
        int y = 0;
        int x = 0;
        this.setColor(x, y, c); // this line is fine, fix the above 2 lines
    }

    public void setColor(int x, int y, Color c) {
        // For safety, you should check if x and y are within the proper range
        // of this.fileContent
        if (x >= 0 || x <= this.fileContent.getWidth()) {
            if (y >= 0 || y <= this.fileContent.getHeight()) {
                this.fileContent.setRGB(x, y, c.getRGB());
            }
        }
        // Now write a line of code that tells this.fileContent
        // to set its RGB value for pixel at coordinate (x,y)
        // to the RGB value stored in the parameter c
    }

    // this method is completed for you
    public BufferedImage getAsBufferedImage() {
        return this.fileContent;
    }

    // this method is completed for you
    public File getAsFile() {
        return new File(this.path);
    }

    // this method is completed for you
    public JLabel getAsJLabel() {
        ImageIcon icon = new ImageIcon(this.fileContent);
        return new JLabel(icon);
    }

    // this method is completed for you
    public ImageIcon getAsImageIcon() {
        ImageIcon icon = new ImageIcon(this.fileContent);
        return icon;
    }
    


    // this method is completed for you
    public void saveToDisk(String pathWithoutExtension, String jpgOrPngExtension) throws IOException {
        jpgOrPngExtension = jpgOrPngExtension.toLowerCase();

        if (jpgOrPngExtension.equals("jpg") || jpgOrPngExtension.equals("png")) {
            ImageIO.write(this.fileContent, jpgOrPngExtension, new File(pathWithoutExtension + "." + jpgOrPngExtension));
        } else {
            System.out.println("Error: filename must end in .jpg or .png");
        }
    }

    // this method is completed for you
    public static BufferedImage readFile(String path) throws IOException {
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);

        if (image == null) {
            throw new RuntimeException("Invalid image file: " + file);
        }

        return image;
    }
    private Random randomNumber = new Random();
    public Color getRandomColour(){
        return new Color(randomNumber.nextFloat(), randomNumber.nextFloat(), randomNumber.nextFloat());
    }
}
