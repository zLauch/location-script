__config() -> {'stay_loaded' -> true};

__command()->(
    _p();
);

_p()->(
    player = player();

    x=round(query(player,'x'));
    y=round(query(player,'y'));
    z=round(query(player,'z'));
    dim=query(player,'dimension');

    if (dim == 'the_end', run('tellraw @e[type=player] ["",{"text":"'+player+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"End","color":"light_purple"}]') );
    if (dim == 'the_nether', run('tellraw @e[type=player] ["",{"text":"'+player+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"Nether","color":"red"}]') );
    if (dim == 'overworld', run('tellraw @e[type=player] ["",{"text":"'+player+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"Overworld","color":"green"}]') );

    return();
);
