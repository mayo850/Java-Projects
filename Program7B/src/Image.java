import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

class Image {
	protected int width, height;
	// 'samples' stores the image pixel values.
	protected int[][] samples;

	// Constructor: Reads the image from the
	// specified file name.
	public Image(String filename) throws Exception {
		read(filename);
	}

	// Returns the pixel width of the image.
	public int getWidth() {
		return width;
	}

	// Returns the pixel height of the image.
	public int getHeight() {
		return height;
	}
	
	// Returns the 2D array of the image
	public int[][] get2DArray(){
		return samples;
	}
	
	// Sets the 2D array of the image to the parameter
	public void set2DArray(int[][] imageArray){
		samples = imageArray; 
	}
	// Reads the image from the specified file
	// name into the 'samples' array. Throws an
	// exception if the image is stored in an
	// unsupported file format (currently only
	// .GIF, .JPG, and .PNG are supported by Sun).
	public void read(String filename) throws Exception {
		// Extract the file name suffix.
		String ext = filename.substring(filename.indexOf('.') + 1);
		// Create a file object for the file name.
		File fileImage = new File(filename);
		// Get a list of ImageReaders that claim
		// to be able to decode this image file
		// based on the file name suffix.
		Iterator imageReaders = ImageIO.getImageReadersBySuffix(ext);
		ImageReader imageReader;
		// Grab the first ImageReader in the list.
		if (imageReaders.hasNext())
			imageReader = (ImageReader) imageReaders.next();
		// If we get here we cannot decode the image.
		else
			throw new IIOException("Unsupported image format");
		// Create a file input stream object to
		// read the image date.
		FileImageInputStream imageInputStream = new FileImageInputStream(
				fileImage);
		// Tell the ImageReader object to read data
		// from our file input stream object.
		imageReader.setInput(imageInputStream);
		// Get the width and height of the image.
		width = imageReader.getWidth(0);
		height = imageReader.getHeight(0);
		// Read the image from the file input stream,
		// and close the input stream when done.
		BufferedImage bufImage = imageReader.read(0);
		imageInputStream.close();
		// Get a raster object so we can extract the
		// pixel data from the BufferedImage.
		WritableRaster wRaster = bufImage.getRaster();
		// Create our 'samples' 2d-array.
		samples = new int[height][width];
		// Extract the image data into our 'samples'
		// array.
		for (int row = 0; row < height; row++)
			for (int col = 0; col < width; col++)
				samples[row][col] = wRaster.getSample(col, row, 0);
	}

	// Write the image stored in the 'samples'
	// array to the specified file. The file name
	// suffix should be a supported image file
	// format (currently either .JPG or .PNG).
	public void write(String filename) throws Exception {
		// Extract the file name suffix.
		String ext = filename.substring(filename.indexOf('.') + 1);
		// Create a file object for the file name.
		File fileImage = new File(filename);
		// Get a list of ImageWriters that claim to
		// be able to encode images in the specified
		// image file format based on the file name
		// suffix.
		Iterator imageWriters = ImageIO.getImageWritersBySuffix(ext);
		ImageWriter imageWriter;
		// Grab the first ImageWriter in the list.
		if (imageWriters.hasNext())
			imageWriter = (ImageWriter) imageWriters.next();
		// If we get here we cannot encode the image.
		else
			throw new IIOException("Unsupported image format");
		// Create a file output stream object to
		// write the image data.
		FileImageOutputStream imageOutputStream = new FileImageOutputStream(
				fileImage);
		// Tell the ImageWriter to use our file
		// output stream object.
		imageWriter.setOutput(imageOutputStream);
		// The ImageWriter.write() method expects a
		// BufferedImage. Convert our 'samples' array
		// into a BufferedImage.
		BufferedImage bufImage = createBufferedImage();
		// Encode the image to the output file.
		imageWriter.write(bufImage);
		imageOutputStream.close();
	}

	// Draws the image stored in the 'samples'
	// array on the specified graphics context.
	public void draw(Graphics gc, int x, int y) {
		BufferedImage bufImage = createBufferedImage();
		gc.drawImage(bufImage, x, y, null);
	}

	// Converts the 'samples' array into a
	// BufferedImage object. Students do not have
	// to understand how this works.
	private BufferedImage createBufferedImage() {
		// Create a monochrome BufferedImage object.
		BufferedImage bufImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_GRAY);
		// Create a WriteableRaster object so we can
		// put sample data into the BufferedImage
		// object's raster.
		WritableRaster wRaster = bufImage.getRaster();
		// Copy the 'samples' data into the
		// BufferedImage object's raster.
		for (int row = 0; row < height; row++)
			for (int col = 0; col < width; col++)
				wRaster.setSample(col, row, 0, samples[row][col]);
		// Return the newly created BufferedImage.
		return bufImage;
	}
} // End of Class Image
