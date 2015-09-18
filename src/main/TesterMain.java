package main;

import java.io.File;
import java.io.IOException;

import shell.CallShellScript;
import fileops.SongFinder;

public class TesterMain {

	public static void main(String[] args) throws IOException {

		testSongFinder();
	}
	
	public static void testSongFinder(){
		File dir = new File("/media/joe/Tunes/mac_music");
		SongFinder sf = new SongFinder();
		sf.findAllSongsInDirectory(dir);
	}

	public void testCallShellScript() throws IOException{
		CallShellScript css = new CallShellScript();
		System.out.println(css.printMediaInfo());
	}
}
