/**
 * @author Izan Khan
 * @assignment CSC212-Program7B
 * @version March 18, 2019
 * 
 * Description: This program is going to use a variety of 
 * image processing techniques to manipulate an image.
 * 
 * 
 * 
 * Cite Assistance (who and what): (http://faculty.orangecoastcollege.edu/sgilbert/lessons/ImageProcessing3/index.html)
 *                                 Took help for Bonus Opportunity.
 */



import java.awt.*;
import javax.swing.*;

public class ImageManipulation {
    public static final int OFF_SET = 30;  // to account for the top border of the window
    public static final int MAX_COLOR_NUM = 255;


    public static void main(String args[]) throws Exception {

        // Read the image from the file.
        Image image = new Image("flowers.jpg");

        // get contrast percent and pixelating size from user
        double contrastPercent = getContrastPercent();
        System.out.println();
        int pixelateSize = getPixelateSize(image);
        System.out.println();

        // Create a frame to display the image.
        JFrame frame = new JFrame("My Image Manipulations");
        frame.setSize(4 * image.getWidth(), 2 * image.getHeight() + OFF_SET);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graphics g = frame.getGraphics();

        Thread.sleep(250);

        // Display the original image.
        image.draw(g, 0, OFF_SET);

        // Store the 2D array from the picture to manipulate
        int[][] imageArray = image.get2DArray();


        // Your code goes here to call each of your methods, set the image and
        // display it
        int width = image.getWidth();
        int height = image.getHeight();
        
        int[][] reliefArray = relief(imageArray, width, height);
        image.set2DArray(reliefArray);
        image.draw(g, width, OFF_SET);
        
        
        int[][] mirrorArray = mirror(imageArray, width, height);
        image.set2DArray(mirrorArray);
        image.draw(g, 2*width, OFF_SET);

        

        int[][] contrastArray = contrast(imageArray, 25, width, height);
        image.set2DArray(contrastArray);
        image.draw(g, 0, image.getHeight() + OFF_SET);

        int[][] blurArray = blur(imageArray, width, height);
        image.set2DArray(blurArray);
        image.draw(g, width, image.getHeight() + OFF_SET);

        int[][] pixelArray = pixelate(imageArray, 7,width, height);
        image.set2DArray(pixelArray);
        image.draw(g, width*2, image.getHeight() + OFF_SET);

        int[][] darkenArray = darken(imageArray,width, height);
        image.set2DArray(darkenArray);
        image.draw(g, width*3, OFF_SET);

        int[][] mirror2Array = mirror2(imageArray, width, height);
        image.set2DArray(mirror2Array);
        image.draw(g, 3*width, image.getHeight() + OFF_SET);



    }

    /**
     * Method getContrastPercent allows the user to enter a contrast value which must be
     * a positive integer
     * @param console-- Scanner to facilitate keyboard input
     * @return the user's valid contrast value converted to a decimal
     */
    public static double getContrastPercent() {
        boolean invalid = true;
        int contrastValue = 0;
        while (invalid) {
            try {
                contrastValue = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a constrast value: "));
                if (contrastValue <= 0) {
                    JOptionPane.showMessageDialog(null, "Error. Value must be positive.");
                } else {
                    invalid = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Error. Value must be an integer.");
            }
        }
        return contrastValue * 0.01;
    }

    /**
     * Produces the copy of the original image. This is done
     * so the original picture does not get manipulated.
     * 
     * @param src - 2D Array of integers of the Original Image.
     * @return - 2D Array of integers which produce the new image.
     */
    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }


    /**
     * Method getPixelateSize allows the user to enter a pixelate size which
     * must be a positive odd integer less than half of the minimum of the image's
     * width and height.
     * @param console-- Scanner to facilitate keyboard input
     * @return the user's valid pixelate size
     */
    public static int getPixelateSize(Image image) {
        int minimum = Math.min(image.getWidth(), image.getHeight());
        boolean invalid = true;
        int pixelateSize = 0;
        while (invalid) {
            try {
                pixelateSize = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a pixelate size: "));
                if (pixelateSize % 2 == 0 || pixelateSize >= minimum) {
                    JOptionPane.showMessageDialog(null,"Error. Value must be odd and less than half the smaller of the image's width and height.");
                } else {
                    invalid = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Error. Value must be an integer.");
            }
        }
        return pixelateSize;
    }

    /**
     * Produces the relief image of the original image.
     * 
     * @param img - 2D Array of integers from picture chosen.
     * @param width - Width of the image chosen.
     * @param height - Height of the image chosen.
     * @return - 2D Array of integers which produces the edited image i.e the relief image. 
     */
    public static int[][] relief(int[][] img, int width, int height) {
        int[][] image = cloneArray(img);



        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if( j + 2 >= width) {
                    image[i][j] = 0;
                }
                else {
                    image[i][j] = image[i][j] + 128 - image[i][j + 2];
                }
            }
        }
        return image;


    }
    
    /**
     * Produces a mirror images of the original image. The left half of the image 
     * is reflected over a vertical line through the middle of the original image.
     * 
     * @param img - 2D Array of integers from picture chosen.
     * @param width - Width of the image chosen.
     * @param height - Height of the image chosen.
     * @return - 2D Array of integers which produces the edited image i.e the mirror image.
     */
    public static int[][] mirror(int[][] img, int width, int height) {
        int[][] image = cloneArray(img);


            for (int i = 0; i < height; i++) {
                for (int j = width/2; j < width; j++) {
                    image[i][j] = image[i][(width/2)-(j-(width/2-1))];
                }
            }
            return image;


        }

    
/**
 * Produces a copy of the original image with more contrast
 * 
 * @param img - 2D Array of integers from picture chosen.
 * @param percent - Double value of contrast percentage entered by the user.
 * @param width - Width of the image chosen.
 * @param height - Height of the image chosen.
 * @return - 2D Array of integers which produce an image with more contrast.
 */
    public static int[][] contrast(int[][] img, int percent, int width, int height) {
        int[][] image = cloneArray(img);
        double decPercent = (double) percent/100;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if( image[i][j] < (1/2)*255) {
                    image[i][j] *= 1 - decPercent;
                }
                else {
                    image[i][j] *= 1 + decPercent;
                    if(image[i][j] > 255) {
                        image[i][j] = 255;
                    }
                }
            }
        }
        return image;


    }

    /**
     * Produces a copy of the original image which is blurred.
     * 
     * @param img - 2D Array of integers from picture chosen.
     * @param width - Width of the image chosen.
     * @param height - Height of the image chosen.
     * @return - 2D Array of integers that produce the edited image.
     */
    public static int[][] blur(int[][] img, int width, int height) {
        int[][] image = cloneArray(img);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if( i==0 || i == height-1 || j==0 || j==width-1) {
                    image[i][j] = 255;
                }
                else {
                    image[i][j] = (image[i+1][j] + image[i-1][j] + image[i+1][j+1] + image[i+1][j-1] + image[i][j+1] + image[i][j-1] + image[i-1][j+1] + image[i-1][j-1] + image[i][j])/9;
                }
            }
        }
        return image;


    }

    /**
     * Produces copy of the original image which is pixelated.
     * 
     * @param img - 2D Array of integers from picture chosen.
     * @param pixel - An odd integer of pixelating size entered by the user.
     * @param width - Width of the image chosen.
     * @param height - Height of the image chosen.
     * @return - 2D Array of integers which produces the new image i.e pixelated image.
     */
    public static int[][] pixelate(int[][] img, int pixel, int width, int height) {
        int[][] image = cloneArray(img);
        
        int width_border = width % pixel;
        int height_border = height % pixel;
        int row_squares = height / pixel;
        int width_squares = width / pixel;


        for (int i = 1; i <= row_squares; i++) {
            for (int j = 1; j <= width_squares; j++) {
                int center_row = i * pixel - ((pixel/2) + 1);
                int center_column = j * pixel - ((pixel/2) + 1);
                for(int a = i*pixel-pixel; a < i*pixel; a++) {
                    for(int b = j*pixel-pixel; b < j*pixel; b++) {
                        image[a][b] = image[center_row][center_column];
                    }
                }

            }
        }
        return image;


    }

    /**
     * Produces copy of the original image that is darkened.
     * 
     * @param img - 2D Array of integers from picture chosen.
     * @param width - Width of the image chosen.
     * @param height - Height of the image chosen.
     * @return - 2D Array of integers that produce the edited image.
     */
    public static int[][] darken (int[][] img, int width,int height){
    	int[][] image = cloneArray(img);
    	
    	for(int row =0; row< image.length; row++) {
    		for(int col = 0; col<image[0].length; col++) {
    			Color pixel = new Color(image[row][col]);
    			image[row][col] = pixel.darker().getRGB();
    			
    		}
    	}
    	return image;
    	
    }
    
    /**
     * Produces Array of integers which generate
     * a mirror image reflecting the top half of 
     * the original image.
     * 
     * @param img - 2D Array of integers from picture chosen.
     * @param width - Width of the image chosen.
     * @param height - Height of the image chosen.
     * @return - 2D Array of integers that produce the edited image.
     */
    public static int[][] mirror2(int[][] img, int width,int height){
    	int[][] image = cloneArray(img);
    	
    	for (int i = 0; i < width; i++) {
            for (int j = height/2; j < height; j++) {
                image[j][i] = image[(height/2)-(j-(height/2-1))][i];
            }
        }
        return image;
    }


}
