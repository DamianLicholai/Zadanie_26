Create table Cooking_RECIPE
(
    ID          Long PRIMARY KEY Auto_increment,
    name       varchar,
    description varchar,
    category    varchar,
    like_Number integer
);

INSERT INTO Cooking_RECIPE (name, description, category, like_Number)
VALUES ('Rosół', 'Rosoł z kury', 'MIESNE', 50),
       ('Ryż z warzywami', 'Gotowany ryż z bukietem warzyw', 'WEGANSKIE', 44),
       ('Ryż z jabłkami', 'Gotowany ryż z mlekiem i gotowanymi jablkami', 'WEGETARIANSKIE', 21),
       ('Kotlety siekane', 'filety z kurczaka marynowane 24H', 'MIESNE', 15),
       ('sznycle', 'Mięso mielone w bułce tartej', 'MIESNE', 6),
       ('jajko sadzone', 'jajko sadzone na maśle z cebulką', 'WEGETARIANSKIE', 7);