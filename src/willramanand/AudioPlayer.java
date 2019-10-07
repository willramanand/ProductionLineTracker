package willramanand;

public class AudioPlayer extends Product implements MultimediaControl {
  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats, String supportedPlaylistFormats) {
    super(name, manufacturer, "AUDIO");
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  public void play() {
    System.out.println("Playing");
  }
  public void stop() {
    System.out.println("Stopping");
  }
  public void previous() {
    System.out.println("Previous");
  }
  public void next() {
    System.out.println("Next");
  }

  @Override
  public String toString() {
    return "Name: " + getName()
        + "\nManufacturer: " + getManufacturer()
        + "\nType: AUDIO"
        + "\nSupported Audio Formats: " + supportedAudioFormats
        + "\nSupported Playlist Formats: " + supportedPlaylistFormats;
  }
}