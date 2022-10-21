import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class MainClass {

	public static void main(String[] args) {
		try {
			new MainClass().sentenceDetect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sentenceDetect() throws InvalidFormatException, IOException {
		try {
			InputStream modelIn = new FileInputStream("en-token.bin");
			TokenizerModel model = new TokenizerModel(modelIn);
			TokenizerME tokenizer = new TokenizerME(model);
			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("Please enter your command: Type exit to stop");
				String inputStr = sc.nextLine();
				if (inputStr.equalsIgnoreCase("exit")) {
					sc.close();
					return;
				}
				String tokens[] = tokenizer.tokenize(inputStr.toLowerCase());

				InputStream posModelIn = new FileInputStream("en-pos-maxent.bin");
				POSModel posModel = new POSModel(posModelIn);
				POSTaggerME posTagger = new POSTaggerME(posModel);
				String tags[] = posTagger.tag(tokens);

				InputStream dictLemmatizer = new FileInputStream("en-lemmatizer.dict");
				DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);

				String[] lemmas = lemmatizer.lemmatize(tokens, tags);

				new ExecuteCommands().decideAction(Arrays.asList(lemmas));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}