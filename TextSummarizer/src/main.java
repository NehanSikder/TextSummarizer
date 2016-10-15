import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sf.classifier4J.summariser.SimpleSummariser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleSentencesExtractor;


public class main {
	
	public static void main(String[] args){
		createDisplay();
		//System.out.println(getTitle("http://www.cnn.com/2016/04/10/politics/hillary-clinton-jake-tapper-contested-convention/index.html"));
		//System.out.println(getSummary("http://www.cnn.com/2016/04/10/politics/hillary-clinton-jake-tapper-contested-convention/index.html"));
	}
	
	private static void createDisplay() {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		//Variables
		JPanel panel = new JPanel();
		final JTextField input = new JTextField("Enter URL and select submit");
		final JEditorPane output = new JEditorPane("text/html", "");
		//output.setLineWrap(true);
		//output.setWrapStyleWord(true);
		JButton submit = new JButton("Submit");
		panel.setLayout(new BorderLayout());
		
		//Add actionlistener
		submit.addActionListener(new ActionListener(){
			String content = "";
			public void actionPerformed(ActionEvent e) {
				String currentContent = "";
				//System.out.println(output.getText());
				//content = "";
				String url = input.getText();
				String title = getTitle(url);
				//output.append(title);
				//output.append("\n");
				String summary = getSummary(url);
				//output.append(summary);
				//output.append("\n");
				currentContent+= "<b>" + title + "</b>";
				currentContent += "<br>";
				currentContent += summary;
				currentContent += "<br>";
				
				content += currentContent;
				output.setText(content);
			}
		});
		
		//Get title
		
		
		//Make submit bigger
		
		//Make input bigger
		
		
		//Add everything to the panel
		panel.add(input, BorderLayout.NORTH);
		panel.add(output, BorderLayout.CENTER);
		panel.add(submit, BorderLayout.SOUTH);
		
		
		frame.add(panel);
		frame.setVisible(true);
	}

	public static String getSummary (String html) {
		//Declare and initialize variable
		URL url = null;
		String text = "";
		SimpleSummariser x;
		String result;
		
		try {
			//store the link in an url object
			url = new URL(html);
		} catch (MalformedURLException e) {
			//notify and exit if the url is invalid
			System.out.println("Enter a valid URL");
			System.exit(0);
		}
		try {
			//store the body text of the html page into a String object
			text = ArticleSentencesExtractor.INSTANCE.getText(url);
		} catch (BoilerpipeProcessingException e) {
			//notify if unable to extract the content of the page
			System.out.println("Unable to connect to the article");
			System.exit(0);
		} 
		//summarize the extracted content and return it
		x = new SimpleSummariser();
		result = x.summarise(text, 5);
		return result;
		
		
	}
	
	public static String getTitle(String html){
		//declare and initialize variable
		Document doc = null;
		//connect to 
		try {
			//Store the html in the doc object
			doc = Jsoup.connect(html).get();
		} catch (IOException e) {
			//notify and exit if invalid html
			System.out.println("Unable to connect to the article");
			System.exit(0);
		}
			//return a title of the of html page
		return doc.title();
	}

	
	}


