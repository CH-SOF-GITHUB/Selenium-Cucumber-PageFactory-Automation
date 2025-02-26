Feature: Tester la fonctionnalité ajout un ou plusieurs produits sur le site e-commerce Automation Test Store

  Scenario: tester la connexion et l'ajout d'un ou plusieurs produits au panier
    Given je suis sur le site e-commerce Automation Test Store
    When je clique sur la page login
    And je saisie login name "ChakerStore1"
    And je saisie mot de passe "Azerty123"
    And je clique sur le bouton Login
    And je clique sur une catégorie du produit "Apparel & accessories"
    And je clique sur un produit "Fruit of the Loom T-Shirts 5 Pack - Super Premium"
    And je clique sur le bouton add to chart
    And je clique autre fois sur la catégorie du produit "Apparel & accessories"
    And je clique sur le produit "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie"
    And je clique sur un bouton add to chart
    Then ajout des produits au panier