__config() -> {
    'stay_loaded' -> true,
    'commands' -> {
        '<players>' -> _(plrA) -> _otherloc(plrA);,
        '' -> _() ->_myloc();,
        'me' -> _() ->_myloc();
    }
};

_myloc()->(
    player = player();

    x=round(query(player,'x'));
    y=round(query(player,'y'));
    z=round(query(player,'z'));
    dim=query(player,'dimension');
    run('tellraw @e[type=player] ["",{"text":"------------------------------","color":"dark_gray"}]');
    if (dim == 'the_end', run('tellraw @e[type=player] ["",{"text":"'+player+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"End","color":"light_purple"}]') );
    if (dim == 'the_nether', run('tellraw @e[type=player] ["",{"text":"'+player+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"Nether","color":"red"}]') );
    if (dim == 'overworld', run('tellraw @e[type=player] ["",{"text":"'+player+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"Overworld","color":"green"}]') );
    run('tellraw @e[type=player] ["",{"text":"------------------------------","color":"dark_gray"}]');
    run('effect give '+player+' minecraft:glowing 10 255 true');
);

_otherloc(plrA)->(
    plr = player(plrA:0);
    you = player();

    if(you == plr,(_myloc()));
    if(you != plr,(

        x=round(query(plr,'x'));
        y=round(query(plr,'y'));
        z=round(query(plr,'z'));
        dim=query(plr,'dimension');

        run('tellraw '+you+' ["",{"text":"------------------------------","color":"dark_gray"}]');
        if (dim == 'the_end', run('tellraw '+you+' ["",{"text":"'+plr+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"End","color":"light_purple"}]') );
        if (dim == 'the_nether', run('tellraw '+you+' ["",{"text":"'+plr+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"Nether","color":"red"}]') );
        if (dim == 'overworld', run('tellraw '+you+' ["",{"text":"'+plr+'","color":"dark_aqua"},{"text":" >> ","color":"white"},{"text":"x'+x+' | y'+y+' | z'+z+'","color":"aqua"},{"text":" >> ","color":"white"},{"text":"Overworld","color":"green"}]') );

        your_x=round(query(you,'x'));
        your_y=round(query(you,'y'));
        your_z=round(query(you,'z'));
        your_dim=query(you,'dimension');

        away_x = your_x - x;
        away_x = abs(away_x);
        away_y = your_y - y;
        away_y = abs(away_y);
        away_z = your_z - z;
        away_z = abs(away_z);

        away_blocks = away_x + away_y + away_z;

        if (dim == your_dim, run('tellraw '+you+' ["",{"text":"'+away_blocks+'","color":"dark_aqua"},{"text":" blocks away from you.","color":"gray"}]') );
        run('tellraw '+you+' ["",{"text":"------------------------------","color":"dark_gray"}]');
        run('tellraw '+you+' ["",{"text":"only you can see those messages above.","color":"dark_gray"}]');
        run('effect give '+plr+' minecraft:glowing 10 255 true');
        )
    );
);
