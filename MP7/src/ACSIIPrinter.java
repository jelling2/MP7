import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ACSIIPrinter {

	static BufferedImage image = null;
	static File f = null;
	static int width = 230;
	static int height = 219;
	static int total = 0;
	static int average = 0;
	public static int[][] charImage = new int[1000][1000];

	
	public static void main(String args[]) throws IOException {

		
		try {
			f = new File("resources/appleicon.png");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			image = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println("Error: " + e);
	  }
		for (int i = 0; i < image.getHeight(); i++) {
			System.out.println("");
			for (int j = 0; j < image.getWidth(); j++) {
				if (image.getRGB(j, i) < -1) {
				System.out.print("0 ");
				} else {
					System.out.print("1 ");
				}
			}
		}
	}
		public static int[][] pixelArray (BufferedImage image) {
			for (int i = 0; i < image.getHeight(); i += image.getHeight() / 5) {
				for (int j = 0; j < image.getWidth(); j += image.getWidth() / 5) {
				
						total = total + image.getRGB(i, j);
						average = total / 25;
			for (int m = 0; m < charImage.length; m++) {
				for (int n = 0; n < charImage[0].length; n++) {
					charImage[m][n] = average;
					}
				}
			}
		} return charImage;
	}
}


