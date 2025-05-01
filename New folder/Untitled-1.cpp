#include<iostream.h>
#include<conio.h>
class xyz
{
int n;
public:
void eo()
{
clrscr();
cout<<"enter the number: ";
cin>>n;

if(n%2==0)
{
cout<<n<<" is even";
}
else
{
cout<<n<<" is odd";
}
}
void table();
};


void xyz::table()
{
cout<<"\ntable of "<<n;
for(int i=1;i<=10;i++)
{
 int c;
 c=n*i;
 cout<<"\n"<<n<<"*"<<i<<" = "<<c;
}
}

void main()
{

xyz ob;
ob.eo();
ob.table();
getch();
}
