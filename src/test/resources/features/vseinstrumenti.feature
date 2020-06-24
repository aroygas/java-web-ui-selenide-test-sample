Feature: Web store functionality
  As a user
  In order to order some working tools
  I need to be able to search and buy goods on the web site

  @smoke
  Scenario: Check web site tab header
    When I open "http://spb.vseinstrumenti.ru" url
    Then I should see "Интернет-магазин ВсеИнструменты.ру в Санкт-Петербурге - электроинструмент, садовый и ручной инструмент, оборудование и станки" page title