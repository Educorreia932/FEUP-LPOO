# LPOO_40 - Pokémon: A Sequel Coming In Inevitably

Our game consists, as the title states, in a *mock* version of the RPG Pokémon series, more specific, the Fire Red/Leaf Green games from Gameboy Advance.  

In it, the player will be able to catch and battle with pokémons in tall grass, try to catch and battle them with our own pokémons.

The protagonist is a young boy who goes on a journey to be the very best pokémon trainer like no one ever was. 🎵

 In order to achieve his goal, the player will have to catch pokémon and battle other trainers. Whenever he wins a battle his pokémons gain experience points and when they gather a certain amount of experience, they level up or even evolve.  

This project was developed by [*Ana Inês Barros*](https://github.com/anaines14) (up201806593@fe.up.pt) and [*Eduardo Correia*](https://github.com/educorreia932) (up201806433@fe.up.pt) for LPOO 2019/2020.

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Implemented Features](#implemented-features)
  * [Player](#player)
  * [Pokémon](#pok-mon)
  * [Battle](#battle)
- [Planned features](#planned-features)
  * [Player](#player-1)
  * [Pokémon](#pok-mon-1)
  * [Battle](#battle-1)
  * [Other](#other)
- [Architectural Pattern](#architectural-pattern)
    + [World](#world)
    + [Battle](#battle-2)
    + [Options Menu](#options-menu)
- [Design](#design)
  * [Music](#music)
    + [Problem in Context](#problem-in-context)
    + [The Pattern](#the-pattern)
    + [The Implementation](#the-implementation)
    + [Consequences](#consequences)
  * [Gamemode](#gamemode)
    + [Problem in Context](#problem-in-context-1)
    + [The Pattern](#the-pattern-1)
    + [Implementation](#implementation)
    + [Consequences](#consequences-1)
  * [Input](#input)
    + [Problem in Context](#problem-in-context-2)
    + [The Pattern](#the-pattern-2)
    + [Implementation](#implementation-1)
    + [Consequences](#consequences-2)
  * [Graphics](#graphics)
    + [Problem in Context](#problem-in-context-3)
    + [The Pattern](#the-pattern-3)
    + [Implementation](#implementation-2)
    + [Consequences](#consequences-3)
- [Code Smells and Possible Refactorings](#code-smells-and-possible-refactorings)
    + [Dispensables - Data Class](#dispensables---data-class)
    + [Dispensables - Lazy Class](#dispensables---lazy-class)
    + [Bloaters - Switch Statements](#bloaters---switch-statements)
    + [Change Preventers - Parallel Inheritance](#change-preventers---parallel-inheritance)
- [Testing](#testing)
- [Self-Evaluation](#self-evaluation)
- [Game Resources](#game-resources)
  * [Images](#images)
  * [Data Files](#data-files)

## Implemented Features

### Player

- **Character Movement** - The player will move with the arrow keys in the desired direction, as well its sprite will change according to the direction he's facing.
Colisions are implemented so the player does not wal through obstacles and to detect when a player
collides with a PokemonTile.

<p align="center">
  <img width=375 src="images/Character%20Movement.gif">
</p>

- **Pokémon Appearing in Tall Grass** - When the player walks trough grass, they may encounter a wild pokémon and if so a battle with it will start. 

<p align="center">
    <img width=450 src="images/Tall%20Grass.gif">
</p>

The pokemon that might appear depends on the zone of the map the grass is. Starting from zone 1, the level of the
pokemons that might appear will increase along the four different areas.

### Pokémon

- **Pokémon Types** - These are properties of pokémon and their moves. A pokémon may have up to two types, while a move only has one.

<p align="center">
  <img width=350 src="images/Pokemon%20Types.png">
</p>

**Note:** Fairy type isn't included in our game,  as it wasn't in the original 3<sup>rd</sup> generation pokémon games.

- **Type Effectiveness** - When a pokémon uses a move, the damage it will cause to the adversary pokémon will depend on the move's type and the other pokémon's type(s).   
A super effective attack will cause 2x the damage, a not very effective will cause 0.5x the damage and a no effect will cause 0x damage.  
For instance, the Water type is super effective against Fire, so if a Water pokémon move is used against a Fire pokémon, it would cause two times the normal damage it would cause.

- **Summary Menu** - When we click on the S key, the game displays a summary of the player's current pokémons.
To scroll through the rest of the player's pokemons press up and down arrows.


<p align="center">
  <img width=500 src="images/Pokemon%20Summary.png">
</p>

### Battle

- **HP and Experience Bar** - These bars represent, respectively, the total health percentage of a pokémon in-battle and its experience progress from its current level to the next.

<p float="left" align="middle">
  <img width=350 src="images/HP%20Bar.gif">
  <img width=350 src="images/Experience%20Bar.gif">
</p>

- **Battle Options Menu** - While in-battle the player has four options of what to do.  
    <p align="center">
        <img width=350 src="images/Battle%20Options.gif">
    </p>

    - **Fight** - Make the pokémon use one its moves.
    
    <p align="center">
        <img width=550 src="images/Fight%20Options.gif">
    </p>
        
    - **Bag** - Use a pokeball from the bag. A pokeball is used to catch a pokemon. 
    Pokemons with less HP are easier to catch.
    - **Pokémon** - Swipe pokemon currently fighting for another one on the party (player's pokemons).
    - **Run** - Leave battle without a consequence.
    
- **Basic Battle Features** - Simple explanation of battle mode.

    - The player is always the first to attack.
    - As soon as the player performs an action, it is the other pokemon turn to attack.
    - Attacks might make a lot of damage / almost no damage / no damage at all. It is important, during battles,
    that the player takes notes of what attacks work better according to the types of pokemon in battle since
    effectiveness depends on the type.
    - For the reason stated above, the player must think about when it is better to swap pokemons
    in order to win the battle.
    - The chances of catching a pokemon increase if the HP of the pokemon we are trying to catch is lower.
    With this in mind, the player should try to decrease the HP of the adversary (without killing him) before attempting to catch him.
    - If the player chooses to run from the battle, nothing happens and the player shall appear on the same
    tile it was before entering the battle.
    
    

## Planned features

### Player

- **Movement Animation** - When the player moves in a direction, a walking animation will play.
- **Ability to Run** - When the player presses the Z key while moving, they will start to run.
- **Option to be a Boy or a Girl** - At the start of a new game, the player may chose his character gender (for cosmetic purposes only).

### Pokémon

- **Catch Rate**
- **Leveling Up** - A pokémon's level goes from 1 to 100 and it can level up when it reaches a certain amount of experience, improving its stats.
- **Evolving** - Some pokémon have two or even three different evolutions and if so, they evolve when they reach a certain level.
- **Pokémon PC** - Cure injured pokémons

### Battle

- **Pokémon Moves Animations** - Implement animations for each move.
- **Use Potions** - Make it possible to access the bag and use a potion.

### Other

- **Save the progress**
- **Create profiles** 
- **Create NPCs** - Have NPCs in the overworld whom which the player might interact.

## Architectural Pattern

For easier development of the game, we implemented the MVC (Model–View–Controller) design pattern, with the following division.
- **Model (data)** - Stores all of the lpoo.pokemonascii.data structure of the game and its current state.
- **View (gui)** - Handles the interaction with the user, be it input, by pressing the keyboard's keys, or be it output, by a graphical interface that represents the game.
- **Controller (rules)** - Coordinates and processes all the changes that occur.

<p align="center">
  <img width=350 src="images/MVC.png">
</p>

Our game currently has the MVC implemented in the following modules:

#### World 

Player walks around the world

#### Battle

Two pokémon battle each other

#### Options Menu

For menus where the user has choose some option

## Design

### SoundEffects

#### Problem in Context
In order to add some sound effects to our game, we had to think about the best way to implement this feature without 
risking going against any SOLID principle. This functionality requires that we are able to easily add 
more, and many sound effects without raising the complexity of the game and to make it easy to manage all of this sounds.
Whether we want to remove / add / change / reduce or increase volume, the implementation must provide 
us an effective simple way of rapidly doing all of that.

#### The Pattern
The pattern we decided to use was the **Template pattern**. We created an abstract class 
[SoundEffect](../src/main/java/lpoo/pokemonascii/data/SoundEffects/SoundEffect.java)
whose constructor receives a string. This string is concatenated to the path string which leads
to the folder where all the sound effects are stored as .wav files. When the function
*play()* is called, the class creates a clip retrieving the wav file
and plays it. Each subclass knows the name of the sound effect file it represents, so in their constructor,
they call the *super(name_of_file.wav)*. The rest of the magic is left to the super class. 

This pattern allowed us to do another thing we hadn't thought about which came down to be quite useful. Some sound effects
volume might not be what we wished. Either they were too loud compared to the rest or they were too low.  
To solve this we must apply a volume reduction or increment to specific sound effects, not to every soundeffect.
With this pattern it was easy. Simply, in the sound effect classes we want to change volume, we **override**
the superclass' *play()* method. Then, we are able to still call the superclass *play()* method but still
we are able to add the lines of code we need to control the volume when that sound effect plays.

#### The Implementation

<p align="center">
  <img width=435 src="images/TemplateSoundEffect.png">
</p>

#### Consequences
- Flexibility to change volume of specific sounds.
- Easy to add / remove / change sounds.
- Simple solution easy to understand.
- Only subclasses know which file the sounds correspond to.

### Music

#### Problem in Context

We wanted to add some music to our game so it would even be more similar to the original game. 
We downloaded the correspondent theme songs for both the [world](../data/Music/town.wav) mode and the [battle](../data/Music/battle.wav) mode. However, 
we still had to think about the best way to implement this. 

The problem was that we could not assign 
the task to any class. We could not assign the "DJ" responsability to the battle or the world as we first thought 
since this would add to the responsibilities of those classes. 
We had to make sure we were not going against any *SOLID* principle. 

#### The Pattern

We have applied the **Observer Pattern**. This pattern allows us to make sure a list of observers of 
some class is notified every time its state changes. This was exactly what we wanted. Although the gamemode 
will have only one observer, by doing this we guarantee that the class responsible by the music change will be notified every time the gamemode's state is altered. 
  
In other words, when the game changes states, it notifies its observers. Since the [class Music](../src/main/java/lpoo/pokemonascii/rules/observer/Music.java) will be an observer of [GameState](../src/main/java/lpoo/pokemonascii/rules/state/GameState.java), its update() method is called. As a consequence, the track playing is set accordingly to the state the game is currently in.

#### The Implementation

<p align="center">
  <img width=435 src="images/ObserverPattern.png">
</p>

#### Consequences

- We can establish relations between objects at runtime
- Open/Closed Principle. We can add more observers without changing the GameState code.
- Single Responsabilty Principle. We avoided adding more responsabilities to other classes.

### Gamemode

#### Problem in Context

Our game will often alternate between roaming the overworld and battling with pokémon. When the player finds a pokémon in grass of battles against a NPC they will be prompted to a battle mode and when the battle is over, they return to where they were in the overworld.

In other words, the game will have different gamemodes at each time depending on the actions of the player and this can quickly expand if we think of a main menu or like so. For that purpose, we neeeded a way to manage which was the currently state of the game and switch to it.

<p align="center">
  <img width=350 src="images/Gamemode%20FA.png">
</p>

#### The Pattern

We have applied the **State Pattern**. This pattern suggests that we create new classes for all 
possible states of an object and extract all state-specific behaviors into these classes. Instead of
 implementing all the behavior on its own, the original object [GameState](../src/main/java/lpoo/pokemonascii/rules/state/GameState.java),
 stores a reference to one of the objects that represents its current state, adn delegates all the 
 state-related work to that object.  
 
To transition the context into another state, replace the active state object with another object 
that represents that new state. This is possible since all state classes follow the same 
interface [State](../src/main/java/lpoo/pokemonascii/rules/state/State.java) and the [GameState](../src/main/java/lpoo/pokemonascii/rules/state/GameState.java) 
itself works with these objects through that interface.

#### Implementation

<p align="center">
  <img width=500 src="images/State.png">
</p>

#### Consequences

- We don't have to rely on flags.
- No more complex if.
- More classes.

### Input 

#### Problem in Context

Depending on the currently game state, different keyboard inputs might execute different actions and sometimes we may even want to undo an action that we committed (like going back on a menu for example).  

#### The Pattern

For that purpose, we used the [Command](../src/main/java/lpoo/pokemonascii/rules/commands.java) design pattern.

#### Implementation

<p align="center">
  <img width=550 src="images/Command.png">
</p>

#### Consequences

- Easier to add new actions in an abstract way.

### Graphics

#### Problem in Context

Due to the fact that pokémon games from Gameboy Advance graphics are colorful and complex, we had to adapt them to meet Lanterna's limitations. 

The way we did this was to initially convert a `.png` image to text, using `img2txt`, a program from [libcaca](http://caca.zoy.org/wiki/libcaca). That program generates a `.svg` that we parse and then draw using Lanterna.

We store the parsed image content (such as colors and text characters) in a class `Image` and then we have a class [Sprite](../src/main/java/lpoo/pokemonascii/gui/Sprite.java) that can store multiple `Images`, each one corresponding to a certain state of what the `Sprite` represents, for instance, the `Player` `Sprite` will have an image for each facing direction.  

For each game element we have a [Renderer](../src/main/java/lpoo/pokemonascii/gui/renderers) that is responsible for drawing it in the screen. 

However, some elements of the game have a common general way to draw, but slightly differences between, such as [bars](https://github.com/FEUP-LPOO/lpoo-2020-g40/tree/master/src/main/java/lpoo/pokemonascii/gui/renderers/bar). In battle, we have two distinct types of bars, the [health bar](https://github.com/FEUP-LPOO/lpoo-2020-g40/blob/master/src/main/java/lpoo/pokemonascii/gui/renderers/bar/HealthBarRenderer.java) and the [experience bar](https://github.com/FEUP-LPOO/lpoo-2020-g40/tree/master/src/main/java/lpoo/pokemonascii/gui/renderers/bar/ExperienceBarRenderer.java). 

The way to draw them is the same, we have a percentage and the bar length corresponds to it. Yet, they have different behaviors, the health changes colors according to the health of the pokémon.

#### The Pattern

That being said, we used the **Template Method** pattern to solve this problem. This pattern allowed us to design a general skeleton for the way a bar is rendered, but allowing to slightly adjustments on that process.

#### Implementation

<p align="center">
  <img width=550 src="images/Template%20Method.png">
</p>

**Note:** We greyed out some parts of the diagram and removed some attributes and methods of those parts, because they weren't the focus of this pattern, but were relevant nonetheless.

#### Consequences

- Easier to add new renderers without repeating much code.
- Abstract the overall and focus on the differences.
- Respect SOLID principles.

## Code Smells and Possible Refactorings

#### Dispensables - Data Class

The class [Option](../src/main/java/lpoo/pokemonascii/data/options/Option.java) is an example of a Data class in our code.
 This class only has a string field and both a getter and a setter for accessing it. Removing this class would make the 
 code a little simpler since this class can be replaced by the primitive `String`.
 
#### Dispensables - Lazy Class

The class [Tile](../src/main/java/lpoo/pokemonascii/data/Tile.java) was designed in order to support future 
development work that has not been done yet. Our plan is to be able to create different tiles with distinct purposes 
and methods. However, at the moment, we only have one type of tile, the [Grass](../src/main/java/lpoo/pokemonascii/data/Grass.java) class.
  
Having this class provokes a small increment in the complexity and size of the code. To solve this problem, we could 
use the refactoring method **Collapse Hierarchy** by merging the Tile class with the [CollidingElement](../src/main/java/lpoo/pokemonascii/data/elements/CollidingElement.java) class.

#### Bloaters - Switch Statements

The method getNextCommand() in the [class BattleView](../src/main/java/lpoo/pokemonascii/gui/BattleView.java) has a long
 switch case inside of it. This creates a problem: Every time we want to have a condition we have to find all the switch 
 code and modify it. 
 
Since this *switch* is based on type code, we should use the **Replace Type Code with Subclasses** refactor method. To do this, instead of
using a enum to represent the key type, we should create a subclass **KeyType** and subclasses of KeyType to each value 
of the coded type. Then, extract the relevant behaviours from the original class to these subclasses. Replace the control
 flow code with polymorphism. By doing this we improve code organization.

Also, in the class [Game](../src/main/java/lpoo/pokemonascii/Game.java), 
in the class [BattleController](../src/main/java/lpoo/pokemonascii/rules/BattleController.java) and in the
the class [WorldController](../src/main/java/lpoo/pokemonascii/rules/WorldController.java) we have the use of null in a
if statement where we could appply the refactor method **Introduce Null Object** by creating a subclass that will perform
 the role of a null object, create a method isNull() and replace the code in the correct places.

The [Route6 Class](../src/main/java/lpoo/pokemonascii/data/Route6.java) is another example of the strong use of switch
statements. The whole class is a group of functions full of switch statements. This class represents the
only map of the game. The map is made of 4 zones. For each zones there are different elements. For
that reason, we use the switch cases as a resource to define the elements for each case. 

This situation could be changed using the same refactor mentioned before. We would create subclasses,
one for called Zone and subclasses of Zone. By doing this, we would be able to easily define the different
behaviours for each zone without getting the help of switch cases.


#### Change Preventers - Parallel Inheritance

Whenever we create a subclass for [Option class](../src/main/java/lpoo/pokemonascii/data/options/Option.java), 
we find ourselves needing to create a 
subclass for the [Menu class](../src/main/java/lpoo/pokemonascii/gui/renderers/menu/OptionsMenuRenderer.java).
This happens because we need a class which knows how to render the option we created. So, as new
 classes are added, making changes becomes harder and harder.

This code smell is called **Parallel Inheritance**. The solution for it would be to collapse 
 a hierarchy so we would have only a generec renderer which would be easier to mantain.

## Testing

<p align="center">
  <img width=550 src="images/coverage.png">
</p>

[Link to Mutation Report](./index.html)

## Self-Evaluation

- Ana Inês Barros: 50%
- Eduardo Correia: 50%

## Game Resources

### Images

- [Pokémon - Battle](https://veekun.com/dex/downloads), veekun
- [HP Bars & In-Battle Menu](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/33690/), redblueyellow
- [Battle Backgrounds](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/3866/), Desgardes
- [Pokémon Summary Menu](https://www.spriters-resource.com/game_boy_advance/pokemonfireredleafgreen/sheet/112720/), Pnick0509

### Data Files

- [Pokémon](https://github.com/r4vi/zipper-demo/blob/master/resources/pokemon.xml), r4v1
- [Pokémon Moves](https://github.com/veekun/pokedex/blob/master/pokedex/lpoo.pokemonascii.data/csv/moves.csv), veekun
