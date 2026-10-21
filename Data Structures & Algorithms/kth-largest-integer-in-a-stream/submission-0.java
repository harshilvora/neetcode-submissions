class KthLargest {
    List<Integer> stream;
    int K;
    public KthLargest(int k, int[] nums) {
        this.K = k;
        this.stream = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            stream.add(nums[i]);
        }
    }

    public int add(int val) {
        stream.add(val);
        Collections.sort(stream);
        return stream.get(stream.size() - K);
    }
}
