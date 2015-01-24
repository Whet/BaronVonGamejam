package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
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

public abstract class GameMenu implements HardPaneDefineable {

	private static final int PLAYER_ICON_SPACING = 100;
	private static final int CHOICE_WIDTH_SPACING = 10;
	private static final int CHOICE_HEIGHT_SPACING = 60;
	private static final double CHOICE_SCREEN_PERCENT = 0.7;
	private static final int STAT_PLACING = 68;
	
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
		
		player1Image.setLocation(PLAYER_ICON_SPACING, PLAYER_ICON_SPACING * 2);
		player2Image.setLocation(screenWidth - player2Image.getImage().getWidth() - PLAYER_ICON_SPACING, PLAYER_ICON_SPACING * 2);
		player3Image.setLocation(PLAYER_ICON_SPACING, screenHeight - player3Image.getImage().getHeight() - PLAYER_ICON_SPACING);
		player4Image.setLocation(screenWidth - player4Image.getImage().getWidth() - PLAYER_ICON_SPACING, screenHeight - player4Image.getImage().getHeight() - PLAYER_ICON_SPACING);
		player5Image.setLocation(screenWidth/2 - player5Image.getImage().getWidth()/2, PLAYER_ICON_SPACING * 2);
		
		final StatsUi statsPlayer1 = new StatsUi();
		final StatsUi statsPlayer2 = new StatsUi();
		final StatsUi statsPlayer3 = new StatsUi();
		final StatsUi statsPlayer4 = new StatsUi();
		final StatsUi statsPlayer5 = new StatsUi();
		
		statsPlayer1.setLocation(PLAYER_ICON_SPACING, PLAYER_ICON_SPACING * 2 - STAT_PLACING);
		statsPlayer2.setLocation(screenWidth - player2Image.getImage().getWidth() - PLAYER_ICON_SPACING, PLAYER_ICON_SPACING * 2 - STAT_PLACING);
		statsPlayer3.setLocation(PLAYER_ICON_SPACING, screenHeight - player3Image.getImage().getHeight() - PLAYER_ICON_SPACING - STAT_PLACING);
		statsPlayer4.setLocation(screenWidth - player4Image.getImage().getWidth() - PLAYER_ICON_SPACING, screenHeight - player4Image.getImage().getHeight() - PLAYER_ICON_SPACING - STAT_PLACING);
		statsPlayer5.setLocation(screenWidth/2 - player5Image.getImage().getWidth()/2, PLAYER_ICON_SPACING * 2 - STAT_PLACING);
		
		statsPlayer1.setPlayer(playerCollection.getPlayer(0));
		statsPlayer2.setPlayer(playerCollection.getPlayer(1));
		statsPlayer3.setPlayer(playerCollection.getPlayer(2));
		statsPlayer4.setPlayer(playerCollection.getPlayer(3));
		statsPlayer5.setPlayer(playerCollection.getPlayer(4));
		
		final ButtonSingle optionOne = getOptionOne();
		final ButtonSingle optionTwo = getOptionTwo();
		final ButtonSingle optionThree = getOptionThree();

		CardViewer cardViewer = getCardViewer();
		
		int screenMidX = screenWidth / 2;
		int buttonWidth = optionOne.getImage().getWidth();

		backgroundImage.setLocation(screenMidX - backgroundImage.getSize()[0] / 2, screenHeight/2 - backgroundImage.getSize()[1] / 2);
		
		optionOne.setLocation(screenMidX - buttonWidth - CHOICE_WIDTH_SPACING, screenHeight * CHOICE_SCREEN_PERCENT);
		optionTwo.setLocation(screenMidX + CHOICE_WIDTH_SPACING, screenHeight * CHOICE_SCREEN_PERCENT);
		optionThree.setLocation(screenMidX - buttonWidth/2 , screenHeight * CHOICE_SCREEN_PERCENT + CHOICE_HEIGHT_SPACING);
		
		int startAlpha = 1;

		backgroundImage.setAlpha(startAlpha);
		
		player1Image.setAlpha(startAlpha);
		player2Image.setAlpha(startAlpha);
		player3Image.setAlpha(startAlpha);
		player4Image.setAlpha(startAlpha);
		player5Image.setAlpha(startAlpha);
		
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
		
		crowd.addDisplayItem(statsPlayer1);
		crowd.addDisplayItem(statsPlayer2);
		crowd.addDisplayItem(statsPlayer3);
		crowd.addDisplayItem(statsPlayer4);
		crowd.addDisplayItem(statsPlayer5);
		
		crowd.addButton(optionOne);
		crowd.addButton(optionTwo);
		crowd.addButton(optionThree);
		
		crowd.addDisplayItem(titleText);
		
		crowd.addDisplayItem(cardViewer);
		crowd.addMouseActionItem(cardViewer);
		
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
				
				if(optionThree.getAlpha() == 1) {
					animationTimer.cancel();
					return;
				}
				
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
	
	protected abstract CardViewer getCardViewer();

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

	public static class ChoiceButton extends ButtonSingle {
		
		private Text text;
		private TurnProcess turnProcess;
		private CardViewer cardViewer;
		
		public ChoiceButton(String text, TurnProcess turnProcess, BufferedImage image) {
			super(image);
			this.turnProcess = turnProcess;
			this.text = new Text(this.getLocation()[0] + 5, this.getLocation()[1] + this.getSize()[1] - 10, text);
			this.text.setColour(Color.black);
		}
		
		@Override
		public void drawMethod(Graphics2D drawShape) {
			super.drawMethod(drawShape);
			text.setAlpha(this.getAlpha());
			text.drawMethod(drawShape);
		}
		
		@Override
		public boolean mU(Point mousePosition, MouseEvent e) {
			cardViewer.displayCard(turnProcess.getCard());
			return true;
		}
		
		@Override
		public void setLocation(double x, double y) {
			super.setLocation(x, y);
			if(text != null)
				this.text.setLocation(x + 5, y + this.getSize()[1] - 10);
		}

		public void setCardViewer(CardViewer cardViewer) {
			this.cardViewer = cardViewer;
		}
		
	}
	
}
