select * from recipes;

select * from recipe_books;

select * from ingredients;


insert into recipes(NAME, RECIPE_BOOK_ID, PAGE_NO) values ('Nice meal', 1, 23);

insert into recipe_books(NAME) values ('book 2');

insert into ingredients(RECIPE_ID, DESC) values(1, 'tomatoes');
insert into ingredients(RECIPE_ID, DESC) values(1, 'garlic');