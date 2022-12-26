
Feature: Crea tu usuario mediante petición HTTP yposteriormente recupera sus datos llamando al servicio correspondiente.



  Scenario:
    Given user connects to the "/pet/findByStatus" api
    Then user verifys satatus code is 200
