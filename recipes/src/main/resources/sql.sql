select * from recipes where name = 'test 8';

select * from ingredients where recipe_id = 455;
delete from ingredients where recipe_id = 455;


select * from recipes;
select * from recipe_books;
select * from ingredients;

delete from recipes;
delete from ingredients;
delete from recipe_books;

insert into recipes(NAME, RECIPE_BOOK_ID, PAGE_NO) values ('Nice meal', 1, 23);

insert into recipe_books(NAME) values ('book 2');

insert into ingredients(RECIPE_ID, DESC) values(1, 'tomatoes');
insert into ingredients(RECIPE_ID, DESC) values(1, 'garlic');