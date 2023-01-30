package markup.elements;

import markup.intarfaces.paragraphContent;

import java.util.List;

public class Paragraph implements paragraphContent {
  private final List<paragraphContent> elementList;

  public Paragraph(final List<paragraphContent> elementList) {
    this.elementList = elementList;
  }

  @Override
  public void toMarkdown(StringBuilder sb) {
    for (paragraphContent paragraphContent : elementList) {
      paragraphContent.toMarkdown(sb);
    }
  }
}
