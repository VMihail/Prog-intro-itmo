package markup.elements;

import markup.intarfaces.paragraphContent;

import java.util.List;

public class Strong extends AbstractMarkupElement {
  private static final String MARKUP_BORDER = "__";

  public Strong(final List<paragraphContent> elementList) {
    super(elementList);
  }

  @Override
  protected String getBorder() {
    return MARKUP_BORDER;
  }
}
