package lpoo.pokemonascii.pokemon;

import lpoo.pokemonascii.gui.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PokemonSpecies {
    private int pokedex_number;
    private PokemonType primary_type;
    private PokemonType secondary_type;
    private PokemonStats base_stats;

    public PokemonSpecies(int pokedex_number) throws FileNotFoundException {
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

        try {
            document = builder.parse(new File("data\\" + pokedex_number + ".xml"));
        }

        catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        // Read the XML document
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

            }
        }
    }
}
