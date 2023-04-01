#include<iostream>
#include<cmath>
#include<string>
using namespace std;

int main()
{
	int v1,v2;
	string all_prob[6]={"1/6","1/3","1/2","2/3","5/6","1/1"};
	cin>>v1>>v2;
	m=max(v1,v2);
	cout << all_prob[6-m];
	return 0 ;
}
