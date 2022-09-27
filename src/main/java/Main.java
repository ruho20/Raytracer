import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) {

		// define image height and width.
		final double aspectRatio = 16.0 / 9.0;
		final int imageWidth = 400;
		final int imageHeight = (int)(imageWidth / aspectRatio);

		JFrame frame = new JFrame("Raytracer"); // Create new JFrame object.
		Canvas canvas = new Canvas(); // Create canvas object to draw image in.

		// frame setup + add the canvas to it.
		frame.add(canvas);
		frame.setSize(imageWidth, imageHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		// Camera
		double viewportHeight = 2.0;
		double viewportWidth = aspectRatio * viewportHeight;
		double focalLength = 1.0;

		Point3 origin = new Point3(0,0,0);
		Vec3 horizontal = new Vec3(viewportWidth, 0, 0);
		Vec3 vertical = new Vec3(0, viewportHeight, 0);
		Vec3 lowerLeftCorner = origin.Substract(horizontal.DivideByScalar(2)).Substract(vertical.DivideByScalar(2).Substract(new Vec3(0, 0, focalLength)));

		/*
		 * NOTE TO SELF
		 * The BufferStrategy class represents the mechanism with which to organize complex memory
		 * on a particular Canvas or window.
		*/

		// General double-buffering strategy.
		canvas.createBufferStrategy(2);

		// Create Graphics context for the drawing buffer.
		Graphics graphics = canvas.getBufferStrategy().getDrawGraphics();
		BufferedImage buffer = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

		for (int j = imageHeight - 1; j >= 0; --j) {
			for (int i = 0; i < imageWidth; ++i) {
				double u = (double)i / (imageWidth - 1);
				double v = (double)j / (imageHeight - 1);

				Ray r = new Ray(origin, lowerLeftCorner.Add(horizontal.MultiplyByScalar(u)).Add(vertical.MultiplyByScalar(v).Substract(origin)));

				Color color1 = new Color();
				Color pixelColor = color1.rayColor(r);

				/*
				 * Parameter description
				 * x: The X coordinate of the pixel to set.
				 * y: The y coordinate of the pixel to set.
				 * rgb: The rgb value
				*/
				buffer.setRGB(i, imageHeight - j - 1, pixelColor.writeColor());
			}

			graphics.drawImage(buffer, 0, 0, frame.getWidth(), frame.getHeight(), null);
			canvas.getBufferStrategy().show();
		}
	}
}
