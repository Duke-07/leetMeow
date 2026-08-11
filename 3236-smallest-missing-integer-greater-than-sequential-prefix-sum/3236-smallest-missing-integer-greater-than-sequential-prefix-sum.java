class Solution {
    public int missingInteger(int[] A) {
        int n = A.length;
        Set<Integer> gone = new HashSet<>(n);
        for (int num : A)
            gone.add(num);
        int meow = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1] + 1)
                meow += A[i];
            else break;
        }
        while (gone.contains(meow))
            meow++;
        return meow;
    }
}