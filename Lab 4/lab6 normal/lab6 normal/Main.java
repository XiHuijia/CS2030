import java.util.Scanner;
import java.util.ArrayList;

public class Main {

public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);
  int size = sc.nextInt();
  //ArrayList<Roster> roster = new ArrayList<Roster>();
  Roster roster = new Roster("test");
  for (int i = 0; i < size; i = i + 1) {
//      for(int j = 0; j < 4; j = j + 1) {
          String name = sc.next();
          String code = sc.next();
          String assess = sc.next();
          String grade = sc.next();

          if (roster.get(name) == null) {

                        Assessment assessment = new Assessment(assess, grade);
                  Module module = new Module(code).put(assessment);
              Student student = new Student(name).put(new Module(code).put(assessment));
              roster.put(student);
          } else if (roster.get(name).get(code) == null) {
              Assessment assessment = new Assessment(assess, grade);
              Module module = new Module(code).put(assessment);
              roster.get(name).put(module);
          } else if (roster.get(name).get(code).get(assess) == null) {
              Assessment assessment = new Assessment(assess, grade);
              roster.get(name).get(code).put(assessment);
          }
//          if(roster.get(name) != null && roster.get(name).get(code) != null) {
//              roster.get(name).get(code).put(new Assessment(assess, grade));
//          } else if (roster.get(name).get(code) != null) {
//
//          }
//          Assessment assessment = new Assessment(assess, grade);
          //    Module module = new Module(code).put(assessment);
  //        Student student = new Student(name).put(new Module(code).put(assessment));
//      student.put(module).put(assessment);
//      Roster rost = new Roster("test");
//      rost.put(student);
  //        roster.put(student);

          //  System.out.println(roster.getGrade(name, code, assess));
//      }
//
//      try {
//          System.out.println(roster.getGrade(name, code, assess));
//      } catch (NoSuchRecordException e) {
//          System.out.println("No such record: " + name + " " + code + " " + assess);
//      }
    }

  while(sc.hasNext()) {
      String name = sc.next();
      String code = sc.next();
      String assess = sc.next();
     // System.out.println(name);
      try {
//          System.out.println(roster.get(name));
//          System.out.println(roster.get(name).get(code).get(assess));
          System.out.println(roster.getGrade(name, code, assess));
      } catch (NoSuchRecordException e) {
         System.out.println("NoSuchRecordException: No such record: " + name + " " + code + " " + assess);
      }
  }
  }

  }
