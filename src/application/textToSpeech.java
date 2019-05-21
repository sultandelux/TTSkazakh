package application;

import java.io.IOException;

import com.darkprograms.speech.synthesiser.SynthesiserV2;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import static application.NewJFrame.jTextArea1;

/**
 * 
 * @author https://github.com/Newrichman
 *
 */
public class textToSpeech {
	//Create a Synthesizer instance
	SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	/**
	 * Constructor
	 */
	public textToSpeech() {
		
		//speak
                String str = jTextArea1.getText();
                str = str.replaceAll("к", "k");
                str = str.replaceAll("ж", "zh");
                str = str.replaceAll("т", "tj");
                str = str.replaceAll("в", "v");
                str = str.replaceAll("г", "g");
                str = str.replaceAll("д", "d");
                str = str.replaceAll("л", "l");
                str = str.replaceAll("м", "m");
                str = str.replaceAll("н", "n");
                str = str.replaceAll("п", "p");
                str = str.replaceAll("р", "r");
                str = str.replaceAll("с", "s");
                str = str.replaceAll("ф", "f");
                str = str.replaceAll("х", "h");
                str = str.replaceAll("һ", "h");
                str = str.replaceAll("з", "z");
                str = str.replaceAll("ц", "c");
                str = str.replaceAll("ч", "ch");
                str = str.replaceAll("ш", "sh");
                str = str.replaceAll("щ", "sch");
                str = str.replaceAll("й", "j");
                str = str.replaceAll("қ", "qh");
                str = str.replaceAll("ғ", "gh");
                str = str.replaceAll("ң", "ng");
                
                str = str.replaceAll("ө", "uoe");
                str = str.replaceAll("е", "je");
                str = str.replaceAll("у", "uu");
                str = str.replaceAll("ы", "y");
                str = str.replaceAll("и", "yi");
                str = str.replaceAll("ү", "u");
                str = str.replaceAll("ұ", "uy");
                str = str.replaceAll("ю", "ju");
                str = str.replaceAll("о", "o");
                str = str.replaceAll("э", "e");
                str = str.replaceAll("е", "je");
                str = str.replaceAll("ё", "jo");
                str = str.replaceAll("і", "ji");
                str = str.replaceAll("а", "a");
                
                System.out.println("Text to speech: [" + jTextArea1.getText() + " " + str + "]\n");
		speak(str);
	}
	
	/**
	 * 
	 * @param text
	 */
	public void speak(String text) {
		System.out.println(text);
		
		Thread thread = new Thread(() -> {
			try {
				
				//Create a JLayer instance
				AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(text));
				player.play();
				
				System.out.println("Successfully got back synthesizer data");
				
			} catch (IOException | JavaLayerException e) {
				
				e.printStackTrace(); //Print the exception ( we want to know , not hide below our finger , like many developers do...)
				
			}
		});
		
		thread.setDaemon(false);
		
		//Start the Thread
		thread.start();
		
	}
	
	public static void main(String[] args) {
		new textToSpeech();
	}
	
}
