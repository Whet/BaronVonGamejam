package game.maps;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.io.ReadWriter;
import game.GameChoiceMenu;

public class Wood extends GameChoiceMenu {

	@Override
	protected BufferedImage getBackgroundImage() {
		try {
			return ImageIO.read(ReadWriter.getResourceAsInputStream("backgroundPlaceholder.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected String getScenarioName() {
		return "I've got Woods";
	}

	@Override
	public ButtonSingle getOptionOne() throws FileNotFoundException,
			IOException {
		return new ButtonSingle(ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png"))) {
		};
	}

	@Override
	public ButtonSingle getOptionTwo() throws FileNotFoundException,
			IOException {
		return new ButtonSingle(ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png"))) {
		};
	}

	@Override
	public ButtonSingle getOptionThree() throws FileNotFoundException,
			IOException {
		return new ButtonSingle(ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png"))) {
		};
	}

	@Override
	public ButtonSingle getOptionFour() throws FileNotFoundException,
			IOException {
		return new ButtonSingle(ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png"))) {
		};
	}

}
