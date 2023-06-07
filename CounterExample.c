#include <iostream>
#include <algorithm>
 
#define ll long long
 
using namespace std;
 
int main(){
    ll l,r;
    cin>>l>>r;
    if(l == r){cout<<"-1";return 0;}
    for(ll i = l ; i <= r ; i++){
        if(__gcd(i,i+1) == 1){
            if(__gcd(i+1,i+2) == 1){
                if(__gcd(i,i+2) != 1){
                    if((i+2) <= r){
                        cout<<i<<" "<<i+1<<" "<<i+2<<endl;
                        return 0;
                    }else{
                        cout<<"-1";
                        return 0;
                    }
                }
            }
        }
    }
}
