package model;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {
    private static final String FILE_PATH = "books.xml";

    // Đọc danh sách sách từ XML
    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return books;

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                books.add(new Book(
                        element.getElementsByTagName("title").item(0).getTextContent(),
                        element.getElementsByTagName("author").item(0).getTextContent(),
                        Integer.parseInt(element.getElementsByTagName("year").item(0).getTextContent()),
                        element.getElementsByTagName("publisher").item(0).getTextContent(),
                        Integer.parseInt(element.getElementsByTagName("pages").item(0).getTextContent()),
                        element.getElementsByTagName("genre").item(0).getTextContent(),
                        Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent()),
                        element.getElementsByTagName("isbn").item(0).getTextContent()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    // Thêm sách mới vào XML
    public static void addBook(Book book) {
        try {
            File file = new File(FILE_PATH);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc;
            Element root;

            if (file.exists()) {
                doc = builder.parse(file);
                root = doc.getDocumentElement();
            } else {
                doc = builder.newDocument();
                root = doc.createElement("books");
                doc.appendChild(root);
            }

            Element bookElement = doc.createElement("book");
            root.appendChild(bookElement);

            createElement(doc, bookElement, "title", book.getTitle());
            createElement(doc, bookElement, "author", book.getAuthor());
            createElement(doc, bookElement, "year", String.valueOf(book.getYear()));
            createElement(doc, bookElement, "publisher", book.getPublisher());
            createElement(doc, bookElement, "pages", String.valueOf(book.getPages()));
            createElement(doc, bookElement, "genre", book.getGenre());
            createElement(doc, bookElement, "price", String.valueOf(book.getPrice()));
            createElement(doc, bookElement, "isbn", book.getIsbn());

            saveXML(doc, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createElement(Document doc, Element parent, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        parent.appendChild(element);
    }

    private static void saveXML(Document doc, File file) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(file));
    }
}
