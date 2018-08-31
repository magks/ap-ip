int Solution::isPalindrome(string A) {
    
    string B = "";
    for(int i = 0; i < A.length(); ++i)
        if(isalnum(A[i]))
            B += tolower(A[i]);
            
    int len = B.length();
    int mid = (len-1)/2;
    
    for(int l = 0, r = len-1; l != r && l <= mid; ++l, --r)
        if( B[l] != B[r] )
            return 0;
            
    return 1;
    
}

