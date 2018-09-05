vector<string> Solution::fizzBuzz(int A) {
    vector<string> v;
    for(int i = 1; i <= A; ++i)
    {
        if( i % 5 == 0 )
        {
            if ( i % 3 == 0)
                v.push_back(string("FizzBuzz"));
            else
                v.push_back(string("Buzz"));
        }
        else if ( i % 3 == 0)
        {
             v.push_back(string("Fizz"));
        }
        else
            v.push_back( to_string(i) );
    }
}

