Feature: Web store functionality
  As a user
  In order to order some working tools
  I need to be able to search and buy goods on the web site

  @smoke
  Scenario: 1) Main page title
    When I open "http://spb.vseinstrumenti.ru" url
    Then I should see "Интернет-магазин ВсеИнструменты.ру в Санкт-Петербурге - электроинструмент, садовый и ручной инструмент, оборудование и станки" page title

  @smoke
  Scenario: 2) City choice menu check
    When I open "http://www.vseinstrumenti.ru" url
    And I open city choice menu
    Then I should see "Выберите свой город" text

  @smoke
  Scenario: 3) Sale price shopping
    When I open "https://www.vseinstrumenti.ru/stanki/sverlilnye/stalex/sverlilnyj-stanok-stalex-sdi-25t-industrial-z4125b1" url
    And I add item to shopping cart by sale price
    Then I should see "Товар добавлен в корзину" text

  @smoke
  Scenario: 4) Random city with delivery choice
    When I open "http://www.vseinstrumenti.ru" url
    And I open city choice menu
    And I choose random city with delivery
    Then I should see random city chosen

  @smoke
  Scenario: 5) Random best price item choice
    When I open "https://www.vseinstrumenti.ru/instrument/gravery/pryamoshlifovalnye-mashiny" url
    And I choose random item with best price
    Then I should see "Товар добавлен в корзину" text

  @smoke
  Scenario: 6) Contacts number check
    When I open "https://www.vseinstrumenti.ru/contacts/1.html" url
    Then I should see "+7 (495) 647-60-00" phone number for "Отдел подбора персонала" department