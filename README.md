# sanitize-strings

Busca sanitizar string removendo scripts e tags de Strings fazendo uso de Regex.

Projeto meramente ilustrativo.

## Exemplo de uso:

```java
  @Test
  public void shouldRemoveTags() {
    final String textWithTags = "<p><b>This is</b> a typical message with <i>tags</i>";
    assertEquals("This is a typical message with tags", textWithTags);
  }
```

```java
  @Test
  public void shouldRemoveScripts() {
    final String untrustedText = "The first part is valid <script> but the second is invalid </script>";
    assertEquals("The first part is valid", untrustedText);
  }
```

