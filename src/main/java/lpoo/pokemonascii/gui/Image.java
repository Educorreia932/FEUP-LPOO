package lpoo.pokemonascii.gui;

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

public class Image {
    private static final String IMAGES_PATH = "images\\";

    private int width;
    private int height;
    private String[][] background_colors;
    private String[][] foreground_colors;
    private String[][] characters;
    private final int X_WIDTH = 6;
    private final int Y_WIDTH = 10;

    public Image(String filename) {
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
            document = builder.parse(new File(IMAGES_PATH + filename + ".svg"));
        }

        catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        Element svg = document.getDocumentElement();
        this.width = Integer.parseInt(svg.getAttributes().getNamedItem("width").getNodeValue()) / X_WIDTH;
        this.height = Integer.parseInt(svg.getAttributes().getNamedItem("height").getNodeValue()) / Y_WIDTH;

        Node g = document.getDocumentElement().getElementsByTagName("g").item(0);
        NodeList nodeList = g.getChildNodes();

        background_colors = new String[height][width];
        foreground_colors = new String[height][width];
        characters = new String[height][width];

        // Read the XML document
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                int x = Integer.parseInt(elem.getAttributes().getNamedItem("x").getNodeValue()) / X_WIDTH;
                int y = Integer.parseInt(elem.getAttributes().getNamedItem("y").getNodeValue()) / Y_WIDTH;
                String color = elem.getAttributes().getNamedItem("style").getNodeValue().substring(6);

                color = "#" + shortToLongHex(color);
                characters[y][x] = " ";

                if (node.getNodeName().equals("rect"))
                    background_colors[y][x] = color;

                else if (node.getNodeName().equals("text")) {
                    foreground_colors[y][x] = color;
                    characters[y][x] = elem.getTextContent();
                }
            }
        }
    }

    // Converts an hexadecimal in format #000 to #000000
    private String shortToLongHex(String short_hex) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 3; i++)
            result.append(short_hex.substring(i, i + 1).repeat(2));

        return result.toString();
    }

    // ------------------- Getters -------------------
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getBackground_colors() {
        return background_colors;
    }

    public String[][] getForeground_colors() {
        return foreground_colors;
    }

    public String[][] getCharacters() {
        return characters;
    }
}
