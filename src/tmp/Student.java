package tmp;

public class Student {
  private int id;
  private String fName;
  private String lName;
  private int yearOfBirth;
  private String addharCard;

  public Student() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getfName() {
    return fName;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public String getFullName() {
    return "Mr. " + fName + " " + lName;
  }

}