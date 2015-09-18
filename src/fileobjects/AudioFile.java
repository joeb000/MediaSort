package fileobjects;

import java.io.File;

public class AudioFile extends File{

	public AudioFile(String pathname) {
		super(pathname);
		
	}
	
	public AudioFile(File file) {
		super(file.getAbsolutePath());
		
	}

	private String mArtist;
	private String mAlbum;
	private String mSongName;
	private int mSongNum;
	private String mYear;
	
	private String mExtension;
	private String mDuration;
	private String mFileSize;
	private String mBitRate;
	private String mTrackPosition;
	private String mGenre;
	private String mSamplingRate;
	private String mFilePath;
	private String mFileName;

	
	
	public String getArtist() {
		return mArtist;
	}
	public void setArtist(String mArtist) {
		this.mArtist = mArtist;
	}
	public String getAlbum() {
		return mAlbum;
	}
	public void setAlbum(String mAlbum) {
		this.mAlbum = mAlbum;
	}
	public String getSongName() {
		return mSongName;
	}
	public void setSongName(String mSongName) {
		this.mSongName = mSongName;
	}
	public int getSongNum() {
		return mSongNum;
	}
	public void setSongNum(int mSongNum) {
		this.mSongNum = mSongNum;
	}
	public String getYear() {
		return mYear;
	}
	public void setYear(String mYear) {
		this.mYear = mYear;
	}

	public String printAudioProperties() {
		return "AudioFile [mArtist=" + mArtist + ", mAlbum=" + mAlbum
				+ ", mSongName=" + mSongName + ", mSongNum=" + mSongNum
				+ ", mYear=" + mYear + "]";
	}
	
	
	
}
