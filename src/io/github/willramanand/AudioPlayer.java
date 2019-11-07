package io.github.willramanand;

/**
 * This class simulates audio players within the program.
 *
 * @author William Ramanand
 */
public class AudioPlayer extends Product implements MultimediaControl {

  /**
   * String for supported audio formats.
   */
  private String supportedAudioFormats;

  /**
   * String for supported playlist formats.
   */
  private String supportedPlaylistFormats;

  /**
   * Constructor for Audio Player
   *
   * @param name                     to set the player's name to.
   * @param manufacturer             to set the manufacturer to.
   * @param supportedAudioFormats    to declare supported audio formats.
   * @param supportedPlaylistFormats to declare supported playlist formats.
   */
  public AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  /**
   * Simulates playing audio
   */
  public void play() {
    System.out.println("Playing");
  }

  /**
   * Simulates stopping audio
   */
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * Simulates going to the previous audio.
   */
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * Simulates going to the next audio
   */
  public void next() {
    System.out.println("Next");
  }

  /**
   * Method that returns information about the AudioPlayer as a String
   *
   * @return String of AudioPlayer Information
   */
  public String toString() {
    return super.toString()
        + "\nSupported Audio Formats: "
        + supportedAudioFormats
        + "\nSupported Playlist Formats: "
        + supportedPlaylistFormats;
  }
}
