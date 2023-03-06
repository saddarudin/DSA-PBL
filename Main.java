package PBL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    //University array has been created to store universities' objects
    University[] universities=new University[100];//values
    //String array to store keys of every object of university
    String[] keys=new String[100];

    //Constructor to fetch data from csv file to University array
    //and txt file to keys array
    Main(){
        //Reading from csv file and txt file
        File file=new File("PBL/Top 100 Unis of Pakistan.csv");
        File file1=new File("PBL/Keys.txt");
        try {
            int i=0;
            Scanner scan = new Scanner(file);
            Scanner scanner=new Scanner(file1);
            while (scan.hasNextLine()){
                String[] parts= scan.nextLine().split(",");
                universities[i]=new University(parts[0],Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),
                        parts[4],parts[5],Integer.parseInt(parts[6]));
                keys[i]=scanner.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        insertIntoMap();
        insertIntoStack("noOfPublications");
        insertIntoStack("PakRanking");
    }

    //Hashmap: to store data in key value pair
    private static final MyHashmap map=new MyHashmap(100);
    //to insert data into hashmap and also return map
    public void insertIntoMap(){
        for(int i=0;i<100;i++)map.put(keys[i],universities[i]);
    }
    public static MyHashmap getMap(){return map;}
    //stack1 for storing data order by noOfPublication
    private static final MyLinkedStack stack1=new MyLinkedStack();
    //stack2 for storing data order by PakRanking
    private static final MyLinkedStack stack2=new MyLinkedStack();
    private static final MyLinkedStack SindhUETs=new MyLinkedStack();
    private static final MyLinkedStack PunjabUETs=new MyLinkedStack();
    private static final MyLinkedStack BalochistanUETs=new MyLinkedStack();
    private static final MyLinkedStack KPK_UETs=new MyLinkedStack();
    private static final MyLinkedStack AJK_UETs=new MyLinkedStack();
    private static final MyLinkedStack GilgitBiltistanUETs=new MyLinkedStack();

    public void insertIntoStack(String orderBy){
        for(int i=0;i<100;i++){
            if(orderBy.equals("noOfPublications")) stack1.push(keys[i],universities[i],orderBy);
            else if(orderBy.equals("PakRanking")){
                stack2.push(keys[i],universities[i],orderBy);
                switch (universities[i].getProvince()){
                    case "Sindh"->SindhUETs.push(keys[i],universities[i],orderBy);
                    case "Punjab"->PunjabUETs.push(keys[i],universities[i],orderBy);
                    case "Balochistan"->BalochistanUETs.push(keys[i],universities[i],orderBy);
                    case "KPK"->KPK_UETs.push(keys[i],universities[i],orderBy);
                    case "AJK"->AJK_UETs.push(keys[i],universities[i],orderBy);
                    case "Gilgit Biltistan"->GilgitBiltistanUETs.push(keys[i],universities[i],orderBy);
                }
            }
        }

    }
    public static MyLinkedStack getStack1(){return stack1;}
    public static MyLinkedStack getStack2(){return stack2;}

    public static MyLinkedStack getSindhUETs() {
        return SindhUETs;
    }

    public static MyLinkedStack getPunjabUETs() {
        return PunjabUETs;
    }

    public static MyLinkedStack getGilgitBiltistanUETs() {
        return GilgitBiltistanUETs;
    }

    public static MyLinkedStack getKPK_UETs() {
        return KPK_UETs;
    }

    public static MyLinkedStack getBalochistanUETs() {
        return BalochistanUETs;
    }

    public static MyLinkedStack getAJK_UETs() {
        return AJK_UETs;
    }

}
