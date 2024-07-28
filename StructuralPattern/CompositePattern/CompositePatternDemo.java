import java.util.List;
import java.util.ArrayList;
interface File {
    void display();
}

class FileImpl implements File {
    private String name;

    public FileImpl(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

class Directory implements File {
    private String name;
    private List<File> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (File file : files) {
            file.display();
        }
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory user = new Directory("User");
        Directory documents = new Directory("Documents");
        File file1 = new FileImpl("file1.txt");
        File file2 = new FileImpl("file2.doc");

        user.addFile(file1);
        user.addFile(file2);
        root.addFile(user);
        root.addFile(documents);

        root.display();
    }
}


