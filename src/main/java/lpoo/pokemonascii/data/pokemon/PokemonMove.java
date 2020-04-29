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
    private int pp;
    private int accuracy;
    private PokemonType type;

    public PokemonMove(String name) throws IOException, SAXException, ParserConfigurationException {
        this.name = name;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the Document class.
        Document document;

        document = builder.parse(new File("data\\moves\\" + name + ".xml"));

        NodeList nodeList = document.getChildNodes();

        // Read the XML document
        Node node = nodeList.item(0);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) node;

            // Type
            type = new PokemonType(elem.getElementsByTagName("type").item(0).getTextContent());

            // Power
            power = Integer.parseInt(elem.getElementsByTagName("power").item(0).getTextContent());

            // PP
            pp = Integer.parseInt(elem.getElementsByTagName("pp").item(0).getTextContent());

            // Accuracy
            accuracy = Integer.parseInt(elem.getElementsByTagName("accuracy").item(0).getTextContent());
        }
    }

    public void execute(Pokemon pokemon) {
        pokemon.takeDamage((int) (type.getDamageMultiplier(pokemon.getSpecies().getPrimaryType())* power));
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }
}
