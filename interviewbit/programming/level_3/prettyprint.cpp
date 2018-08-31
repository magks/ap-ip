vector<vector<int> > Solution::prettyPrint(int A) {
    
    vector<vector<int> > arr(2*A-1, vector<int>(2*A-1));
    
    int oi = 0, ok = 2*A-2;
    
    for(; oi <= A-1; ++oi, --ok)
    {
        //solve the top
        int il = 0, ir = 2*A-2, k = A;
        for(; il <= A-1; ++il, --ir)
        {
            //solve from the left
            arr[oi][il] = k;
            if(il < oi)
                --k;
                
            //get the right for free
            if( il != A-1 )
                arr[oi][ir] = arr[oi][il];
        }
        
        //get the bottom for free
        if( oi != A-1 )
            arr[ok] = arr[oi];
    }
    
    return arr;
    
    
}

