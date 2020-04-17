package lpoo.pokemonascii.pokemon;

import lpoo.pokemonascii.gui.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PokemonSpecies {
    private String name;
    private int pokedex_number;
    private Image image;
    private PokemonType primary_type;
    private PokemonType secondary_type;

    public PokemonSpecies(int pokedex_number) throws FileNotFoundException {
        // Parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("data\\pokemon.csv"));

        while (sc.hasNext()) {
            String[] line = sc.next().split(",", 3);

            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        if (line[0].equals(Integer.toString(pokedex_number)))
                            name = line[1];

                        break;
                    case 2:
                        break;
                }
            }
        }

        sc.close();  //closes the scanner

        image = new Image("pokemon\\back\\" + pokedex_number);
    }

    public Image getImage() {
        return image;
    }
}
