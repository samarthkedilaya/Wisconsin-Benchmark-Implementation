package com.dbimpl.dbwiscops;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import com.dbimpl.dbwiscops.dao.DbAdapter;

public class Main {

    public static Connection DBconnect() {
        System.out.println("Welcome to my DBImpl Project");

        DbAdapter dbAdapter = new DbAdapter();
        dbAdapter.connect();
        return dbAdapter.getConn();
    }

    public static void main(String[] args) {
        Connection conn= Main.DBconnect();
        Main t=new Main();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of tables:");
        int tablecount=sc.nextInt();
        int[] tuplecount=new int[tablecount];
        String[] tablename=new String[tablecount];

        for(int i=0;i<tablecount;i++) {
            System.out.println("Enter table name:");
            tablename[i]=sc.next();
            System.out.println("Enter no. of tuples in the table:");
            tuplecount[i]=sc.nextInt();
        }
        sc.close();

        for(int j=0;j<tablecount;j++) {
            int maxtuples=tuplecount[j];

            Statement stmnt=null;
            try {
                stmnt = conn.createStatement();
                stmnt.execute("CREATE TABLE "+tablename[j]+"(unique1 integer NOT NULL CONSTRAINT unique1_check check (unique1 between 0 and "+(maxtuples-1)+"),unique2 integer NOT NULL PRIMARY KEY CONSTRAINT unique2_check check (unique2 between 0 and "+(maxtuples-1)+"),unique3 integer NOT NULL CONSTRAINT unique3_check check (unique3 between 0 and "+(maxtuples-1)+"),two integer NOT NULL CONSTRAINT two_check CHECK (two in (0,1)), four integer NOT NULL CONSTRAINT four_check CHECK (four in (0,1,2,3)), ten integer NOT NULL CONSTRAINT ten_check CHECK (ten between 0 and 9),twenty integer NOT NULL CONSTRAINT twenty_check CHECK (twenty between 0 and 19),onepercent integer NOT NULL CONSTRAINT onepercent_check CHECK (onepercent between 0 and 99),tenpercent integer NOT NULL CONSTRAINT tenpercent_check CHECK (tenpercent between 0 and 9),twentypercent integer NOT NULL CONSTRAINT twentypercent_check CHECK(twentypercent in (0,1,2,3,4)),fiftypercent integer NOT NULL CONSTRAINT fiftypercent_check CHECK(fiftypercent in (0,1)), evenOnePercent integer NOT NULL CONSTRAINT evenOnePercent_check CHECK(evenOnePercent between 0 and 198 and evenOnePercent%2=0),oddOnePercent integer NOT NULL CONSTRAINT oddOnePercent_check CHECK(oddOnePercent between 0 and 199 and oddOnePercent%2!=0),stringu1 char(52) NOT NULL, stringu2 char(52) NOT NULL, string4 char(52) NOT NULL,CONSTRAINT "+tablename[j]+"_unique1 UNIQUE (unique1),CONSTRAINT "+tablename[j]+"_unique2 UNIQUE (unique2),CONSTRAINT "+tablename[j]+"_unique3 UNIQUE (unique3),CONSTRAINT "+tablename[j]+"_stringu1 UNIQUE (stringu1),CONSTRAINT "+tablename[j]+"_stringu2 UNIQUE (stringu2))");

            } catch (SQLException e) {
                e.printStackTrace();
            }

            int[] unique1=new int[maxtuples];
            int[] unique2=new int[maxtuples];
            int[] two=new int[maxtuples];
            int[] four=new int[maxtuples];
            int[] ten=new int[maxtuples];
            int[] twenty=new int[maxtuples];
            int[] onepercent=new int[maxtuples];
            int[] tenpercent=new int[maxtuples];
            int[] twentypercent=new int[maxtuples];
            int[] fiftypercent=new int[maxtuples];
            int[] unique3=new int[maxtuples];
            int[] evenOnePercent=new int[maxtuples];
            int[] oddOnePercent=new int[maxtuples];
            String[] stringu1=new String[maxtuples];
            String[] stringu2=new String[maxtuples];
            String[] string4=new String[maxtuples];
            int str4count=1;

            ArrayList<Integer> shuffled=new ArrayList<>();
            for(int k=0;k<maxtuples;k++) {
                shuffled.add(k);
            }
            Collections.shuffle(shuffled);
            for(int i=0;i<maxtuples;i++) {
                unique1[i]=shuffled.get(i);
                unique2[i]=i;
                two[i]=unique1[i]%2;
                four[i]=unique1[i]%4;
                ten[i]=unique1[i]%10;
                twenty[i]=unique1[i]%20;
                onepercent[i]=unique1[i]%100;
                tenpercent[i]=unique1[i]%10;
                twentypercent[i]=unique1[i]%5;
                fiftypercent[i]=unique1[i]%2;
                unique3[i]=unique1[i];
                evenOnePercent[i]=onepercent[i]*2;
                oddOnePercent[i]=(onepercent[i]*2)+1;
                stringu1[i]=t.generateStru12(unique1[i]);
                stringu2[i]=t.generateStru12(unique2[i]);
                string4[i]=t.generateStr4(str4count);
                if(str4count==4) {
                    str4count=1;
                }else {
                    str4count++;
                }
                try {
                    stmnt.addBatch("Insert into "+tablename[j]+" values("+unique1[i]+","+unique2[i]+","+unique3[i]+","+two[i]+","+four[i]+","+ten[i]+","+twenty[i]+","+onepercent[i]+","+tenpercent[i]+","+twentypercent[i]+","+fiftypercent[i]+","+evenOnePercent[i]+","+oddOnePercent[i]+",'"+stringu1[i]+"','"+stringu2[i]+"','"+string4[i]+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                stmnt.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public String generateStru12(int unique1) {
        char[] str=new char[52];
        for(int k=0;k<52;k++) {
            str[k]='x';
        }
        String stru1="";
        int rem=0;
        for(int i=0;i<7;i++) {
            str[i]='A';
        }
        int i=6;
        char temp[]=new char[7];
        while(unique1>0) {
            rem=unique1%26;
            temp[i]=(char) ('A'+rem);
            unique1=unique1/26;
            i--;
        }
        for(i=i+1;i<=6;i++) {
            str[i]=temp[i];
        }
        stru1=String.copyValueOf(str);
        return stru1;
    }

    public String generateStr4(int count) {
        char[] str=new char[52];
        for(int k=0;k<52;k++) {
            str[k]='x';
        }
        String str4="";
        char str1 = 0;

        switch (count) {
            case 1:
                str1='A';
                count++;
                break;

            case 2:
                str1='H';
                count++;
                break;

            case 3:
                str1='O';
                count++;
                break;

            case 4:
                str1='V';
                count=1;
                break;
        }

        for(int z=0;z<4;z++) {
            str[z]=str1;
            str4=String.copyValueOf(str);
        }
        return str4;
    }

}
