package io.github.willramanand;

/**
 * Class that stores details for Screens.
 *
 * @author William Ramanand
 */
public class Screen implements ScreenSpec {

  /**
   * Stores resolution of screen.
   */
  private String resolution;

  /**
   * Stores refresh rate of screen.
   */
  private int refreshRate;

  /**
   * Stores response time of screen.
   */
  private int responseTime;

  /**
   * Constructor for Screen.
   * @param resolution sets resolution.
   * @param refreshRate sets refresh rate.
   * @param responseTime sets response time.
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Gets resolution of Screen.
   * @return resolution
   */
  public String getResolution() {
    return resolution;
  }

  /**
   * Gets refresh rate of screen.
   * @return refresh rate.
   */
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * Gets response time of screen.
   * @return response time.
   */
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Method that returns details of the screen.
   * @return String of screen details.
   */
  public String toString() {
    return "\nScreen:"
        + "\nResolution: " + this.resolution
        + "\nRefresh rate: " + this.refreshRate
        + "\nResponse time: " + this.responseTime;
  }
}