import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ACSIIPrinter {

	static BufferedImage image = null;
	static File f = null;
	static int width = 300;
	static int height = 300;
	static int res = 2;	


	
	public static void main(String args[]) throws IOException {
		
		try {
			f = new File("resources/will-smith-2.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			image = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println("Error: " + e);
	  }
	
		
		for (int i = 0; i < image.getHeight(); i += res) {
			System.out.println("");
			for (int j = 0; j < image.getWidth(); j += res) {
				
				int pixel = (image.getRGB(j, i)) & 0xFFFFFF;
				int sixthMax = 0x00FFFFFF / 6;
					if (pixel < sixthMax) {System.out.print("% ");} 
					else if ((pixel > sixthMax) && (pixel < 2 * sixthMax)) { System.out.print("# ");}
					else if ((pixel > 2 * sixthMax) && (pixel < 3 * sixthMax)) {System.out.print("* ");}
					else if ((pixel > 3 * sixthMax) && (pixel < 4 * sixthMax)) {System.out.print(": ");}
					else if ((pixel > 4 * sixthMax) && (pixel < 5 * sixthMax)) {System.out.print(". ");}
					else {System.out.print("  ");} 
				
				//System.out.print(pixel + " ");
			}
		}
	}
}


