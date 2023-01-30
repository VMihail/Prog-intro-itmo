package markup.tests;

import markup.elements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {
  @Test
  public void testMarkup() {
    final String expected = "__1~2*34*5~6__";
    Paragraph paragraph = new Paragraph(List.of(
      new Strong(List.of(
        new Text("1"),
        new Strikeout(List.of(
          new Text("2"),
          new Emphasis(List.of(
            new Text("3"),
            new Text("4")
          )),
          new Text("5")
        )),
        new Text("6")
      ))
    ));
    StringBuilder result = new StringBuilder();
    paragraph.toMarkdown(result);
    Assertions.assertEquals(expected, result.toString());
  }
}
