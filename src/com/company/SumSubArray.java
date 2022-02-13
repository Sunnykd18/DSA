package com.company;

    class Kadane
    {
        public static void main (String[] args) {
            int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
            System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
        }

        static int maxSubArraySum(int []a)
        {
            int cursum = 0;
            int maxsum = 0;

            for (int i = 0; i < a.length; i++)
            {
                cursum = cursum + a[i];
                if (maxsum < cursum)
                   maxsum = cursum;
                if (cursum   < 0)
                    cursum = 0;
            }
            return maxsum;
        }
    }





