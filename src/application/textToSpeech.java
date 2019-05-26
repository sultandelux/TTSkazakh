package application;

import java.io.IOException;

import com.darkprograms.speech.synthesiser.SynthesiserV2;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import static application.NewJFrame.jTextArea1;


public class textToSpeech {
	
	//Create a Synthesizer instance
	SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	
	/**
	 * Constructor
	 */
	public textToSpeech() {
		
                String str = jTextArea1.getText();
                str = str.replaceAll("a", "a");
                str = str.replaceAll("ә", "ä");
                str = str.replaceAll("б", "b");
                str = str.replaceAll("в", "v");
                str = str.replaceAll("г", "g");
                str = str.replaceAll("ғ", "ğ");
                str = str.replaceAll("д", "d");
                str = str.replaceAll("е", "e");
                str = str.replaceAll("ё", "yo");
                str = str.replaceAll("ж", "j");
                str = str.replaceAll("з", "z");
                str = str.replaceAll("и", "ï");
            str = str.replaceAll("й", "y");
            str = str.replaceAll("к", "k");
            str = str.replaceAll("қ", "q");
            str = str.replaceAll("л", "ll");
            str = str.replaceAll("м", "m");
            str = str.replaceAll("н", "n");
            str = str.replaceAll("ң", "ñ");
            str = str.replaceAll("о", "o");
            str = str.replaceAll("ө", "ö");
            str = str.replaceAll("п", "p");
            str = str.replaceAll("р", "r");
            str = str.replaceAll("с", "s");
            str = str.replaceAll("т", "t");
            str = str.replaceAll("у", "w");
            str = str.replaceAll("ұ", "u");
            str = str.replaceAll("ү", "ü");
            str = str.replaceAll("ф", "f");
            str = str.replaceAll("х", "h");
            str = str.replaceAll("һ", "h");
            str = str.replaceAll("ц", "ts"); // important: must consider "ts" at beginning of word
            str = str.replaceAll("ч", "ç");
            str = str.replaceAll("ш", "ş");
            str = str.replaceAll("щ", "şş");
            str = str.replaceAll("ъ", "\'");
            str = str.replaceAll("ы", "ı");
            str = str.replaceAll("і", "i");
            str = str.replaceAll("ь", "\'");
            str = str.replaceAll("э", "é");
            str = str.replaceAll("ю", "yu");
            str = str.replaceAll("я", "ya");
                System.out.println("Text to speech: [" + jTextArea1.getText() + " " + str + "]\n");
		speak(str);
	}
	
	/**
	 * 
	 * @param text
	 */
	public void speak(String text) {
		System.out.println(text);
		
		//Create a new Thread because JLayer is running on the current Thread and will make the application to lag
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
		
		//We don't want the application to terminate before this Thread terminates
		thread.setDaemon(false);
		
		//Start the Thread
		thread.start();
		
	}
	
	public static void main(String[] args) {
		new textToSpeech();
	}
	
}
