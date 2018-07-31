
package suggestor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Demonstration{

        public static void main(String[] args) throws Exception{

		SwingUtilities.invokeAndWait(new Runnable(){

			@Override

			public void run() {

				List<String> myWords = new ArrayList<String>();

				myWords.add("melrose");
				myWords.add("mellyace");
				myWords.add("mellysexy");
				myWords.add("merovingian");
				myWords.add("esorlem");
				myWords.add("mellychristmas");
                                myWords.add("spanish bread");
				myWords.add("spanish laptop");
                                myWords.add("my lord is my saviour");
                                myWords.add("octopussy");
				myWords.add("autosuggest");
                                myWords.add("apple");
                                

				StringSearchable searchable = new StringSearchable(myWords);

				AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);

				JFrame frame = new JFrame();

				frame.add(combo);

				frame.pack();

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setVisible(true);

			}

		});

        }

}
