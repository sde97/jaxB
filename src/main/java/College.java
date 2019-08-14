import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class College {
    private List<Student> s;

    public College() {
    }

    public College(List<Student> s) {
        this.s = s;
    }

    public List<Student> getS() {
        return s;
    }

    public void setS(List<Student> s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "College{" +
                "s=" + s +
                '}';
    }
}
