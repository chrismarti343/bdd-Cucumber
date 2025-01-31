Feature:
  Verify user operations

  Scenario: Create list of users with given input array
    Given a list to add users
      """json
    {
      "id": 2424,
      "username": "chrismarti",
      "firstName": "Christian",
      "lastName": "Martinez",
      "email": "christiyosu3@gmail.com",
      "password": "abc123",
      "phone": "099999",
      "userStatus": 0
    }
"""
    When I sent the request with the data
    Then It should return 200 code