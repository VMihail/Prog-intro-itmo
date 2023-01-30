package markup.elements;

import markup.intarfaces.paragraphContent;

import java.util.List;

public abstract class AbstractMarkupElement implements paragraphContent {
  private final List<paragraphContent> elementList;

  protected AbstractMarkupElement(final List<paragraphContent> elementList) {
    this.elementList = elementList;
  }

  @Override
  public void toMarkdown(StringBuilder sb) {
    sb.append(getBorder());
    for (paragraphContent paragraphContent : elementList) {
      paragraphContent.toMarkdown(sb);
    }
    sb.append(getBorder());
  }

  protected abstract String getBorder();
}
