# LPOO_40 - *Pokemon: A Sequel Coming In Inevitably*

Our game consists, as the title states, in a *clone* version of the Pokémon series, more specific, the Fire Red/Leaf Green games from Gameboy Advance.  
In it, the player will be able to go search for pokémons in tall grass, try to catch them or even battle them with other their own pokémon.

This project was developed by [*Eduardo Correia*](https://github.com/educorreia932) (up201806433@fe.up.pt) and [*Ana Inês Barros*](https://github.com/anaines14) (up201806593@fe.up.pt) for LPOO 2019/2020.

## Planned Features

- [x] Make the main character appear in-game and be controllable (with arrow keys). 
- [x] Implement collisions. 
- [x] Make player's image change according to the direction he's facing.
- [x] Read data file about pokémons. 
- [x] Implement MVC. 
- [x] Render text. 
- [ ] Make a battle menu.
- [ ] Make pokémon appear when walking on grass.
- [ ] Implement multi-threading (for drawing and for user input).
- [ ] Implement animations (mainly for playing walking animation).
- [ ] Include three pokémons (starters) with fixed moves and abilities (but without leveling up).
- [ ] Make it possible to catch pokémon or battle against it.
- [ ] Implement items.
- [ ] Implement a `DamageMultiplier` class
- [ ] Include music and sound effects.

### Graphics

We initially convert a .png image to text, using `img2txt`, a program from [libcaca](http://caca.zoy.org/wiki/libcaca). That program generates a .svg that we parse and then draw using Lanterna.

## Game Art

Pokemon Fire Red/Leaf Green Sprites https://veekun.com/dex/downloads

Pokemon Data https://github.com/veekun/pokedex/tree/master/pokedex/data/csv

## Notes

- Our game would have only one level, that would consist in a open field with grass in which pokémon would appear
