#  usage and sccapi features
Exposed rest endpoints-
1 WelcomeController- has one endpoint which serves a welcome page showing all the Characters and phrases already created in db.  /welcome  welcome page
2 CharacterController- /character  supports CRUD operations
/create  create a Character
/all  - get all characters
/{characterId}  - get Character by characterId
/update      - update Character using Id
/delete/{characterId}  - delete Character  by CharacterId

3 PhraseController - /phrases support CRUD operations
/create  creates a phrase
/all - get all prases in the db
/{phraseId}  get a phrase
/update update a phrase by phraseId, cant update phraseId
/delete/{phraseId}
/quotes/{characterId} - get All Quotes of a character
