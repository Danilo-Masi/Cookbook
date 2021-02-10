# Cookbook

#### Application to manage the dishes offered by a restaurant. Eeach dish is described by name, cost and category (appetizer, first course, second course and dessert). Each dish also is consisting of a list of ingredients. For each ingredient it is necessary to keep track of the name, the quantity (expressed in grams), whether the ingredient is an allergen or not and the Kcal compared to 100 grams ingredient.

#### The application allows you to perform the following functions:
- The user loads the toll booth archive.
- The user selects a category, the system shows, in a table, the list of dishes of the category chosen by the user.
- When selecting a dish, the user requests the dish that is closest in number of calories to that selected, 
  the system shows a window in which there is a summary of the data of the dish found, if the dish is found, the system encourages you to try again with another dish.

#### The software is structured in different packages:
- In the "modello" package there are all the classes that make up the software and the application logic that makes the program work.
- In the "interfaccia" package there are the classes that make up the software graphics created with Swing.
- In the "persistenza" package there are classes that simulate loading data from files.
- In the "controllo" package there are classes that manage the actions that the user can perform in the interface.
- In the "test" package there are classes that are used to test the application logic of the software.
- In the general package there is an "Applicazione" class which acts as an intermediary between all the software classes.

#### Libraries used:
- slf4-api
- logback-core
- logback-classic
- junit (Library used to run tests)
