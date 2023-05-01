#include <iostream>
using namespace std;

int solution(int N){
    int sum = 0;
    int sum2 = 0;
    int tp = N;
    while(tp > 0){
        sum += tp % 10;
        tp /= 10;
    }
    int i = N + 1;
    while(true){
        tp = i;
        sum2 = 0;
        while(tp > 0){
            sum2 += tp % 10;
            tp /= 10;
        }
        if(sum2 == 2*sum){
            return i;
        }
        i++;
    }
}
