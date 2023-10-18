package maths;

public class Reaching_Points_780 {

  boolean ans = false;
  boolean calculated = false;

  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    System.out.println("Starting with sx=" + sx + ", sy=" + sy + ", tx=" + tx + ", ty=" + ty);

    dfs(sx, sy, tx, ty);
    return ans;
  }

  public void dfs(int sx, int sy, int tx, int ty) {
    if (sx == tx && sy == ty) {
      ans = true;
      calculated = true;
    }

    if (calculated) return;
    if (sx > tx || sy > ty) {
      ans = false;
      calculated = true;
      return;
    }

    if (sx == tx) {
      // i.e. ty>sy
      ans = (ty - sy) % sx == 0;
      calculated = true;
      return;
    }

    if (sy == ty) {
      ans = (tx - sx) % sy == 0;
      calculated = true;
      return;

    }

    if (ty > tx) {
      ty = ty % tx;

    } else if (tx >= ty) {
      tx = tx % ty;
    }

    dfs(sx, sy, tx, ty);

  }
}
