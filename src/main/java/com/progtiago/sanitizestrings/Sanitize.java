package com.progtiago.sanitizestrings;

import static java.util.Optional.ofNullable;

public class Sanitize {

  public static String removeScriptsAndTags(final String text) {
    return removeTags(removeScripts(text));
  }

  public static String removeTags(final String text) {
    return ofNullable(text)
        .orElse("").replaceAll("(?i)<.*?>", "").trim();
  }

  public static String removeScripts(final String text) {
    return ofNullable(text).orElse("")
        .replaceAll("(?i)<.*?script.*?>.*?<.*?script.*?>", "")
        .replaceAll("(?i)<.*?script.*?/>", "")
        .replaceAll("(?i)<.*?script.*?>", "")
        .replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "")
        .replaceAll("(?i)<.*?javascript:.*?/>", "")
        .replaceAll("(?i)<.*?javascript:.*?>", "")
        .replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "")
        .replaceAll("(?i)<.*?\\s+on.*?/>", "")
        .replaceAll("(?i)<.*?\\s+on.*?>", "").trim();
  }
}
