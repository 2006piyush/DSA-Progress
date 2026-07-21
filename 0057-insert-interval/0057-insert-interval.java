class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ins_result = new ArrayList<>();
        boolean is_insert = false;
         for (int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(is_insert==false && start>=newInterval[0]){
               ins_result.add(new int[]{newInterval[0], newInterval[1]});
                is_insert = true;
            }
            ins_result.add(new int[]{start, end});
         }
         if (!is_insert) {
            ins_result.add(new int[]{newInterval[0], newInterval[1]});
         }
          return merge(ins_result.toArray(new int[ins_result.size()][]));

    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (end >= s) {
                end = Math.max(end, e);
                continue;
            }

            result.add(new int[]{start, end});

            start = s;
            end = e;
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}