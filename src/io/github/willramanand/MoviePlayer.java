package io.github.willramanand;

/**
 * Class for creating products that are a movie player.
 *
 * @author William Ramanand
 */
public class MoviePlayer extends Product implements MultimediaControl {

  /**
   * Stores the details of the screen.
   */
  private Screen screen;

  /**
   * Stores the details of the monitor type.
   */
  private MonitorType monitorType;

  /**
   * Constructor for movie player.
   * @param name to set name of movie player
   * @param manufacturer to set manufacturer of movie player.
   * @param screen to set screen of movie player
   * @param monitorType to set monitor type of movie player.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * Simulates playing movie.
   */
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * Simulates stopping movie.
   */
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * Simulates going to previous movie.
   */
  public void previous() {
    System.out.println("Previous movie");
  }

  /**
   * Simulates going to next movie.
   */
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * Method that returns a string that contains the details of the movie player.
   * @return String of details
   */
  @Override
  public String toString() {
    return super.toString() + this.screen + "\nMonitor Type: " + this.monitorType;
  }
}
