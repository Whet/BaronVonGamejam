package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.designObjects.display.Crowd;
import watoydoEngine.designObjects.display.ImageSingle;
import watoydoEngine.designObjects.display.Text;
import watoydoEngine.hardPanes.HardPaneDefineable;
import watoydoEngine.io.ReadWriter;
import watoydoEngine.workings.displayActivity.ActivePane;

public abstract class GameChoiceMenu implements HardPaneDefineable {

	private static final int GOD_ICON_SPACING = 100;
	private static final int CHOICE_WIDTH_SPACING = 10;
	private static final int CHOICE_HEIGHT_SPACING = 60;
	private static final double CHOICE_SCREEN_PERCENT = 0.7;
	
	@Override
	public void load(Crowd crowd) throws FileNotFoundException, IOException {

		PlayerCollection playerCollection = PlayerCollection.getInstance();
		
		final ImageSingle backgroundImage = new ImageSingle(getBackgroundImage());
		
		final ImageSingle player1Image = new ImageSingle(getPlayerImage(playerCollection.getPlayer(0)));
		final ImageSingle player2Image = new ImageSingle(getPlayerImage(playerCollection.getPlayer(1)));
		final ImageSingle player3Image = new ImageSingle(getPlayerImage(playerCollection.getPlayer(2)));
		final ImageSingle player4Image = new ImageSingle(getPlayerImage(playerCollection.getPlayer(3)));
		final ImageSingle player5Image = new ImageSingle(getPlayerImage(playerCollection.getPlayer(4)));
		
		int screenWidth = ActivePane.getInstance().getWidth();
		int screenHeight = ActivePane.getInstance().getHeight();

		final Text titleText = new Text(screenWidth/2 - 200, 40, getScenarioName());

		titleText.setColour(Color.black);
		
		player1Image.setLocation(GOD_ICON_SPACING, GOD_ICON_SPACING * 2);
		player2Image.setLocation(screenWidth - player2Image.getImage().getWidth() - GOD_ICON_SPACING, GOD_ICON_SPACING * 2);
		player3Image.setLocation(GOD_ICON_SPACING, screenHeight - player3Image.getImage().getHeight() - GOD_ICON_SPACING);
		player4Image.setLocation(screenWidth - player4Image.getImage().getWidth() - GOD_ICON_SPACING, screenHeight - player4Image.getImage().getHeight() - GOD_ICON_SPACING);
		player5Image.setLocation(screenWidth/2 - player5Image.getImage().getWidth()/2, GOD_ICON_SPACING * 2);
		
		final ButtonSingle optionOne = getOptionOne();
		final ButtonSingle optionTwo = getOptionTwo();
		final ButtonSingle optionThree = getOptionThree();
		
		int screenMidX = screenWidth / 2;
		int buttonWidth = optionOne.getImage().getWidth();

		backgroundImage.setLocation(screenMidX - backgroundImage.getSize()[0] / 2, screenHeight/2 - backgroundImage.getSize()[1] / 2);
		
		optionOne.setLocation(screenMidX - buttonWidth - CHOICE_WIDTH_SPACING, screenHeight * CHOICE_SCREEN_PERCENT);
		optionTwo.setLocation(screenMidX + CHOICE_WIDTH_SPACING, screenHeight * CHOICE_SCREEN_PERCENT);
		optionThree.setLocation(screenMidX - buttonWidth/2 , screenHeight * CHOICE_SCREEN_PERCENT + CHOICE_HEIGHT_SPACING);
		
		int startAlpha = 0;

		backgroundImage.setAlpha(startAlpha);
		
		player1Image.setAlpha(startAlpha);
		player2Image.setAlpha(startAlpha);
		player3Image.setAlpha(startAlpha);
		player4Image.setAlpha(startAlpha);
//		player5Image.setAlpha(startAlpha);
		
		optionOne.setAlpha(startAlpha);
		optionTwo.setAlpha(startAlpha);
		optionThree.setAlpha(startAlpha);
		
		titleText.setAlpha(startAlpha);
		
		crowd.addDisplayItem(backgroundImage);
		
		crowd.addDisplayItem(player1Image);
		crowd.addDisplayItem(player2Image);
		crowd.addDisplayItem(player3Image);
		crowd.addDisplayItem(player4Image);
		crowd.addDisplayItem(player5Image);
		
		crowd.addButton(optionOne);
		crowd.addButton(optionTwo);
		crowd.addButton(optionThree);
		
		crowd.addDisplayItem(titleText);
		
		final Timer animationTimer = new Timer();
		
		animationTimer.scheduleAtFixedRate(new TimerTask() {
			
			private int milliseconds = 0;
			
			private float god1Alpha = 0;
			private float god2Alpha = 0;
			private float god3Alpha = 0;
			private float god4Alpha = 0;
			private float god5Alpha = 0;
			
			private float option1Alpha = 0;
			private float option2Alpha = 0;
			private float option3Alpha = 0;
			
			private float titleAlpha = 0;
			
			@Override
			public void run() {
				milliseconds++;
				computeAnimation();
				
				titleText.setAlpha(titleAlpha);
				
				backgroundImage.setAlpha(titleAlpha);
				
				player1Image.setAlpha(god1Alpha);
				player2Image.setAlpha(god2Alpha);
				player3Image.setAlpha(god3Alpha);
				player4Image.setAlpha(god4Alpha);
				player5Image.setAlpha(god5Alpha);
				
				optionOne.setAlpha(option1Alpha);
				optionTwo.setAlpha(option2Alpha);
				optionThree.setAlpha(option3Alpha);
			}

			private final float fadeInRate = 0.001f;
			
			private void computeAnimation() {
				if(milliseconds > 1000) {
					if(titleAlpha < 1)
						titleAlpha +=fadeInRate;
					if(titleAlpha > 1)
						titleAlpha = 1;
				}
				if(milliseconds > 3000) {
					if(god1Alpha < 1)
						god1Alpha +=fadeInRate;
					if(god1Alpha > 1)
						god1Alpha = 1;
				}
				if(milliseconds > 3500) {
					if(god2Alpha < 1)
						god2Alpha +=fadeInRate;
					if(god2Alpha > 1)
						god2Alpha = 1;
				}
				if(milliseconds > 4000) {
					if(god3Alpha < 1)
						god3Alpha +=fadeInRate;
					if(god3Alpha > 1)
						god3Alpha = 1;
				}
				if(milliseconds > 4500) {
					if(god4Alpha < 1)
						god4Alpha +=fadeInRate;
					if(god4Alpha > 1)
						god4Alpha = 1;
				}
				if(milliseconds > 5000) {
					if(god5Alpha < 1)
						god5Alpha +=fadeInRate;
					if(god5Alpha > 1)
						god5Alpha = 1;
				}
				if(milliseconds > 5200) {
					if(option1Alpha < 1)
						option1Alpha +=fadeInRate;
					if(option1Alpha > 1)
						option1Alpha = 1;
				}
				if(milliseconds > 5400) {
					if(option2Alpha < 1)
						option2Alpha +=fadeInRate;
					if(option2Alpha > 1)
						option2Alpha = 1;
				}
				if(milliseconds > 5600) {
					if(option3Alpha < 1)
						option3Alpha +=fadeInRate;
					if(option3Alpha > 1)
						option3Alpha = 1;
				}
				
				if(option3Alpha >= 1)
					animationTimer.cancel();
			}
			
		}, 0, 1);
	}
	
	protected abstract BufferedImage getBackgroundImage();

	protected abstract String getScenarioName();
	
	private BufferedImage getPlayerImage(Player player) {
		try {
			return ImageIO.read(ReadWriter.getResourceAsInputStream("buttonPlaceholder.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract ButtonSingle getOptionOne() throws FileNotFoundException, IOException;
	
	public abstract ButtonSingle getOptionTwo() throws FileNotFoundException, IOException;
	
	public abstract ButtonSingle getOptionThree() throws FileNotFoundException, IOException;
	
	public abstract ButtonSingle getOptionFour() throws FileNotFoundException, IOException;

}
