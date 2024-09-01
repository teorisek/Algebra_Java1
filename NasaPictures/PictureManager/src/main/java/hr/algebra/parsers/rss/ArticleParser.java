/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.parsers.rss;

import hr.algebra.factory.ParserFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.Article;
import hr.algebra.utilities.FileUtils;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author trisek
 */
public class ArticleParser {

    private static final String RSS_URL = "https://photojournal.jpl.nasa.gov/rss/targetFamily/Earth";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    public static List<Article> parse() throws IOException, XMLStreamException, MalformedURLException, URISyntaxException {
        List<Article> articles = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        try (InputStream is = con.getInputStream()) { // stream will close the connection
            XMLEventReader reader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            Article article = null;
            StartElement startElement = null;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT -> {
                        startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        tagType = TagType.from(qName);
                        // put breakpoint here
                        if (tagType.isPresent() && tagType.get().equals(TagType.ITEM)) {
                            article = new Article();
                            articles.add(article);
                        }
                    }
                    case XMLStreamConstants.CHARACTERS -> {
                        if (tagType.isPresent() && article != null) {
                            Characters characters = event.asCharacters();
                            String data = characters.getData().trim();
                            switch (tagType.get()) {
                                case TITLE -> {
                                    if (!data.isEmpty()) {
                                        article.setTitle(data);
                                    }
                                }
                                case LINK -> {
                                    if (!data.isEmpty()) {
                                        article.setLink(data);
                                    }
                                }
                                case DESCRIPTION -> {
                                    if (!data.isEmpty()) {
                                        article.setDescription(data);
                                    }
                                }
                                case IMAGE -> {
                                    if (startElement != null && article.getPicturePath() == null) {
                                        String urlAttribute = data;
                                        if (urlAttribute != null) {
                                            handlePicture(article, urlAttribute);
                                        }
                                    }
                                }
                                case CATEGORY -> {
                                    if (!data.isEmpty()) {
                                        article.setCategory(data);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return articles;

    }

    private static void handlePicture(Article article, String pictureUrl) throws MalformedURLException, URISyntaxException {
        // if picture is not ok, we must continue!!!
        try {
            String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
            if (ext.length() > 4) {
                ext = EXT;
            }
            String pictureName = UUID.randomUUID() + ext;
            String localPicturePath = DIR + File.separator + pictureName;

            FileUtils.copyFromUrl(pictureUrl, localPicturePath);
            System.out.println(localPicturePath);
            System.out.println(pictureUrl);
            
            // put breakpoint
            article.setPicturePath(localPicturePath);
        } catch (IOException ex) {
            Logger.getLogger(ArticleParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private enum TagType {

        ITEM("item"),
        TITLE("titleText"),
        LINK("link"),
        DESCRIPTION("descriptionText"),
        IMAGE("hiresJpeg"),
        CATEGORY("category");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }

}
