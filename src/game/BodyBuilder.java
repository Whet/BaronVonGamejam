package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import watoydoEngine.io.ReadWriter;

public class BodyBuilder {

	public static BufferedImage getBody(Player player) {
		
		BufferedImage image = new BufferedImage(95, 120, BufferedImage.TYPE_INT_ARGB);
		
		try {
			BufferedImage head = ImageIO.read(ReadWriter.getResourceAsInputStream(player.getHead()));
			BufferedImage body = ImageIO.read(ReadWriter.getResourceAsInputStream(player.getBody()));
			
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			
			graphics.drawImage(body, 25, 40, null);
			graphics.drawImage(head, 0, 0, null);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
}
