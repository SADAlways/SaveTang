package game.world;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music {
	public static HashMap<String,Music> music = new HashMap<>();
	
	static {
		music.put("start", new Music("sounds//Att_w.wav"));
		music.put("dead", new Music("sounds//财狼死亡.wav"));
		music.put("money", new Music("sounds//得到金币.wav"));
		music.put("theme", new Music("sounds//西游记主题曲.wav"));
		music.put("womendead", new Music("sounds//死亡女声.wav"));
		music.put("mendead", new Music("sounds//兽人被击倒.wav"));
		music.put("mousetouch", new Music("sounds//鼠标触碰.wav"));
		music.put("mouseclick", new Music("sounds//鼠标点击.wav"));
		music.put("lightning", new Music("sounds//lingtning.wav"));
		music.put("water", new Music("sounds//water.wav"));
		music.put("wind", new Music("sounds//wind.wav"));
		music.put("mkb", new Music("sounds//棍子挥舞.wav"));
		music.put("gamelost", new Music("sounds//白骨精出场.wav"));
	}
	private AudioData audiodata;
	private AudioDataStream audiostream;
	private ContinuousAudioDataStream cads;
	public Music(String filename)  {
	    FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			@SuppressWarnings("resource")
			AudioStream audioStream = new AudioStream(fis);
		    audiodata = audioStream.getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	  }
	  public void play() {
	    audiostream = new AudioDataStream(audiodata);
	    AudioPlayer.player.start(audiostream);
	  }
	  public void loop(){
		  cads = new ContinuousAudioDataStream(audiodata);
		  AudioPlayer.player.start(cads);
		  
	  }
	  public void stop() {
		    AudioPlayer.player.stop(audiostream);
	  }
	  public void loopStop() {
		  AudioPlayer.player.stop(cads);
	  }
}
