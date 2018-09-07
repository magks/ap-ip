/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
vector<Interval> Solution::insert(vector<Interval> &intervals, Interval newInterval) {
    vector<Interval> res;
    int end_idx = intervals.size() - 1;
    bool usedNewInterval = false;
    bool startFound = false;
    bool lookingForEnd = false;
    bool pushInterval = false;
    bool pushLast = false;
    int start, end;
    //swap if necessary
    if( newInterval.start > newInterval.end )
    {
        int temp = newInterval.end;
        newInterval.end = newInterval.start;
        newInterval.start = temp;
    }
    //case 0, 1: empty, consumes all
    if(intervals.size() == 0 || newInterval.start <= intervals[0].start && newInterval.end >= intervals[end_idx - 1].end) 
        return vector<Interval>(1, newInterval);
    
    //case 1A: precedes
    if( newInterval.start < intervals[0].start  && newInterval.end < intervals[0].start)
    {
        res.push_back(newInterval);
        usedNewInterval = true;
    }
    //case 1 is now looking to add intervals in order
    
    if( newInterval.start > intervals[end_idx].end )
    {  
         pushLast = true;
         usedNewInterval = true;
    } //add intervals in order then push back

    for(int i = 0; i <= end_idx; ++i )
    {
        //push as is?
        if( usedNewInterval ) //push current and continue
        {
            res.push_back(intervals[i]);
            continue;
        }
        else if ( newInterval.start >= intervals[i].start && newInterval.start <= intervals[i].end )
        { //  check if new interval start is within bounds of curren tinterval
            start = intervals[i].start;
            if( newInterval.end <= intervals[i].end )
            {
                res.push_back(intervals[i]);
                usedNewInterval = true;
                continue;
            }
            if( i == end_idx || newInterval.end < intervals[i+1].start )
            {
                res.push_back( Interval(start, newInterval.end) );
                usedNewInterval = true;
                continue;
            }
            lookingForEnd = true;
        }
        else if( !lookingForEnd && newInterval.start < intervals[i].start )
        {
                start = newInterval.start;
                lookingForEnd = true;
        }
        else if( !lookingForEnd )
        { //might be nested within two
            //might start before interval
            res.push_back( intervals[i] );  //always push current
            //check if nested within two or if search continues;
             if( i < end_idx && newInterval.start < intervals[i+1].start )
                {
                    if (newInterval.end < intervals[i+1].start)
                    {
                        res.push_back(newInterval);
                        usedNewInterval = true;
                        res.push_back(intervals[++i]);//add next interval 
                    }
                    else
                    {
                        start = newInterval.start;
                        lookingForEnd = true;
                    }
                    
                }
                continue;
        }
        
        if(lookingForEnd)
        {
                if( newInterval.end <= intervals[i].end ) 
                 res.push_back( Interval(start, intervals[i].end) );
                else if( i == end_idx || i < end_idx && newInterval.end < intervals[i+1].start )
                 res.push_back( Interval(start, newInterval.end) );
                else
                    continue;
                 lookingForEnd = false;
                 usedNewInterval = true;  
        }
    }
    
    if(pushLast)
        res.push_back( newInterval );

    return res;
}

