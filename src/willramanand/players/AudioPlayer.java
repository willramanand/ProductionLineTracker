package willramanand.players;

import willramanand.utils.Product;
import willramanand.enums.ItemType;
import willramanand.interfaces.MultimediaControl;

public class AudioPlayer extends Product implements MultimediaControl {
  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  public AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.Audio);
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

  public String toString() {
    return super.toString() +"\nSupported Audio Formats: "
            + supportedAudioFormats
            + "\nSupported Playlist Formats: "
            + supportedPlaylistFormats;
  }
}
