import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer,User> h=new HashMap<>();
        User u1=new User(1,"yue");
        User u2=new User(1,"meng");
        h.put(u1.getId(),u1);
        h.put(u2.getId(),u2);
        Collection<User> users=h.values();
        for(User u:users){
            System.out.println(u.toString());
        }
    }
}

class User{
    private Integer id;
    private String name;
    private Integer age;
    private String company;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
