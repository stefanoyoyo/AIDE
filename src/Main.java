import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Main
{
	static String cornice = "--------------------";
	static String intro = "Questa app a console permette\n di rinominare facilmente un gruppo\n di file. Immetti il nome di uno di essi:\n se esso conterra un numero minore di quelli contenuti\n negli altri file, essi saranno enumerati";
	static String keep = "Vuoi continuare? (si)";
	static String path = "Inserisci il path dei file da rinomimare: ";
	static String inFileName = "Inserisci il nome del file: ";
	
	public static void main(String[] args)
	{
		System.out.println(cornice + "\n" + intro + "\n" + cornice + "\n\n" + keep);
		if (risposta().equals("si")){
			start();
		}

	}
	
	static String risposta(){
		return new Scanner(System.in).nextLine();
	}
	
	static void start(){
		System.out.print(path);
		String path = risposta();
		System.out.print(inFileName);
		String fileName = risposta();
		boolean success = renameFiles(path, fileName);
	}
	
	static boolean renameFiles(String path, String fileName) {
		File [] listaFile = new File(path).listFiles();
		for (File file : listaFile){
			String imageName = file.getName();
			String[] numberFromPicName = getNumberFromPicName(imageName);
		}
		
		return true;
	}
	
	static String[] getNumberFromPicName(String imageName){
		ArrayList<String> l = new ArrayList<String>();
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(imageName);
		while (m.find()) {
			l.add(m.group());
		}
		
		return l.toArray(new String[l.size()]);
	}
	
	
}
