package willramanand;

public enum ItemType {
  Audio ("AU"),
  Visual ("VI"),
  AudioMobile ("AM"),
  VisualMobile ("VM");

  private final String code;

  ItemType (String code) {
    this.code = code;
  }

  public String getCode(ItemType type) {
    String itemCode = "";

    if (type == Audio){
      itemCode = Audio.code;
    } else if (type == Visual) {
      itemCode = Visual.code;
    } else if (type == AudioMobile) {
      itemCode = AudioMobile.code;
    } else if (type == VisualMobile) {
      itemCode = VisualMobile.code;
    }
    return itemCode;
  }

}
