Create table Cooking_RECIPE
(
    ID          Long PRIMARY KEY Auto_increment,
    name       varchar,
    description varchar,
    category    varchar,
    likeNumber integer
);

INSERT INTO Cooking_RECIPE (name, description, category, likeNumber)
VALUES ('Rosół', 'Rosoł z kury', 'MIESNE', 0),
       ('Ryż z warzywami', 'Gotowany ryż z bukietem warzyw', 'WEGANSKIE', 0),
       ('jajko sadzone', 'jajko sadzone na maśle z cebulką', 'WEGETARIANSKIE', 0);