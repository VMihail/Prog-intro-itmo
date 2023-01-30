package markup.elements;

import markup.intarfaces.paragraphContent;

public class Text implements paragraphContent {
  private final String text;

  public Text(String text) {
    this.text = text;
  }

  @Override
  public void toMarkdown(StringBuilder sb) {
    sb.append(text);
  }
}
