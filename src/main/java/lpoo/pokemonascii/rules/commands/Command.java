package lpoo.pokemonascii.rules.commands;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Command {
    void execute() throws IOException, SAXException, ParserConfigurationException;
}
