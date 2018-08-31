void Solution::reverseWords(string &A) {
    string B = "";
    string w = "";
    bool leadingSpace = true;
    int k = 0;
    
    for(int i = A.length()-1; i >= 0; )
    {
        while( leadingSpace && isspace(A[i]) ){
            --i;
            if( i < 0 )
                A = B;
        }
        leadingSpace = false;
        
        
        if( ! isspace( A[i] ) )
        {
            while( i >= 0 && ! isspace(A[i]  )) 
             {  
                 ++k;
                --i;
             }
            for(int c = 1; c <= k; c++ )
                B += A[i+c];
            // w = "";
             k = 0;
            if( i < 0 ){
                A = B;
                return;
            }
        }
        //space! skip to next word
        while( isspace( A[i] ) ) {
                --i;
                if (i < 0 ){
                    A = B;
                    return;
                }
        }
        //if we are here then A[i] is a word char
        B += " ";
            
    }
    
    A = B;
}

