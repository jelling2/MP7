import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



public class ACSIIPrinter {

	static BufferedImage image = null;
	static File f = null;
	static int width = 300;
	static int height = 300;
	static int res = 0;	


	
	public static void main(String args[]) throws IOException {
        Scanner lineScanner = new Scanner(System.in);

        System.out.println("Please select an image between 1 and 5:");

        String nextLine = lineScanner.nextLine();
        Scanner inputScanner = new Scanner(nextLine);
        int picInput = 0;
        picInput = inputScanner.nextInt();
        
        System.out.println("Please select a resolution:");
        nextLine = lineScanner.nextLine();
        inputScanner = new Scanner(nextLine);

        res = inputScanner.nextInt();
        inputScanner.close();
        lineScanner.close();
        
        int picNumber = picInput;
        String fileName = "";
        switch (picNumber) {
        		case 1: fileName = "resources/appleicon.png";
        			break;
        		case 2: fileName = "resources/starmp7.png";
        			break;
        		case 3: fileName = "resources/columni.jpg";
        			break;
        		case 4: fileName = "resources/cs125-460x460.png";
        			break;
        		case 5: fileName = "resources/will-smith-2.jpg";
        			break;
        		
        }
        
        
        for(int clear = 0; clear < 1000; clear++) { //clears the console
            System.out.print("\b") ;
        }        
        
		try {
			f = new File(fileName);
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


