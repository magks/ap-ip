#include <iostream>
#include <vector>

using namespace std;

vector<int> wave(vector<int> &A) {
    if ( A.size() == 1 )
        return A;
    vector<int> B;
    // Array is size 2 or more
    /* Plan: given sub array i to N-1
        if A.size() - idx >= 2 {
            1. find the smallest and second smallest
            2. place 2ndSmall in first position of subarray and small in second pos.
            3. incremement idx by 2
        }
        else
        {
            //case 1: subarray is size 1 indicated by  idx at last array index
            if ( idx == A.size() - 1 )
                B.push_back( A[idx] )
            //case 2: subarr is size 1
            return B;
        }
        
        
    */
    for(int idx = 0, lastIdx = A.size() - 1; idx <= lastIdx; idx += 2  )
    {
        
        for(vector<int>::iterator it = A.begin() ; it != A.end(); ++it)
                cout << *it <<  ","  ;
            cout << " | " ;


 
        if( A.size() - idx >= 2)
        {
            //find smallest and second smallest
            int smIdx = idx;
            int secIdx = idx;
            int oldSmallest = smIdx;
            int temp;
            for(int j = idx+1; j <= lastIdx ; ++j )
            {
                if( A[j] < A[smIdx] ) //<=
                {
                    oldSmallest =  smIdx;
                    smIdx = j;
                    if( A[smIdx] > A[secIdx] )
                    {
                        temp = smIdx;
                        smIdx = secIdx;
                        secIdx = temp;
                    }
                    if( A[secIdx] > A[oldSmallest] )
                        secIdx = oldSmallest;
                }
                else if( smIdx == secIdx || A[j] < A[secIdx]  )
                {
                    secIdx = j;
                }
                    
                    
            }
            B.push_back( A[secIdx] );
            B.push_back( A[smIdx] );
            if( A.size() - idx == 2 )
				return B;
            //swap out smallest/secsmallest
            int smallest = A[smIdx];
            int secSmallest = A[secIdx];
            //both outside range
            if(  smIdx > idx+1 && secIdx > idx+1)
            {
               //swap second smallest
                temp = A[idx];
                A[idx] = A[secIdx];
                A[secIdx] = temp;
                
            
            //swap smallest
                temp = A[idx+1];
                A[idx+1] = A[smIdx];
                A[smIdx] = temp;
                
            }
            else if( smIdx > idx+1 ) //just one
            {
                //swap smallest
                if( secIdx == idx) {
                    temp = A[idx+1];
                    A[idx+1] = A[smIdx];
                    A[smIdx] = temp;
                }
                else {
                    temp = A[idx];
                    A[idx] = A[smIdx];
                    A[smIdx] = temp;
                }
                    
                
                
            }
            else if( secIdx > idx+1)
            {
                if( smIdx == idx) {
                    temp = A[idx+1];
                    A[idx+1] = A[secIdx];
                    A[secIdx] = temp;
                }
                else {
                    temp = A[idx];
                    A[idx] = A[secIdx];
                    A[secIdx] = temp;
                }
                    
            }
            
        

            
        }
        else
        {
            if( idx == lastIdx )
                B.push_back( A[idx] );
            return B;
        }
    }
}


int main()
{
	vector<int> v = {6, 12, 9, 1, 2, 7};
	vector<int> A = wave(v);
        for(vector<int>::iterator it = A.begin() ; it != A.end(); ++it)
                cout << *it <<  ","  ;
            cout << " | " ;
}
