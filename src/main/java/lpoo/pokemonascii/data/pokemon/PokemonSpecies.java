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
import java.util.ArrayList;
import java.util.List;

public class PokemonSpecies {
    private int pokedexNumber;
    private String name;
    private PokemonType primary_type;
    private PokemonType secondary_type;
    private PokemonStats base_stats;

    public PokemonSpecies(int pokedexNumber) throws IOException, SAXException {
        this.pokedexNumber = pokedexNumber;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
        }

        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // Load the input XML document, parse it and return an instance of the Document class.
        Document document = null;

        document = builder.parse(new File("data\\" + pokedexNumber + ".xml"));

        NodeList nodeList = document.getChildNodes();

        // Read the XML document
        Node node = nodeList.item(0);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) node;

            // Name
            name = elem.getElementsByTagName("name").item(0).getTextContent();

            // Primary type and secondary, if the pokémon as one
            primary_type = new PokemonType(elem.getElementsByTagName("type").item(0).getTextContent().toUpperCase());

            if (elem.getElementsByTagName("type").item(1) != null) // TODO: Introduce NULL object
                secondary_type = new PokemonType(elem.getElementsByTagName("type").item(1).getTextContent().toUpperCase());

            // Stats
            NodeList statsNodes = elem.getElementsByTagName("stats").item(0).getChildNodes();
            List<Integer> stats = new ArrayList<>();

            for (int i = 0; i < statsNodes.getLength(); i++) {
                Node statNode = statsNodes.item(i);

                if (statNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element nodeElement = (Element) statNode;
                    stats.add(Integer.parseInt(nodeElement.getTextContent()));
                }
            }

            base_stats = new PokemonStats(stats);
        }
    }

    public String getName() {
        return name;
    }

    public PokemonType getPrimaryType() {
        return primary_type;
    }

    public PokemonType getSecondaryType() {
        return secondary_type;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }
}
