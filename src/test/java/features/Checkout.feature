Feature: Tester la confirmation et le paiement des produits sur le site Automation Test Store

  Scenario: je dois confirmer et payer les produits ajoutés au panier
    Given je suis sur un site e-commerce Automation Test Store
    When je clique sur un lien login page
    And je saisie un loginname "ChakerStore1"
    And je saisie un mot de passe "Azerty123"
    And je clique sur un bouton Login
    And je clique sur une categorie "Apparel & accessories"
    And je clique sur produit "Fruit of the Loom T-Shirts 5 Pack - Super Premium"
    And je clique sur add to chart du produit "Fruit of the Loom T-Shirts 5 Pack - Super Premium"
    And je clique sur un bouton Checkout
    And je clique sur un bouton Confirm Order
    Then la confirmation et le paiement des produits avec succès
