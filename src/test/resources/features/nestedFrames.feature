@alerts @demoqa
  Feature: kullanıcı nested frameler arasında geciş yapar
    Scenario: kullanıcı nested frameler arasında geciş yapar
      Given kullanıcı nestedFrames sayfasına gider
      And ilk frameye içindeki "Parent frame" yazısının varlığını doğrular
      And nested frame içindeki "Child Iframe" yazısını doğrular