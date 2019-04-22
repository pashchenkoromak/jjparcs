#include <iostream>
#include <fstream>
#include <cstdlib>

using namespace std;

int main()
{
    int n = 1000000;
    fstream f("nums");
    f << n << '\n';
    int k = 31;
    for(int i = 0; i < n; i++)
    {
        f << rand() << ' ';
    
    }
    fstream g("quests");
    int m = 1000000;
    g << m << '\n';
    for(int i = 0; i < m; i++)
    {
        g << rand() % n << ' ' << n-1 << '\n';
    }
}