package io.github.willramanand;

/**
 * Interface for screen related classes.
 *
 * @author William Ramanand
 */
public interface ScreenSpec {

  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
