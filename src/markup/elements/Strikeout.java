package markup.elements;

import markup.intarfaces.paragraphContent;

import java.util.List;

public class Strikeout extends AbstractMarkupElement {
  private static final String MARKUP_BORDER = "~";

  public Strikeout(final List<paragraphContent> elementList) {
    super(elementList);
  }

  @Override
  protected String getBorder() {
    return MARKUP_BORDER;
  }
}
