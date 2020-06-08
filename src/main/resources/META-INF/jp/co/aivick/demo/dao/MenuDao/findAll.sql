select
    M.menu_id,
    M.menu_name,
    M.menu_type,
    M.price
from menus M
INNER JOIN menu_recipe MR on M.menu_id=MR.menu_id
INNER JOIN recipes R ON MR.recipe_id=R.recipe_id
group by M.menu_id;