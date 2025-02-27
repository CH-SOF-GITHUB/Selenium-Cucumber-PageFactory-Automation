Feature: Tester la fonctionnalité Logout sur le site e-commerce Automation Test Store

  Scenario: je dois déconnecter de session sur le site e-commerce Automation Test Store
    Given je suis sur Automation Test Store
    When je clique sur login page
    And je saisie un login name "ChakerStore1"
    And je saisie un password "Azerty123"
    And je clique sur bouton Login
    And je clique sur logoff en sidebar
    Then déconnexion avec succès et affichage un message de confirmation