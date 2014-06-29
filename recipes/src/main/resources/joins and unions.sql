# Where clause
select r.id RECIPE_ID, r.name RECIPE_NAME, r.page_no PAGE, 
rb.id RECIPE_BOOK_ID, rb.name RECIPE_BOOK_NAME
from recipes r, recipe_books rb
where r.recipe_book_id = rb.id

# Inner Join - The INNER JOIN keyword selects all rows from both tables as long as there is a match between the columns in both tables
select r.id, r.name, r.page_no
from recipes r
inner join recipe_books rb
on r.recipe_book_id = rb.id

# Union - The UNION operator is used to combine the result-set of two or more SELECT statements. Removes duplicates
select r.recipe_book_id from recipes r
union 
select rb.id from recipe_books rb

# Union All - The UNION ALL operator is used to combine the result-set of two or more SELECT statements.  Contains duplicates
select r.recipe_book_id from recipes r
union all
select rb.id from recipe_books rb

select r.id RECIPE_ID, r.name RECIPE_NAME, r.page_no PAGE, 
rb.id RECIPE_BOOK_ID, rb.name RECIPE_BOOK_NAME
from recipes r, recipe_books rb
where r.recipe_book_id = rb.id
and r.id = 375
union 
select i.id, i.recipe_id, i.desc, i.id, i.id from ingredients i
where i.recipe_id = 375 