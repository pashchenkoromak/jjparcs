#include <iostream>
#include <fstream>
#include <cstdlib>

using namespace std;

int main()
{
    int n = 10000;
    fstream f("nums");
    f << n << '\n';
    for(int i = 0; i < n; i++)
    {
        f << rand()%100 << ' ';
    
    }
    fstream g("quests");
    int m = 100000;
    g << m << '\n';
    for(int i = 0; i < m; i++)
    {
        g << rand() % n << ' ' << n-1 << '\n';
    }
}