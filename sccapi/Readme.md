#  usage and sccapi features
Exposed rest endpoints-

1 WelcomeController- has one endpoint which serves a welcome page showing all the Characters and phrases already created in db.  

/welcome  welcome page

2 CharacterController- /characters  supports CRUD operations (Example : localhost:8083/characters/create  provide the json object in body)

/create - create a Character

/all  - get all characters

/{characterId}  - get Character by characterId

/update      - update Character using Id

/delete/{characterId}  - delete Character  by CharacterId

3 PhraseController - /phrases support CRUD operations

/create  creates a phrase

/all - get all prases in the db

/{phraseId}  get a phrase

/update update a phrase by phraseId, can  update other values not phraseId

/delete/{phraseId}

/quotes/{characterId} - get All Quotes of a character
