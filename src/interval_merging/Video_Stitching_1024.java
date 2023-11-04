package interval_merging;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/video-stitching/discuss/269988/C%2B%2BJava-6-lines-O(n-log-n)
public class Video_Stitching_1024 {

  public static void main(String[] args) throws Exception {
    Video_Stitching_1024 obj = new Video_Stitching_1024();
    int time = 9;
    int[][] clips = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};//3
    clips = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};//3
    time = 10;
    System.out.println("Ans1= " + obj.videoStitching(clips, time));
    clips = new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 8}};//-1
    time = 8;
    System.out.println("Ans2= " + obj.videoStitching(clips, time));
  }

  public int videoStitching(int[][] clips, int time)  {
    return sorting_solution2(clips, time);
  }

  //Solution #2
  public int sorting_solution2(int[][] clips, int time)  {
    // Generic sorting solution
    Arrays.sort(clips, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0])
          return o2[1] - o1[1];
        return o1[0] - o2[0];
      }
    });
    int clip_i = 0;
    int l = clips.length;
    int ans = 0;
    int clipTimeCovered = 0;
    while (clip_i < l) {
      int[] clip = clips[clip_i];
      int start = clip[0];
      int end = clip[1];
      System.out.println("clip_i=" + clip_i + ", start=" + start + ", end=" + end + ", clipTimeCovered=" + clipTimeCovered);
      int nextClipIndex = getNextClipIndex(clips, clip_i, clipTimeCovered);
      System.out.println("nextClipIndex=" + nextClipIndex);
      if (nextClipIndex < 0) return -1;
      clip_i = nextClipIndex;
      ans++;
      int[] nextClip = clips[nextClipIndex];
      int nextClip_end = nextClip[1];
      clipTimeCovered = nextClip_end;
      if (clipTimeCovered >= time) return ans;
    }
    return -1;
  }

  public int getNextClipIndex(int[][] clips, int startIndx, int clipStartTime) {
    int l = clips.length;
    int indxSelected = -1;
    int clipTimeCanBeCovered = clipStartTime;
    for (int clip_i = startIndx; clip_i < l; clip_i++) {
      int[] clip = clips[clip_i];
      int start = clip[0];
      int end = clip[1];
      if (start > clipStartTime) {
        return indxSelected;
      }
      if (end > clipTimeCanBeCovered) {
        indxSelected = clip_i;
        clipTimeCanBeCovered = end;
      }
    }
    return indxSelected;
  }


  //Solution #1
  public int jump_game_ii_style_sol(int[][] clips, int time) {
    // Jump Game II kind of solution
    int l = clips.length;
    int[] maxClipLength = new int[time + 1];

    for (int i = 0; i < l; i++) {
      int[] clip = clips[i];
      int start = clip[0];
      int end = clip[1];
      if (start > time) continue;
      maxClipLength[start] = Math.max(maxClipLength[start], end);
    }
    int currentLengthCovered = 0;
    int nextLengthToChoose = 0;
    int ans = 0;

    for (int i = 0; i <= time; i++) {
      int clipLength = maxClipLength[i];
      nextLengthToChoose = Math.max(nextLengthToChoose, clipLength);
      if (i == currentLengthCovered) {
        currentLengthCovered = nextLengthToChoose;
        ans++;
      }
      if (currentLengthCovered >= time) return ans;
      if (currentLengthCovered <= i) return -1;
    }
    return -1;
  }


  //Solution #3
  public int sorting_solution3(int[][] clips, int time) {
    // Generic sorting solution
    Arrays.sort(clips, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0])
          return o1[1] - o2[1];
        return o1[0] - o2[0];
      }
    });
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

}
