package greedy;

import java.util.Arrays;

public class Video_Stitching_1024 {

  public static void main(String[] args) {
    int[][] clips = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
    videoStitching(clips, 10);
  }

  public static int videoStitching(int[][] clips, int time) {

    Arrays.sort(clips, (o1, o2) -> {
      int diff_0 = o1[0] - o2[0];
      int diff_1 = o2[1] - o1[1];
      return (diff_0 == 0 ? diff_1 : diff_0);
    });
    int totalStart = 0;
    int totalEnd = 0;
    int count = 0;
    for (int i = 0; i < clips.length; i++) {
      int[] clip = clips[i];
      int clip_start = clip[0];
      int clip_end = clip[1];

      if (totalStart <= clip[0]) {

      }
    }

    return count;
  }

}
