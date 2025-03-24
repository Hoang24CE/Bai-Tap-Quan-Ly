import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class StudentXMLManager {
    private static final String FILE_NAME = "students.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- QUẢN LÝ SINH VIÊN XML ---");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Xóa sinh viên theo ID");
            System.out.println("4. Cập nhật thông tin sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    updateStudent(scanner);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }

    // Thêm sinh viên vào XML
    private static void addStudent(Scanner scanner) {
        try {
            File file = new File(FILE_NAME);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            Element rootElement;

            if (file.exists()) {
                doc = builder.parse(file);
                rootElement = doc.getDocumentElement();
            } else {
                doc = builder.newDocument();
                rootElement = doc.createElement("students");
                doc.appendChild(rootElement);
            }

            System.out.print("Nhập ID: ");
            String id = scanner.nextLine();
            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();
            System.out.print("Nhập tuổi: ");
            String age = scanner.nextLine();
            System.out.print("Nhập ngành học: ");
            String major = scanner.nextLine();

            Element student = doc.createElement("student");
            student.setAttribute("id", id);

            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));
            student.appendChild(nameElement);

            Element ageElement = doc.createElement("age");
            ageElement.appendChild(doc.createTextNode(age));
            student.appendChild(ageElement);

            Element majorElement = doc.createElement("major");
            majorElement.appendChild(doc.createTextNode(major));
            student.appendChild(majorElement);

            rootElement.appendChild(student);
            saveXML(doc);
            System.out.println("Thêm sinh viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hiển thị danh sách sinh viên
    private static void displayStudents() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File XML chưa tồn tại!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList studentList = doc.getElementsByTagName("student");

            System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
            for (int i = 0; i < studentList.getLength(); i++) {
                Node node = studentList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element student = (Element) node;
                    System.out.println("ID: " + student.getAttribute("id"));
                    System.out.println("Tên: " + student.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Tuổi: " + student.getElementsByTagName("age").item(0).getTextContent());
                    System.out.println("Ngành: " + student.getElementsByTagName("major").item(0).getTextContent());
                    System.out.println("----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa sinh viên theo ID
    private static void deleteStudent(Scanner scanner) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File XML không tồn tại!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            System.out.print("Nhập ID sinh viên cần xóa: ");
            String idToDelete = scanner.nextLine();

            NodeList studentList = doc.getElementsByTagName("student.xml");
            boolean found = false;

            for (int i = 0; i < studentList.getLength(); i++) {
                Element student = (Element) studentList.item(i);
                if (student.getAttribute("id").equals(idToDelete)) {
                    student.getParentNode().removeChild(student);
                    found = true;
                    break;
                }
            }

            if (found) {
                saveXML(doc);
                System.out.println("Xóa sinh viên thành công!");
            } else {
                System.out.println("Không tìm thấy sinh viên với ID: " + idToDelete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin sinh viên theo ID
    private static void updateStudent(Scanner scanner) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File XML không tồn tại!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            System.out.print("Nhập ID sinh viên cần cập nhật: ");
            String idToUpdate = scanner.nextLine();

            NodeList studentList = doc.getElementsByTagName("student");
            boolean found = false;

            for (int i = 0; i < studentList.getLength(); i++) {
                Element student = (Element) studentList.item(i);
                if (student.getAttribute("id").equals(idToUpdate)) {
                    System.out.print("Nhập tên mới: ");
                    student.getElementsByTagName("name").item(0).setTextContent(scanner.nextLine());
                    System.out.print("Nhập tuổi mới: ");
                    student.getElementsByTagName("age").item(0).setTextContent(scanner.nextLine());
                    System.out.print("Nhập ngành mới: ");
                    student.getElementsByTagName("major").item(0).setTextContent(scanner.nextLine());
                    found = true;
                    break;
                }
            }

            if (found) {
                saveXML(doc);
                System.out.println("Cập nhật sinh viên thành công!");
            } else {
                System.out.println("Không tìm thấy sinh viên với ID: " + idToUpdate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lưu thay đổi vào file XML
    private static void saveXML(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_NAME));
        transformer.transform(source, result);
    }
}
