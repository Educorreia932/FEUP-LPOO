# LPOO_40 - *Pokemon: A Sequel Coming In Inevitably*

Our game consists, as the title states, in a *clone* version of the Pokémon series, more specific, the Fire Red/Leaf Green games from Gameboy Advance.  
In it, the player will be able to go search for pokémons in tall grass, try to catch them or even battle them with other their own pokémon.

This project was developed by [*Eduardo Correia*](https://github.com/educorreia932) (up201806433@fe.up.pt) and [*Ana Inês Barros*](https://github.com/anaines14) (up201806593@fe.up.pt) for LPOO 2019/2020.

## Planned Features

### Player

- [x] Character movement (with arrow keys). 
- [x] Image changing according to the direction the character's facing.
- [x] Collisions with walls.
- [x] Pokémon appearing when walking on tall-grass.
- [ ] Movement animation.
- [ ] Ability to run.

### Pokémon

- [x] Type effectiveness multipliers.
- [ ] Leveling up.

### Battle

- [x] HP and Experience bar.
- [ ] Battle options menu.
- [ ] Use Moves.
- [ ] Use Items.

## Graphics

We initially convert a .png image to text characters, using `img2txt`, a program from [libcaca](http://caca.zoy.org/wiki/libcaca). That program generates a .svg that we parse and then draw using Lanterna.

## To-Do

## Design

## Game Resources

### Images

- [Pokémon - Battle](https://veekun.com/dex/downloads), veekun
- [HP Bars & In-Battle Menu](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/33690/), redblueyellow
- [Battle Backgrounds](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/3866/), Desgardes

### Data Files

- [Pokémon](https://github.com/r4vi/zipper-demo/blob/master/resources/pokemon.xml), r4v1
- [Pokémon Moves](https://github.com/veekun/pokedex/blob/master/pokedex/data/csv/moves.csv), veekun
