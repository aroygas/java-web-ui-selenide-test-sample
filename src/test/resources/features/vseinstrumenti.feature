Feature: Web store functionality
  As a user
  In order to order some working tools
  I need to be able to search and buy goods on the web site

#First part of the task
  @part1
  Scenario: 1) Main page title
    When I open "http://spb.vseinstrumenti.ru" url
    Then I should see "Интернет-магазин ВсеИнструменты.ру в Санкт-Петербурге - электроинструмент, садовый и ручной инструмент, оборудование и станки" page title

  @part1
  Scenario: 2) City choice menu check
    When I open "http://www.vseinstrumenti.ru" url
    And I open city choice menu
    Then I should see "Выберите свой город" text

  @part1
  Scenario: 3) Sale price shopping
    When I open "https://www.vseinstrumenti.ru/stanki/sverlilnye/stalex/sverlilnyj-stanok-stalex-sdi-25t-industrial-z4125b1" url
    And I add item to shopping cart by sale price
    Then I should see "Товар добавлен в корзину" text

  @part1
  Scenario: 4) Random city with delivery choice
    When I open "http://www.vseinstrumenti.ru" url
    And I open city choice menu
    And I choose random city with delivery
    Then I should see random city chosen

  @part1
  Scenario: 5) Random best price item choice
    When I open "https://www.vseinstrumenti.ru/instrument/gravery/pryamoshlifovalnye-mashiny" url
    And I choose random item with best price
    Then I should see "Товар добавлен в корзину" text

  @part1
  Scenario: 6) Contacts number check
    When I open "https://www.vseinstrumenti.ru/contacts/1.html" url
    Then I should see "+7 (495) 647-60-00" phone number for "Отдел подбора персонала" department

#Second part of the task
  @part2
  Scenario: 7) Search for Makita drill and add it to shopping cart
    When I open "http://www.vseinstrumenti.ru" url
    And I search for "дрель" on main page
    And I click on link with text "Все производители"
    And I choose "Makita" manufacturer
    And I click on link with text "Подобрать товар"
    And I add first item to cart
    Then I should see "Товар добавлен в корзину" text

  @part2
  Scenario: 8) Filtering and pagination in catalogue table
    When I open "http://www.vseinstrumenti.ru" url
    And I hover over catalogue item with text "Сантехника"
    And I click on link with text "Сушилки для рук"
    And I select "Рейтингу" option from "Сортировать по" drop-down filter
    And I select "64" option from "Отображать по" drop-down filter
    And I go to page number "2"
    Then I should see "Сушилка для рук" text
