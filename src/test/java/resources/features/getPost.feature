Feature: Verify all request

  Scenario: Create a pet and verify its name
    Given I create a new pet with name "dodge", ID 33 and status "active"
    When I retrieve the pet information for ID 33
    Then the response status code is 200 and the pet name is "dodge" if is shearched by ID 33

  Scenario: Create a new pet using a chart and verify
    Given I have this data:
    """json
    {
      "id": 0,
      "category": {
        "id": 0,
        "name": "string"
      },
      "name": "dodgeTest",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "string"
        }
      ],
      "status": "available"
    }
    """
    When I send a post request with data
    Then I receive the response code as 200

  Scenario Outline: Place an order for a pet
    When I send a POST request with body:
  """json
{
"id": "<id>",
"petId": 0,
"quantity": 0,
"shipDate": "2024-06-04T21:39:38.341Z",
"status": "<status>",
"complete": true
}
"""
    Then I should get 200 code

    Examples:
      | id | status      |
      | 2  | available   |
      | 3  | unavailable |



