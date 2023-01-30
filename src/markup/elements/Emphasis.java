package markup.elements;

import java.util.List;
import markup.intarfaces.paragraphContent;

public class Emphasis extends AbstractMarkupElement {
  private static final String MARKUP_BORDER = "*";

  public Emphasis(final List<paragraphContent> elementList) {
    super(elementList);
  }

  @Override
  protected String getBorder() {
    return MARKUP_BORDER;
  }
}
