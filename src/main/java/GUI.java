import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
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

public class GUI {
    private Screen screen;
    private TextGraphics graphics;

    public GUI() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        graphics = screen.newTextGraphics();
    }

    void drawPokemon(Integer pokemonNumber) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the Document class.
        Document document = builder.parse(new File("data\\pokemons\\" + pokemonNumber.toString() + ".svg"));

        NodeList nodeList = document.getDocumentElement().getElementsByTagName("g").item(0).getChildNodes();

        // Read the XML document
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                Integer x = Integer.parseInt(elem.getAttributes().getNamedItem("x").getNodeValue()) / 6;
                Integer y = Integer.parseInt(elem.getAttributes().getNamedItem("y").getNodeValue()) / 10;
                String color = elem.getAttributes().getNamedItem("style").getNodeValue().substring(6);

                color = color.substring(0, 1) + color.substring(0, 1) +
                        color.substring(1, 2) + color.substring(1, 2) +
                        color.substring(2, 3) + color.substring(2, 3);

                graphics.setForegroundColor(TextColor.Factory.fromString("#" + color));

                if (node.getNodeName().equals("rect"))
                    graphics.putString(x, y, "\u2588");

                else if (node.getNodeName().equals("text")) {
                    try {
                        graphics.setBackgroundColor(graphics.getCharacter(x, y).getForegroundColor());
                    }

                    catch (Exception ignore) {

                    }

                    String character = elem.getTextContent();

                    graphics.putString(x, y, character);
                }
            }
        }

        screen.refresh();
    }
}
