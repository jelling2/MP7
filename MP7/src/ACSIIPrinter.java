import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ACSIIPrinter {

	static BufferedImage image = null;
	static File f = null;
	static int width = 230;
	static int height = 219;
	static int res = 5;	


	
	public static void main(String args[]) throws IOException {

		
		try {
			f = new File("resources/caticon.png");
			image = new BufferedImage(width / res, height / res, BufferedImage.TYPE_INT_RGB);
			image = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println("Error: " + e);
	  }
		for (int i = 0; i < image.getHeight(); i += res) {
			System.out.println("");
			for (int j = 0; j < image.getWidth(); j += res) {
				
				/* int pixel = image.getRGB(j, i);
				int fifthMax = 0x00FFFFFF / 5;
					if (pixel < fifthMax) {System.out.print("  ");} 
					else if ((pixel > fifthMax) && (pixel < 2 * fifthMax)) { System.out.print(". ");}
					else if ((pixel > 2 * fifthMax) && (pixel < 3 * fifthMax)) {System.out.print(": ");}
					else if ((pixel > 3 * fifthMax) && (pixel < 4 * fifthMax)) {System.out.print("! ");}
					else {System.out.print("# ");} */
				
				//System.out.print(image.getRGB(j, i));
				if (Math.abs(image.getRGB(j, i)) < 0x00FFFFFF / 5) {
				System.out.print("  ");
				} else if ((Math.abs(image.getRGB(j, i)) < 2 * 0x00FFFFFF / 5) &&
				(Math.abs(image.getRGB(j, i)) > 0x00FFFFFF / 5)) {
					System.out.print("' ");
				} else {
					System.out.print("# ");
				}
			}
		}
	}
}


