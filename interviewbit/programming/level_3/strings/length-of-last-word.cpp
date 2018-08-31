int Solution::lengthOfLastWord(const string A) {

    int lwLen = 0; //last word length
    bool anticipating = false; //not last word if pattern ' ', \w is found
                                // so set a flag anticipating a word char whenever we see a space 
                                //and reset if found

    for (int i = 0 ; i < A.length() ; ++i)
    {
        if( A[i] != ' ') 
		{
            if( anticipating )  //reset last word length count and anti-last-word-pattern flag.
			{
                lwLen = 0;
                anticipating = false;
            }
            ++lwLen; //count the character;

        }
        else 
            anticipating = true; //a space, this might be the last word.

    }
    return lwLen;
}


