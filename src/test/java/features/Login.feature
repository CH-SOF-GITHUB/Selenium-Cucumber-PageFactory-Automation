Feature: Tester la fonctionnalité de connexion

  Scenario: tester la connexion au site e-commerce avec données valides et invalides
    Given je suis sur la page home de site Automation Test Store
    When je clique sur Login or Register
    And je saisie username "ChakerStore1"
    And je saisie password "Azerty123"
    And je clique sur le bouton de connexion
    Then connexion avec succès pour données valides et échec de connexion et affichage un message d'erreur pour les données invalides


  Scenario Outline: tester la connexion au site e-commerce avec données valides et invalides
    Given je suis sur la page home de site Automation Test Store
    When je clique sur Login or Register
    And je saisie username <username>
    And je saisie password <password>
    And je clique sur le bouton de connexion
    Then connexion avec succès pour données valides et échec de connexion et affichage un message d'erreur pour les données invalides
    Examples:
      | username        | password     |
      | "ChakerStore34" | "Azerty123"  |
      | "ChakerStore1"  | "Azert12345" |
      | "ChakerStore40" | "Azerty1"    |