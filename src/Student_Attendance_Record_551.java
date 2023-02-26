public class Student_Attendance_Record_551 {

  public boolean checkRecord(String s) {
    char[] chars = s.toCharArray();
    int consecutiveLeaveCount = 0;
    int totalAbsent = 0;
    if (chars.length < 2)
      return true;

    for (char currentChar : chars) {
      if (currentChar == 'L') {
        consecutiveLeaveCount++;
      } else if (currentChar == 'A') {
        consecutiveLeaveCount = 0;
        totalAbsent++;
      } else {
        consecutiveLeaveCount = 0;
      }
      if (consecutiveLeaveCount >= 3 || totalAbsent >= 1)
        return false;
    }
    return true;
  }
}
