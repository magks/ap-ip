#include <stack>
#include <iostream>
using namespace std;

struct node {
	vector<node> neighbors;
	bool visited;
}

void termination_condition(){}

void dfs(node start)
{
	stack<node> s;
	s.push(start);
	while( ! s.empty() ) {
		top = s.top();
		s.pop();
		if( !top.visited )
		{
			//check for termination condition -- have we reached the node we want to?
			termination_condition();

			//mark top as visited
			top.visited = true;
			//add all of top's neibors to the stack
			for( node n : node.neighbors )
				s.push( n );
		}
	}
}


void intro() 
{
	int c;
	cout << "Welcome to dfs tutorial." << endl;
	cout << "1. Auto Demo " << endl;
	cout << "2. Enter graph info manually" << endl;
	cin >> c;
	switch ( c )
	{
		case 1: 
			cout << "todo: auto demo" << endl;
			break;
		case 2:
			cout << "todo: manual graph entry"  << endl;
			break;
		default:
			cout  << "Unknown option: " << c << endl;
			break;
	}
}

int main ()
{
	intro();
}
