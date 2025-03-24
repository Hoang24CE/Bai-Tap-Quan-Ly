import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadComplexXML {
    public static void main(String[] args) {
        try {
            // Đọc file XML
            File xmlFile = new File("C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap XML\\B2\\src\\company.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Lấy danh sách các phần tử <employee>
            NodeList employeeList = doc.getElementsByTagName("employee");

            // Duyệt danh sách nhân viên
            for (int i = 0; i < employeeList.getLength(); i++) {
                Node empNode = employeeList.item(i);

                if (empNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element empElement = (Element) empNode;

                    // Lấy thông tin cơ bản của nhân viên
                    String id = empElement.getAttribute("id");
                    String name = empElement.getElementsByTagName("name").item(0).getTextContent();

                    // Lấy thông tin liên hệ
                    Element contactElement = (Element) empElement.getElementsByTagName("contact").item(0);
                    String email = contactElement.getElementsByTagName("email").item(0).getTextContent();
                    String phone = contactElement.getElementsByTagName("phone").item(0).getTextContent();

                    // Lấy thông tin phòng ban
                    Element deptElement = (Element) empElement.getElementsByTagName("department").item(0);
                    String deptName = deptElement.getElementsByTagName("name").item(0).getTextContent();
                    String location = deptElement.getElementsByTagName("location").item(0).getTextContent();

                    // Hiển thị thông tin ra màn hình
                    System.out.println("ID: " + id);
                    System.out.println("Tên: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("Số điện thoại: " + phone);
                    System.out.println("Phòng ban: " + deptName);
                    System.out.println("Vị trí: " + location);
                    System.out.println("---------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
