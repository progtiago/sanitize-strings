package com.progtiago.sanitizestrings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SanitizeTest {

  @Test
  public void shouldRemoveScripts() {
    final String untrustedText1 = "The first part is valid <script> second is invalid </script>";
    final String untrustedText2 = "The first part is valid <  script> second is invalid </ script>";
    final String untrustedText3 = "The first part is valid < ScriPT > second is invalid < /script>";
    final String untrustedText4 = "The first part is valid <script second is invalid />";
    final String untrustedText5 = "The first part is valid <ScrIpt second is invalid />";
    final String untrustedText6 = "The first part is valid <  ScrIpt second is invalid />";
    final String untrustedText7 = "The first part is valid <  ScrIpt second is invalid / >";
    final String untrustedText8 = "The first part is <script> second is invalid </script>valid";
    final String untrustedText9 = "The first part is <  script> second is invalid </ script>valid";
    final String untrustedText10 = "The first part is < ScriPT > second is invalid < /script>valid";
    final String untrustedText11 = "The first part is <script second is invalid />valid";
    final String untrustedText12 = "The first part is <ScrIpt second is invalid />valid";
    final String untrustedText13 = "The first part is <  ScrIpt second is invalid />valid";
    final String untrustedText14 = "The first part is <   ScrIpt second is invalid /  >valid";
    final String untrustedText15 = "The first part is <   onClick = 'do_anything' /  >valid";
    final String expectedSanitizedText = "The first part is valid";

    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText1));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText2));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText3));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText4));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText5));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText6));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText7));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText8));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText9));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText10));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText11));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText12));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText13));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText14));
    assertEquals(expectedSanitizedText, Sanitize.removeScripts(untrustedText15));
  }

  @Test
  public void shouldRemoveTags() {
    final String textWithTags1 = "<p><b>This is</b> a typical message with <i>tags</i>";
    final String textWithTags2 = "<p><b>This is</b> a <any Tag>typical</anyTag> message with <i>tags</i>";
    final String expectedTextWithoutTags = "This is a typical message with tags";

    assertEquals(expectedTextWithoutTags, Sanitize.removeTags(textWithTags1));
    assertEquals(expectedTextWithoutTags, Sanitize.removeTags(textWithTags2));
  }

  @Test
  public void shouldRemoveScriptsAndTags() {
    final String untrustedText1 = "The first part is <script> second is invalid </script><b>valid</b>";
    final String untrustedText2 = "The first part is valid <  script> second is invalid </ script> <tag /> ";
    final String expectedSanitizedText = "The first part is valid";

    assertEquals(expectedSanitizedText, Sanitize.removeScriptsAndTags(untrustedText1));
    assertEquals(expectedSanitizedText, Sanitize.removeScriptsAndTags(untrustedText2));
  }
}
