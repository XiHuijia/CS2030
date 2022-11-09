import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Roster roster = new Roster("level6");

        for (int i = 0; i < num; i++) {
            String name = sc.next();
            String module = sc.next();
            String assessment = sc.next();
            String grade = sc.next();

            Assessment a = new Assessment(assessment, grade);
            Module m = new Module(module).put(a);
            Student s = new Student(name).put(new Module(module).put(a));

            roster.get(name).ifPresentOrElse(
                x -> {
                    x.get(module).ifPresentOrElse(
                        y -> {
                            y.put(a);
                        },() -> new Module(module).put(a));
                }, () -> roster.put(s));
        }

        while (sc.hasNext()) {
            String name = sc.next();
            String module = sc.next();
            String assessment = sc.next();
            System.out.println(roster.getGrade(name, module, assessment));
        }
    }
}
