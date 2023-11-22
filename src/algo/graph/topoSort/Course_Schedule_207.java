package algo.graph.topoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Course_Schedule_207 {

  /**
   * https://www.youtube.com/watch?v=cIBFEhD77b4
   * https://www.youtube.com/watch?v=73sneFXuTEg
   * Kahn's Algorithm
   * <p>
   * 1--->2--->3--->1
   * [[1,0] [2,1], [3,2], [4,3] , [5,4]]
   */

  public static void main(String[] args) {
    int[][] input = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.err.println(findOrder(4, input));
  }

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] prequisiteCount = new int[numCourses];//incoming
    List<Integer>[] graph = new List[numCourses];// outgoing to incomgin map.
    for (int i = 0; i < prerequisites.length; i++) {
      int from = prerequisites[i][1];//first finish this
      int to = prerequisites[i][0];// second finish this
      prequisiteCount[to]++;
      if (graph[from] == null) graph[from] = new ArrayList();
      graph[from].add(to);
    }

    Deque<Integer> deque = new ArrayDeque();
    for (int i = 0; i < prequisiteCount.length; i++) {
      if (prequisiteCount[i] == 0) {
        deque.offer(i);
      }
    }
    List<Integer> sequence = new ArrayList();
    while (deque.size() > 0) {
      int nodeWithNoIncoming = deque.poll();
      System.err.println("nodeWithNoIncoming=" + nodeWithNoIncoming);
      sequence.add(nodeWithNoIncoming);// free nodes with no dependency/incoming

      List<Integer> dependentCourseList = graph[nodeWithNoIncoming];
      if (dependentCourseList != null && dependentCourseList.size() > 0) {
        for (int dependentCourse : dependentCourseList) {
          prequisiteCount[dependentCourse]--;
          if (prequisiteCount[dependentCourse] == 0) {
            deque.offer(dependentCourse);
          }
        }
      }
    }
    if (sequence.size() == numCourses) {
      int[] res = new int[numCourses];
      for (int i = 0; i < numCourses; i++)
        res[i] = sequence.get(i);
      return res;
    }
    return new int[0];

  }

  public boolean canFinish_Kahns_sol1_working_perfect(int numCourses, int[][] prerequisites) {
    int[] inDegreeCount = new int[numCourses];
    List[] outDegreeCourses = new List[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      int[] prerequisite = prerequisites[i];
      int to = prerequisite[0];// Second can finish this course after [1].
      int from = prerequisite[1];//First finish this course to complete [0]
      inDegreeCount[to]++;
      if (outDegreeCourses[from] == null) outDegreeCourses[from] = new ArrayList();
      outDegreeCourses[from].add(to);
    }
    Deque<Integer> deque = new ArrayDeque<>();
    for (int j = 0; j < numCourses; j++) {
      if (inDegreeCount[j] == 0)
        deque.offer(j);
    }

    List<Integer> orderOfCourses = new ArrayList<>();

    while (deque.size() > 0) {
      Integer noIndegreeCourseNum = deque.poll();
      orderOfCourses.add(noIndegreeCourseNum);
      if (outDegreeCourses[noIndegreeCourseNum] != null && outDegreeCourses[noIndegreeCourseNum].size() > 0) {
        List<Integer> outDegreeCourses1 = outDegreeCourses[noIndegreeCourseNum];
        for (int outDegreeCourse : outDegreeCourses1) {
          inDegreeCount[outDegreeCourse]--;
          if (inDegreeCount[outDegreeCourse] == 0)
            deque.offer(outDegreeCourse);
        }
        outDegreeCourses[noIndegreeCourseNum] = null;
      }
    }

    return orderOfCourses.size() == numCourses;
  }
}
