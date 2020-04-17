package lpoo.pokemonascii.pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PokemonSpecies {
    private int pokedex_number;
    private PokemonType primary_type;
    private PokemonType secondary_type;

    public PokemonSpecies(int pokedex_number) throws FileNotFoundException {
        // Parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("data"));
        sc.useDelimiter(","); // We're reading from a CSV
        while (sc.hasNext()) {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
        }

        sc.close();  //closes the scanner
    }
}
