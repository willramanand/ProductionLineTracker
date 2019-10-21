package io.github.willramanand.players;

import io.github.willramanand.enums.ItemType;
import io.github.willramanand.enums.MonitorType;
import io.github.willramanand.utils.Screen;
import io.github.willramanand.interfaces.MultimediaControl;
import io.github.willramanand.utils.Product;

public class MoviePlayer extends Product implements MultimediaControl {
  private Screen screen;
  private MonitorType monitorType;

  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  public void play() {
    System.out.println("Playing movie");
  }

  public void stop() {
    System.out.println("Stopping movie");
  }

  public void previous() {
    System.out.println("Previous movie");
  }

  public void next() {
    System.out.println("Next movie");
  }

  @Override
  public String toString() {
    return super.toString() + this.screen + "\nMonitor Type: " + this.monitorType;
  }
}
