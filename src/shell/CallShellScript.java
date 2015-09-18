package shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CallShellScript {
	
	public String printMediaInfo() throws IOException{
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "/home/joe/myScripts/mediaScript.sh","/media/joe/Tunes/mac_music/The Head and the Heart/The Head and the Heart/Ghosts.flac");
		final Process process = pb.start();

		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		StringBuilder aline = new StringBuilder();


		while ((line = br.readLine()) != null) {
			//System.out.println(line); 
			aline.append(line);
			aline.append("\n");

		}
		System.out.println("Program terminated!");

		return aline.toString();
	}
	
	public static String printMediaInfo(String filename) throws IOException{
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "/home/joe/myScripts/mediaScript.sh",filename);
		final Process process = pb.start();

		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		StringBuilder aline = new StringBuilder();


		while ((line = br.readLine()) != null) {
			//System.out.println(line); 
			aline.append(line);
			aline.append("\n");

		}
		return aline.toString();
	}
	
	public static BufferedReader printMediaInfoToBR(String filename) throws IOException{
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "/home/joe/myScripts/mediaScript.sh",filename);
		final Process process = pb.start();

		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		return br;
	}
}