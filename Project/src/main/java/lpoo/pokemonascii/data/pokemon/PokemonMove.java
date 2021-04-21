package lpoo.pokemonascii.data.pokemon;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class PokemonMove {
    private String name;
    private int power;
    private int totalPP;
    private int currentPP;
    private int accuracy;
    private PokemonType type;

    public PokemonMove(String name) throws IOException, SAXException, ParserConfigurationException {
        this.name = name;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the Document class.
        Document document;

        document = builder.parse(new File("data/xml/moves" + File.separator  + name + ".xml"));

        NodeList nodeList = document.getChildNodes();

        // Read the XML document
        Node node = nodeList.item(0);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) node;

            // Type
            type = new PokemonType(elem.getElementsByTagName("type").item(0).getTextContent());

            // Power
            try {
                power = Integer.parseInt(elem.getElementsByTagName("power").item(0).getTextContent());
            }

            catch (NumberFormatException e) {
                power = 0;
            }

            // PP
            totalPP = Integer.parseInt(elem.getElementsByTagName("pp").item(0).getTextContent());
            currentPP = totalPP;

            // Accuracy
            try {
                accuracy = Integer.parseInt(elem.getElementsByTagName("accuracy").item(0).getTextContent());
            }

            catch (NumberFormatException e) {
                accuracy = 100;
            }
        }
    }

    public PokemonMove() {
        this.name = "-";
    }

    public void execute(Pokemon pokemon) {
        if (pokemon.getSpecies().getSecondaryType() != null)
            pokemon.takeDamage((int) (type.getDamageMultiplier(pokemon.getSpecies().getPrimaryType()) *
                                  type.getDamageMultiplier(pokemon.getSpecies().getSecondaryType()) *
                                  power));

        else
            pokemon.takeDamage((int) (type.getDamageMultiplier(pokemon.getSpecies().getPrimaryType()) * power));

        currentPP--;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public int getTotalPP() {
        return totalPP;
    }

    public int getCurrentPP() {
        return currentPP;
    }

    public PokemonType getType() {
        return type;
    }
}
