@smoke
Feature: Ejercicio 2: Automatización de una web

  Scenario: Buscar en Google la palabra “automatización”
    Given user should be able to go url
    When user should be able to write "automatización" search input
    When user search wikipedia link
    Then take a screen shot wikipeda

