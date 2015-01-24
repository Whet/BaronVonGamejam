package game.maps;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.io.ReadWriter;
import game.CardViewer;
import game.GameMenu;
import game.PlayerCollection;
import game.TurnProcess;

public class Wood extends GameMenu {

	private CardViewer cardViewer;
	private ChoiceButton optionOne;
	private ChoiceButton optionTwo;
	private ChoiceButton optionThree;
	
	private TurnProcess turnProcess;

	public Wood() {
		
		this.turnProcess = new TurnProcess();
		
		try{
			optionOne = new ChoiceButton("ADVENTURE", turnProcess, ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png")));
			optionTwo = new ChoiceButton("REST", turnProcess, ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png")));
			optionThree = new ChoiceButton("TRAVEL", turnProcess, ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png")));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		this.cardViewer = new CardViewer(optionOne, optionTwo, optionThree);
		
		optionOne.setCardViewer(cardViewer);
		optionTwo.setCardViewer(cardViewer);
		optionThree.setCardViewer(cardViewer);
	}
	
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
	public ButtonSingle getOptionOne() throws FileNotFoundException, IOException {
		return optionOne;
	}

	@Override
	public ButtonSingle getOptionTwo() throws FileNotFoundException, IOException {
		return optionTwo;
	}

	@Override
	public ButtonSingle getOptionThree() throws FileNotFoundException, IOException {
		return optionThree;
	}

	@Override
	protected CardViewer getCardViewer() {
		return this.cardViewer;
	}

}
