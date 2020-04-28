# LPOO_40 - Pokémon: A Sequel Coming In Inevitably

Our game consists, as the title states, in a *mock* version of the RPG Pokémon series, more specific, the Fire Red/Leaf Green games from Gameboy Advance.  

In it, the player will be able to catch and battle with pokémons in tall grass, try to catch them or even battle them with other their own pokémon.

The protagonist is a young boy who goes on a journey to be the very best pokémon trainer like no one ever was. 🎵

 In order to achieve his goal, the player will have to catch pokémon and battle other trainers. Whenever he wins a battle its pokémon gain experience points and when they gather a certain amount of experience, they level up or even evolve.  

This project was developed by [*Eduardo Correia*](https://github.com/educorreia932) (up201806433@fe.up.pt) and [*Ana Inês Barros*](https://github.com/anaines14) (up201806593@fe.up.pt) for LPOO 2019/2020.

## Implemented Features

### Player

- **Character Movement** - The player will move with the arrow keys in the desired direction, as well its sprite will change according to the direction he's facing.

<p align="center">
  <img width=300 src="https://i.imgur.com/XgxEBhc.gif">
</p>

- **Pokémon Appearing in Tall Grass** - When the player walks trough grass, they may encounter a wild pokémon and if so a battle with it will start. 

### Pokémon

- **Pokémon Types** - These are properties of pokémon and their moves. A pokémon may have up to two types, while a move only has one.

<p align="center">
  <img width=300 src="https://pokemonhelps13.weebly.com/uploads/4/9/5/5/49555787/4602605_orig.png ">
</p>

- **Type Effectiveness** - When a pokémon uses a move, the damage it will cause to the adversary pokémon will depend on the move's type and the other pokémon's type(s).   
A super effective attack will cause 2x the damage, a not very effective will cause 0.5x the damage and a no effect will cause 0x damage.  
For instance, the Water type is super effective against Fire, so if a Water pokémon move is used against a Fire pokémon, it would cause two times the normal damage it would cause.

### Battle

- **HP and Experience Bar** - These bars represent, respectively, the total health percentage of a pokémon in-battle and its experience progress from its current level to the next.

- **Battle Options Menu** - While in-battle the player has four options of what to do.  
    - **Fight** - Make the pokémon use move.
    - **Bag** - Use an item from the bag.
    - **Pokémon** - Change that's pokémon currently fighting for another one on the party.
    - **Run** - Try to flee from the battle.
    
<p align="center">
  <img width=300 src="https://i.imgur.com/WZK43Ed.gif">
</p>

## Planned features

### Player

- **Movement Animation** - When the player moves in a direction, a walking animation will play.
- **Ability to Run** - When the player presses the Z key while moving, they will start to run.
- **Option to be a Boy or a Girl** - At the start of a new game, the player may chose his character gender (for cosmetic purposes only).

### Pokémon

- **Leveling Up** - A pokémon's level goes from 1 to 100 and it can level up when it reaches a certain amount of experience, improving its stats.
- **Evolving** - Some pokémon have two or even three different evolutions and if so, they evolve when they reach a certain level.

### Battle

- **Pokémon Moves Menu**
- **Use Moves**
- **Pokémon Moves Animations**
- **Use items**

### Other

- **Save the progress**
- **Create profiles**  

## Design

## Graphics

We initially convert a .png image to text characters, using `img2txt`, a program from [libcaca](http://caca.zoy.org/wiki/libcaca). That program generates a .svg that we parse and then draw using Lanterna.

## Game Resources

### Images

- [Pokémon - Battle](https://veekun.com/dex/downloads), veekun
- [HP Bars & In-Battle Menu](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/33690/), redblueyellow
- [Battle Backgrounds](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/3866/), Desgardes

### Data Files

- [Pokémon](https://github.com/r4vi/zipper-demo/blob/master/resources/pokemon.xml), r4v1
- [Pokémon Moves](https://github.com/veekun/pokedex/blob/master/pokedex/data/csv/moves.csv), veekun

[Player Walking]: https://i.imgur.com/XgxEBhc.gif
[Pokemon Types]: https://pokemonhelps13.weebly.com/uploads/4/9/5/5/49555787/4602605_orig.png 
[Battle Options]: https://i.imgur.com/WZK43Ed.gif
