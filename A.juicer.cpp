#include <iostream>
using namespace std;

int main() {
    int numberOfOrange, maxsize, capacity;
    cin >> numberOfOrange >> maxsize >> capacity;
    int counter = 0, result = 0;
    for (int i = 0; i < numberOfOrange; i++) {
        int orange;
        cin >> orange;
        if (orange <= maxsize)
            counter += orange;
        if (counter > capacity) {
            counter = 0;
            result++;
        }
    }
    cout << result << endl;
    return 0;
}
