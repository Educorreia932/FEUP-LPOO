# LPOO_40 - Pokémon: A Sequel Coming In Inevitably

Our game consists, as the title states, in a *mock* version of the RPG Pokémon series, more specific, the Fire Red/Leaf Green games from Gameboy Advance.  

In it, the player will be able to catch and battle with pokémons in tall grass, try to catch them or even battle them with other their own pokémon.

The protagonist is a young boy who goes on a journey to be the very best pokémon trainer like no one ever was. 🎵

 In order to achieve his goal, the player will have to catch pokémon and battle other trainers. Whenever he wins a battle its pokémon gain experience points and when they gather a certain amount of experience, they level up or even evolve.  

This project was developed by [*Ana Inês Barros*](https://github.com/anaines14) (up201806593@fe.up.pt) and [*Eduardo Correia*](https://github.com/educorreia932) (up201806433@fe.up.pt) for LPOO 2019/2020.

## Implemented Features

### Player

- **Character Movement** - The player will move with the arrow keys in the desired direction, as well its sprite will change according to the direction he's facing.

<p align="center">
  <img width=350 src="https://i.imgur.com/XgxEBhc.gif">
</p>

- **Pokémon Appearing in Tall Grass** - When the player walks trough grass, they may encounter a wild pokémon and if so a battle with it will start. 

### Pokémon

- **Pokémon Types** - These are properties of pokémon and their moves. A pokémon may have up to two types, while a move only has one.

<p align="center">
  <img width=350 src="https://pokemonhelps13.weebly.com/uploads/4/9/5/5/49555787/4602605_orig.png">
</p>

**Note:** Fairy type isn't included in our game,  as it wasn't in the original 3<sup>rd</sup> generation pokémon games.

- **Type Effectiveness** - When a pokémon uses a move, the damage it will cause to the adversary pokémon will depend on the move's type and the other pokémon's type(s).   
A super effective attack will cause 2x the damage, a not very effective will cause 0.5x the damage and a no effect will cause 0x damage.  
For instance, the Water type is super effective against Fire, so if a Water pokémon move is used against a Fire pokémon, it would cause two times the normal damage it would cause.

### Battle

- **HP and Experience Bar** - These bars represent, respectively, the total health percentage of a pokémon in-battle and its experience progress from its current level to the next.

<p float="left" align="middle">
  <img width=350 src="https://i.imgur.com/vuoW9ul.gif">
  <img width=350 src="https://i.imgur.com/7qoZUqi.gif">
</p>

- **Battle Options Menu** - While in-battle the player has four options of what to do.  
    - **Fight** - Make the pokémon use move.
    - **Bag** - Use an item from the bag.
    - **Pokémon** - Change that's pokémon currently fighting for another one on the party.
    - **Run** - Try to flee from the battle.

<p align="center">
    <img width=350 src="https://i.imgur.com/WZK43Ed.gif">
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
- **Create NPCs**

## Architectural Pattern

For easier development of the game, we implemented the MVC (Model–View–Controller) design pattern, with the following division.
- **Model (data)** - Stores all of the lpoo.pokemonascii.data structure of the game and its current state.
- **View (gui)** - Handles the interaction with the user, be it input, by pressing the keyboard's keys, or be it output, by a graphical interface that represents the game.
- **Controller (rules)** - Coordinates and processes all the changes that occur.

<p align="center">
  <img width=350 src="https://i.imgur.com/d19ics3.png">
</p>

Our game currently has the MVC implemented in the following modules:

#### Game

Different states of the game, world and battle

#### World 

Player walks around the world

#### Battle

Two pokémon battle each other

#### Options Menu

For menus where the user has choose some option

## Design

### Collisions

###

### Graphics

Due to the fact that pokémon games from Gameboy Advances graphics are colorful and complex, we had to adapt them to meet Lanterna's limitations. 
The war we did this was to initially convert a `.png` image to text, using `img2txt`, a program from [libcaca](http://caca.zoy.org/wiki/libcaca). That program generates a `.svg` that we parse and then draw using Lanterna.
We store the parsed image content (such as colors and text characters) in a class `Image` and then we have a class `Sprite`that can store multiple `Images`, each one corresponding to a certain state of what the `Sprite` represents, for instance, the `Player` `Sprite` will have an image for each facing direction.  
For each game element we have a `Renderer` that is responsible for drawing it in the screen.

TODO: UML image

### Code Smells and Possible Refactorings

#### Dispensables - Data Class

The [class Option](../src/main/java/lpoo/pokemonascii/rules/commands/optionsmenu) is an example of a Data class in our code.
 This class only has a string field and both a getter and a setter for accessing it. Removing this class would make the 
 code seem a lot simpler since this class can be replaced by the primitive String.
 

#### Dispensables - Lazy Class

The [class Tile](../src/main/java/lpoo/pokemonascii/data/Tile.java) was designed in order to support future 
development work that has not been done yet. Our plan is to be able to create different tiles with distinct purposes 
and methods. However, at the moment, we only have one type of tile, the [Grass class](../src/main/java/lpoo/pokemonascii/data/Grass.java).
  
Having this class is provokes a small increment in the complexity and size of the code. To solve this problem, we could 
use the refactoring method **Collapse Hierarchy** by merging the Tile class with the [Grass class](../src/main/java/lpoo/pokemonascii/data/elements/CollidingElement.java).

#### Bloaters - Switch Statements

The method getNextCommand() in the [class BattleView](../src/main/java/lpoo/pokemonascii/gui/BattleView.java) has a long
 switch case inside of it. This creates a problem: everytime we want to have a condition we have to find all the switch 
 code and modify it. 
 
Since this switch is based on type code, we should use the **Replace Type Code with Subclasses**. To do this, instead of
using a enum to represent the key type, we should create a subclass **KeyType** and subclasses of KeyType to each value 
of the coded type. Then, extract the relevant behaviours from the original class to these subclasses. Replace the control
 flow code with polymorphism. By doing this we imporve code organization.


### Collisions

## Game Resources

### Images

- [Pokémon - Battle](https://veekun.com/dex/downloads), veekun
- [HP Bars & In-Battle Menu](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/33690/), redblueyellow
- [Battle Backgrounds](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/3866/), Desgardes

### Data Files

- [Pokémon](https://github.com/r4vi/zipper-demo/blob/master/resources/pokemon.xml), r4v1
- [Pokémon Moves](https://github.com/veekun/pokedex/blob/master/pokedex/lpoo.pokemonascii.data/csv/moves.csv), veekun

## Self-Evaluation

- Ana Inês Barros: 50%
- Eduardo Correia: 50%