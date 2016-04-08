import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.xerces.util.URI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import net.sf.classifier4J.summariser.SimpleSummariser;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.ArticleSentencesExtractor;
import de.l3s.boilerpipe.extractors.DefaultExtractor;


public class main {
	
	String input = "";
	JButton btn;
	JTextField output;
	
	public class GUI extends JFrame implements ActionListener{
		
		public GUI(){
			JFrame frame = new JFrame();
			frame.setTitle("Summarizer");
			frame.setSize(400,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			//panel.setLayout(new GridLayout(2,1));
			btn = new JButton("Enter");
			JTextField url = new JTextField("Enter Url",30);
			output = new JTextField(30);

			
			
			//Add components to panel
			panel.add(url);
			panel.add(btn);
			panel.add(output);
			
			//get string from url textfield
		
			btn.addActionListener(this);
			
			//Call get summary method with input url
			
			
			//display summary
			
			
			
			frame.add(panel);
			frame.setVisible(true);
			
			
		}
		
		
		
		public void actionPerformed(ActionEvent e) {
			input = btn.getText();
			output.setText(input);
		}
		
		
	}

	public static void main(String[] args){
		GUI x = new GUI();

	}
	
	public String getSummary (String html) throws IOException, BoilerpipeProcessingException{
		URL url = new URL(html);
		String urlS = url.toString();
		String text = ArticleSentencesExtractor.INSTANCE.getText(url);
		
		Document doc = Jsoup.connect(urlS).get();
        String title = doc.title();
        
		SimpleSummariser x = new SimpleSummariser();
		String result = x.summarise(text, 5);
		return result;
	}

	
	}


