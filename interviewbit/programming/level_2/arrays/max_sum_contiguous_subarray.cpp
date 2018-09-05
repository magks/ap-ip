int Solution::maxSubArray(const vector<int> &A) {
    int max = INT_MIN;
    int sum = 0;
    int r = A.size() - 1;
    
    for(int i = 0; i <= r; ++i)
    {
        sum += A[i];
        if( max < sum )
            max = sum;
        if( sum <= 0 )
            sum = 0;
        
    }
    return max;
}

