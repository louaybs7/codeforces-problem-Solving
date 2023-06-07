#include <iostream>
#include <algorithm>
#include <cmath>
 
#define ll long long
 
using namespace std;
 
 
int main(){
    
    ll n,m,a;
    cin>>n>>m>>a;
    cout<<((m+a-1)/a)*((n+a-1)/a); // how many a in m & n ;
    return 0;
 
}
