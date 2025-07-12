public class Combinations {

    public class Solution_dfs {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {

            if (k > n || n <= 0 || k <= 0) {
                return result;
            }

            dfs(n, k, 1);

            return result;

        }

        private void dfs(int n, int k, int start) {

            if (k == 0) {
                result.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = start; i <= n; i++) {
                tmp.add(i);
                dfs(n, k - 1, i + 1);
                tmp.remove(tmp.size() - 1);
            }

        }
    }

    public class Solution_iteration {
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> res = new ArrayList<>();
            int[] out = new int[k];

            int i = 0;
            while (i >= 0) {
                ++out[i];
                if (out[i] > n) --i;
                else if (i == k - 1) res.add(Arrays.stream(out).boxed().collect(Collectors.toList()));
                else {
                    ++i;
                    out[i] = out[i - 1];
                }
            }

            return res;
        }
    }

}


//////

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int n, int k, List<Integer> t, List<List<Integer>> res) {
        if (t.size() == k) {
            res.add(new ArrayList<>(t));
            return;
        }
        for (int j = i; j <= n; ++j) {
            t.add(j);
            dfs(j + 1, n, k, t, res);
            t.remove(t.size() - 1);
        }
    }
}