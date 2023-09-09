package interval_merging;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/video-stitching/discuss/269988/C%2B%2BJava-6-lines-O(n-log-n)
public class Video_Stitching_1024 {

  public static void main(String[] args) throws InterruptedException {
    Video_Stitching_1024 obj = new Video_Stitching_1024();
    int time = 9;
    int[][] clips = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};//3


    clips = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};//3
    time = 10;

    clips = new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 8}};//-1
    time = 8;
    System.out.println("Ans= " + obj.videoStitching(clips, time));
  }

  /**
   * 0-3
   * 0-6
   * 1-5
   * 1-7
   * 1-9
   * 3-11
   * 4-9
   * 5-13
   * 14-14
   * 10-13
   */

  public int videoStitching(int[][] clips, int time) {
    sort(clips);
    int l = clips.length;
    int ans = 0;
    int timeCovered = 0;
    int currentClipIndex = 0;

    while (currentClipIndex < l) {
      int nextClipIndex = 0;
      System.out.println("Initital- currentClipIndex= " + currentClipIndex + " , timeCovered= " + timeCovered + ", nextClipIndex= " + nextClipIndex);
      FOR:
      for (; currentClipIndex < l; currentClipIndex++) {
        if (clips[currentClipIndex][0] > timeCovered) break FOR;
        nextClipIndex = clips[currentClipIndex][1] >= clips[nextClipIndex][1] ? currentClipIndex : nextClipIndex;
      }
      int newTimeCovered = clips[nextClipIndex][1];
      System.out.println("---- currentClipIndex= " + currentClipIndex + " , timeCovered= " + timeCovered + ", nextClipIndex= " + nextClipIndex + ", newTimeCovered=" + newTimeCovered);
      ans++;// Take a new step
      if (newTimeCovered <= timeCovered) return -1;
      if (newTimeCovered >= time) return ans;
      timeCovered = newTimeCovered;
    }

    System.out.println("timeCovered= " + timeCovered);
    return timeCovered < time ? -1 : ans;
  }

  private void sort(int[][] clips) {
    Arrays.sort(clips, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0])
          return o1[1] - o2[1];
        return o1[0] - o2[0];
      }
    });

    for (int i = 0; i < clips.length; i++) {
      int[] clip = clips[i];
      System.out.print("{" + clip[0] + "," + clip[1] + "} ");
    }
    System.out.println("");
  }
}
