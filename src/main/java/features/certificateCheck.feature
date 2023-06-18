@CertificateCheck

  Feature: Certificate verification
    Scenario Outline:
      When I enter certificate number "<CertNumber>"
      Then Check certificate verification "<Result>"

      Examples:
        | CertNumber | Result |
        | 45924126   | true   |
        | 8523699    | true   |
        | 254551     | true   |
        | 78008248   | true   |
        | 74185296   | false  |


