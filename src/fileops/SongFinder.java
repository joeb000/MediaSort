package fileops;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import shell.CallShellScript;
import fileobjects.AudioFile;

public class SongFinder {

	public static String TYPE_MP3="mp3";
	public static String TYPE_WAV="wav";
	public static String TYPE_M4A="m4a";
	public static String TYPE_FLAC="flac";

	public static String TYPE_JPEG="jpeg";
	public static String TYPE_JPG="jpg";

	public static String TYPE_IMG="";

	
	private ArrayList<AudioFile> fileList = new ArrayList<AudioFile>();
	private File targetDir = new File("/a/target/dir");

	public void findAllSongsInDirectory(File dir){
		
		if(dir.isDirectory()){
			File[] listOfFiles = dir.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				File fi = listOfFiles[i];
				if (fi.isFile()) {
					//System.out.println("File " + listOfFiles[i].getName());
					if(isSongFile(fi)){
						AudioFile afi = new AudioFile(fi);
						fileList.add(afi);
					}
				} else if (fi.isDirectory()) {
					System.out.println("Directory " + fi.getName());
					findAllSongsInDirectory(fi);
				}
			}

		}
		else {
			System.err.println(dir.getName() + " is not a directory");
		}
		
		//copyFilesToNewDir(targetDir);

	}


	private boolean isSongFile(File file){
		boolean isSong = false;
		String fn = file.getName().toLowerCase();

		if (fn.endsWith(TYPE_MP3)){
			System.out.println("MP3 file: "+ file.getName());
			isSong = true;
		}
		else if (fn.endsWith(TYPE_WAV)){
			System.out.println("WAV file: "+ file.getName());
			isSong = true;
		}
		else if (fn.endsWith(TYPE_FLAC)){
			System.out.println("FLAC file: "+ file.getName());
			isSong = true;
		}
		else if (fn.endsWith(TYPE_M4A)){
			System.out.println("M4A file: "+ file.getName());
			isSong = true;
		}
		else {
			System.err.println("Unknown File Type: "+ file.getName());
			isSong = false;
		}

		return isSong;
	}
	
	public void copyFilesToNewDir(File newDir){
		
		for (AudioFile f : fileList){
			try {
				parseMediaFile(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void parseMediaFile(AudioFile afile) throws IOException{
		BufferedReader rawInfo = CallShellScript.printMediaInfoToBR(afile.getAbsolutePath());
		String line;
		
		while ((line = rawInfo.readLine()) != null) {
			if (line.startsWith("Performer")){
				afile.setArtist(line.split(":",2)[1].trim());
			}
			if (line.startsWith("Recorded date")){
				afile.setYear(line.split(":",2)[1].trim());
			}
			if (line.startsWith("Track name  ")){
				afile.setSongName(line.split(":",2)[1].trim());
			}
			if (line.startsWith("Album  ")){
				afile.setAlbum(line.split(":",2)[1].trim());
			}
		}
		
		
	}
}