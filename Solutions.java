package PBL;

import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.Stack;

public class Solutions {
    public University search(MyHashmap map,String key){
        return map.get(key);
    }
    public University[] topX(MyLinkedStack stack,int X){
        University[] uet=new University[X];
        String[] keys=new String[X];
        MyHashmap map=Main.getMap();
        for(int i=0;i<X;i++){
            keys[i]=stack.pop();
            uet[i]=map.get(keys[i]);
        }
        for(int i=X-1;i>=0;i--)stack.push(keys[i]);
        return uet;
    }
    public University[] bottomX(MyLinkedStack stack,int X){
        University[] uet=new University[X];
        MyHashmap map=Main.getMap();
        String[] keys=new String[map.size()];
        int count=0;
        for(int i=0;i< map.size();i++) keys[i]=stack.pop();
        for(int i=map.size()-X;i< map.size();i++)uet[count++]=map.get(keys[i]);
        for(int i=99;i>=0;i--)stack.push(keys[i]);
        return uet;
    }
    public University percentile(int percentile,MyLinkedStack stack){
        /*
        The percentile formula determines the performance of anything
        over other things of same class.
        For example: The percentile formula is used in finding where a
        student stands in the test compared to other candidates.
        A percentile is a number where a certain percentage of scores
        fall below the given number.
         */
        /*
        formula : n=P/100*N where
        n=ordinal rank
        N=No of values in data;
        P=percentile
         */
        int position=(percentile*stack.size())/100;
        return Main.getMap().get(stack.get(position));
    }
    public String performance(){
        String x="",y= "";
        int punjabPub=0,sindhPub=0,balPub=0,kpkPub=0,ajkPub=0,gilgitPub=0;
        MyLinkedStack stack1=Main.getSindhUETs();
        MyLinkedStack stack2=Main.getPunjabUETs();
        MyLinkedStack stack3=Main.getBalochistanUETs();
        MyLinkedStack stack4=Main.getKPK_UETs();
        MyLinkedStack stack5=Main.getAJK_UETs();
        MyLinkedStack stack6=Main.getGilgitBiltistanUETs();
        for(int i=1;i<=stack1.size();i++)
            sindhPub+=Main.getMap().get(stack1.get(i)).getNoOfPublications();
        for(int i=1;i<=stack2.size();i++)
            punjabPub+=Main.getMap().get(stack2.get(i)).getNoOfPublications();
        for(int i=1;i<=stack3.size();i++)
            balPub+=Main.getMap().get(stack3.get(i)).getNoOfPublications();
        for(int i=1;i<=stack4.size();i++)
            kpkPub+=Main.getMap().get(stack4.get(i)).getNoOfPublications();
        for(int i=1;i<=stack5.size();i++)
            ajkPub+=Main.getMap().get(stack5.get(i)).getNoOfPublications();
        for(int i=1;i<=stack6.size();i++)
            gilgitPub+=Main.getMap().get(stack6.get(i)).getNoOfPublications();
        double avg1=(double) sindhPub/stack1.size();
        double avg2=(double) punjabPub/stack1.size();
        double avg3=(double) balPub/stack1.size();
        double avg4=(double) kpkPub/stack1.size();
        double avg5=(double) ajkPub/stack1.size();
        double avg6=(double) gilgitPub/stack1.size();
        double best,worst;
        best= Math.max(avg1, avg2);
        best= Math.max(best, avg3);
        best= Math.max(best, avg4);
        best= Math.max(best, avg5);
        best= Math.max(best, avg6);
        worst= Math.min(avg1, avg2);
        worst= Math.min(worst, avg3);
        worst= Math.min(worst, avg4);
        worst= Math.min(worst, avg5);
        worst= Math.min(worst, avg6);
        if (best == avg1) x = "Sindh";
        else if (best == avg2) x = "Punjab";
        else if (best == avg3) x = "Balochistan";
        else if (best == avg4) x = "KPK";
        else if (best == avg5) x = "AJK";
        else if (best == avg6) x = "Gilgit";
        if (worst == avg1) y = "Sindh";
        else if (worst == avg2) y = "Punjab";
        else if (worst == avg3) y = "Balochistan";
        else if (worst == avg4) y = "KPK";
        else if (worst == avg5) y = "AJK";
        else if (worst == avg6) y = "Gilgit";



        return "Best Province: "+x+"\n Worst Province: "+y;
    }

    public static void main(String[] args) {
        Solutions s=new Solutions();
        new Main();
        while (true) {
            System.out.println("\n\n\n");
            System.out.println("1.Search any university by providing key");
            System.out.println("2. Top x universities of Pakistan");
            System.out.println("3. n universities from bottom");
            System.out.println("4. nth Percentile university");
            System.out.println("5. See provincial ranking of the universities");
            System.out.println("6. Best and worst province");
            System.out.println("7.Exit");
            Scanner scan = new Scanner(System.in);
            switch (scan.next()) {
                case "1" -> {
                    System.out.println("Enter four word key: ");
                    String str=scan.next();
                    System.out.println("wRank\t   aRank\t   pRank\tPub\t\t\t\t\t\t\tLoc\t\t\t\t\t\t\tProvince\t\t\t\t\t\t\t\t\t\tName");
                    System.out.println(Main.getMap().get(str));
                }
                case "2" -> {
                    System.out.println("Enter number of universities: ");
                    int b = Integer.parseInt(scan.next());
                    System.out.println("On the basis of: ");
                    System.out.println("1> Number of publication ");
                    System.out.println("2> Pakistani Ranking ");
                    System.out.println("Your choice: ");
                    String a = scan.next();
                    System.out.println("wRank\t   aRank\t   pRank\tPub\t\t\t\t\t\t\tLoc\t\t\t\t\t\t\tProvince\t\t\t\t\t\t\t\t\t\tName");
                    if (a.equals("1"))
                        for (University u : s.topX(Main.getStack1(), b))
                            System.out.println(u);
                    else if (a.equals("2"))
                        for (University u : s.topX(Main.getStack2(), b))
                            System.out.println(u);
                }
                case "3" -> {
                    System.out.println("Enter number of universities: ");
                    int b = Integer.parseInt(scan.next());
                    System.out.println("On the basis of: ");
                    System.out.println("1> Number of publication ");
                    System.out.println("2> Pakistani Ranking ");
                    System.out.println("Your choice: ");
                    String a = scan.next();
                    System.out.println("wRank\t   aRank\t   pRank\tPub\t\t\t\t\t\t\tLoc\t\t\t\t\t\t\tProvince\t\t\t\t\t\t\t\t\t\tName");
                    if (a.equals("1"))
                        for (University u : s.bottomX(Main.getStack1(), b))
                            System.out.println(u);
                    else if (a.equals("2"))
                        for (University u : s.bottomX(Main.getStack2(), b))
                            System.out.println(u);
                }
                case "4" -> {
                    System.out.println("Enter percentile: ");
                    int b = Integer.parseInt(scan.next());
                    System.out.println("On the basis of: ");
                    System.out.println("1> Number of publication ");
                    System.out.println("2> Pakistani Ranking ");
                    System.out.println("Your choice: ");
                    String a = scan.next();
                    System.out.println("wRank\t   aRank\t   pRank\tPub\t\t\t\t\t\t\tLoc\t\t\t\t\t\t\tProvince\t\t\t\t\t\t\t\t\t\t\tName");
                    if (a.equals("1"))
                        System.out.println(s.percentile(b, Main.getStack1()));
                    else if (a.equals("2"))
                        System.out.println(s.percentile(b, Main.getStack2()));
                }
                case "5" -> {
                    System.out.println("1.Top Ranked Universities of Sindh");
                    System.out.println("2.Top Ranked Universities of Punjab");
                    System.out.println("3.Top Ranked Universities of Balochistan");
                    System.out.println("4.Top Ranked Universities of KPK");
                    System.out.println("5.Top Ranked Universities of AJK");
                    System.out.println("6.Top Ranked Universities of Gilgit Biltistan");
                    String c = scan.next();
                    System.out.println("wRank\t   aRank\t   pRank\tPub\t\t\t\t\t\t\tLoc\t\t\t\t\t\t\tProvince\t\t\t\t\t\t\t\t\t\tName");
                    switch (c) {
                        case "1" -> Main.getSindhUETs().traverse();
                        case "2" -> Main.getPunjabUETs().traverse();
                        case "3" -> Main.getBalochistanUETs().traverse();
                        case "4" -> Main.getKPK_UETs().traverse();
                        case "5" -> Main.getAJK_UETs().traverse();
                        case "6" -> Main.getGilgitBiltistanUETs().traverse();
                    }
                }
                case "6" -> System.out.println(s.performance());
                case "7"->System.exit(0);
            }
        }
    }
}
