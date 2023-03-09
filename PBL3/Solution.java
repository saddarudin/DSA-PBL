package PBL3;

public class Solution {
    public Solution(){
        new Main();
    }
    //this method will return two-dimensional String array containing name of country and its average earth quack of each year
    public String[][] question1(){
        //calling array of stack of each country
        MyLinkedStack[] countries=new Main().getCountryStack();
        //for storing country name and its average
        String[][] quakes=new String[52][2];
        //index of each country in quacks array is handled by index variable
        int index=0;
        double maxAverage=0;//initial maximum average
        String country="";//for storing name of country having max average
        int countYears=0;//for counting total no of years in which earth quack came for each country
        int count=0;//for comparison
        int counter=1965;//for comparison
        int a=1;//to ensure that else runs only once
        for(int i=1965;i<=2016;i++){
            //taking copy of every stack one by one so that pop method can be called
            MyLinkedStack stack=countries[count++].copy();
            //size of selected stack
            int x=stack.getSize();
            //getting data from selected stack
            for(int y=0;y<x;y++){
                //splitting date into columns so that year can be separated
                String[] date=stack.pop().getDate().split("/");
                //converting string year into int year
                int year=Integer.parseInt(date[2]);
                if(a==2){
                    if(year!=counter){
                        countYears++;
                        counter=year;
                    }
                }
                else {
                    counter=year;
                    countYears++;
                    a++;
                }
            }
            double average=(double)x/countYears;
            //choosing max average and assigning it to tha maxAverage variable
            if(average>maxAverage){
                maxAverage=average;
                country=stack.getStackName();
            }
            quakes[index][0]="Name:  "+stack.getStackName();
            quakes[index++][1]="Average: "+average;
            countYears=0;
            a=1;
        }
        System.out.println("Country having maximum average of earth quack in each year is "+country+" and maximum average is: "+maxAverage);
        return quakes;
    }
    public MyLinkedQueue question2(){
        MyLinkedQueue queue=new Main().getEarthQuackQueue().copy();
        MyLinkedQueue queue1=new MyLinkedQueue();
        for(int i=1965;i<2016;i++){
            if(i>=2005)queue1.add(queue.remove());
            else queue.remove();
        }
        return queue1;
    }
    //this method will get country name and will return 5 recent earth quack information
    public MyLinkedStack question3(String countryName){
        //declaring stack for making copy of actual stack so that pop method can be called
        MyLinkedStack stack=new MyLinkedStack(countryName);
        //for matching country name with stack and then assign copy of matched stack to stack
        for(MyLinkedStack s:new Main().getCountryStack()){
            if(countryName.equals(s.getStackName())){
                stack=s.copy();
                break;
            }
        }
        //for storing  5 recent earth quacks declaring stack1
        MyLinkedStack stack1=new MyLinkedStack(countryName);
        //storing earth quacks into array so that can be stored into stack1 as directly pop method will store in reverse order
        EarthQuake[] quakes=new EarthQuake[5];
        for(int i=0;i<5;i++)quakes[i]=stack.pop();
        for(int j=quakes.length-1;j>=0;j--)stack1.push(quakes[j]);
        return stack1;
    }
    public MyLinkedList question4(){
        MyLinkedList list=new Main().getRecentCountryWiseQuacksList().copy();
        MyLinkedList list1=new MyLinkedList();
        int size= list.getSize();
        for(int i=0;i<size;i++){
            EarthQuake quake=list.delete();
            if(quake.getMagnitude()>=6)list1.insert(quake);
        }
            list1.reverse();
        return list1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        MyLinkedList list=s.question4();
        int j=list.getSize();
        for(int i=0;i<j;i++) System.out.println(list.delete());

    }
}
