package com.company;

import hashTable.CuckooHashTable;
import hashTable.QuadraticProbingHashTable;
import hashTable.SeparateChainingHashTable;
import hashTable.StringHashFamily;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Maxi Agrippa
 */
public class Main
{
    /**
     * User input reader
     */
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Restore the number of Strings
     */
    public static int numOfString = 0;

    /**
     * Restore the number of Strings to delete
     */
    public static int numOfStringDelete = 0;

    /**
     * Store Strings
     */
    public static ArrayList<String> strings = new ArrayList<>();

    /**
     * Generate String
     */
    public static RandomString randomString = new RandomString();


    public static CuckooHashTable<String> cuckoo = new CuckooHashTable<String>(new StringHashFamily(3), 1050000);

    public static SeparateChainingHashTable<String> sep = new SeparateChainingHashTable<String>(1050000);

    public static QuadraticProbingHashTable<String> quadratic = new QuadraticProbingHashTable<String>(1050000);

    public static ArrayList<String> DataStroage1 = new ArrayList<String>();

    public static ArrayList<String> DataStroage2 = new ArrayList<String>();

    public static ArrayList<String> DataStroage3 = new ArrayList<String>();

    public static ArrayList<String> DataStroage4 = new ArrayList<String>();

    public static ArrayList<String> DataStroage5 = new ArrayList<String>();

    public static ArrayList<String> DataStroage6 = new ArrayList<String>();



    /**
     * Main function
     *
     * @param args arguments
     */
    public static void main (String[] args)
    {
        ConsoleUI();

    }

    /**
     * User interface
     */
    private static void ConsoleUI ()
    {
        boolean AppOn = true;
        while (AppOn)
        {
/*            //Ask for the number of strings to generate
            System.out.println("Please inter the number of Strings to generate");
            int tempNum = scanner.nextInt();
            while (tempNum <= 0)
            {
                System.out.print("InValide number");
                tempNum = scanner.nextInt();
            }
            numOfString = tempNum;


            // Generating and store strings in strings(ArrayList).
            randomString.setNumberOfStrings(numOfString);
            strings = randomString.CreateRandomStrings();


            //Calculate and display Insert time.
            CuckooInsertTimeMeasure();

            SeparateChainingInsertTimeMeasure();

            QuadraticProbingInsertTimeMeasure();

            //Ask for the number of strings to delete
            System.out.println("Please inter the number of Strings to delete");
            tempNum = scanner.nextInt();
            while (tempNum <= 0 || tempNum > numOfString)
            {
                System.out.print("InValide number");
                tempNum = scanner.nextInt();
            }
            numOfStringDelete = tempNum;

            //Get Strings in strings(ArrayList) which to delete
            randomString.GetSomeRandomStrings(numOfStringDelete);


            //Calculate and display Delete time.
            CuckooDeleteTimeMeasure();

            SeparateChainingTimeMeasure();

            QuadraticProbingTimeMeasure();*/

            for (int i = 1; i < 21; i++)
            {
                System.out.println("Round: " + i);
                //Task 3
                numOfString = (int) Math.pow(2, i);
                numOfStringDelete = numOfString;
                // Generating and store strings in strings(ArrayList).
                randomString.setNumberOfStrings(numOfString);
                strings = randomString.CreateRandomStrings();
                //Get Strings in strings(ArrayList) which to delete
                randomString.GetSomeRandomStrings(numOfStringDelete);
                //Calculate and display Insert time.
                CuckooInsertTimeMeasure();

                SeparateChainingInsertTimeMeasure();

                QuadraticProbingInsertTimeMeasure();
                //Calculate and display Delete time.
                CuckooDeleteTimeMeasure();

                SeparateChainingTimeMeasure();

                QuadraticProbingTimeMeasure();

                //Prepare for next round
                cuckoo.makeEmpty();
                sep.makeEmpty();
                quadratic.makeEmpty();

            }
            System.out.println("CInsert:");
            for (String s : DataStroage1)
            {
                System.out.println(s);
            }
            System.out.println("SInsert:");
            for (String s : DataStroage2)
            {
                System.out.println(s);
            }
            System.out.println("QInsert:");
            for (String s : DataStroage3)
            {
                System.out.println(s);
            }
            System.out.println("CDelete:");
            for (String s : DataStroage4)
            {
                System.out.println(s);
            }
            System.out.println("SDelete:");
            for (String s : DataStroage5)
            {
                System.out.println(s);
            }
            System.out.println("QDelete:");
            for (String s : DataStroage6)
            {
                System.out.println(s);
            }
            // End App
            AppOn = false;
        }
    }

    /**
     * Measure CuckooHashTable insert time and print it
     */
    private static void CuckooInsertTimeMeasure ()
    {
        long time = 0;
        for (int i = 0; i < numOfString; i++)
        {
            long startTime = System.nanoTime();
            cuckoo.insert(strings.get(i));
            long endTime = System.nanoTime();
            time += (endTime - startTime);
        }
        time /= numOfString;
        System.out.println("CuckooHashTable Insert Time: " + time);
        DataStroage1.add(String.valueOf(time));
    }

    /**
     * Measure SeparateChainingHashTable insert time and print it
     */
    private static void SeparateChainingInsertTimeMeasure ()
    {
        int time = 0;
        for (int i = 0; i < numOfString; i++)
        {
            long startTime = System.nanoTime();
            sep.insert(strings.get(i));
            long endTime = System.nanoTime();
            time += (endTime - startTime);
        }
        time /= numOfString;
        System.out.println("SeparateChainingHashTable Insert Time: " + time);
        DataStroage2.add(String.valueOf(time));
    }

    /**
     * Measure QuadraticProbingHashTable insert time and print it
     */
    private static void QuadraticProbingInsertTimeMeasure ()
    {
        int time = 0;
        for (int i = 0; i < numOfString; i++)
        {
            long startTime = System.nanoTime();
            quadratic.insert(strings.get(i));
            long endTime = System.nanoTime();
            time += (endTime - startTime);
        }
        time /= numOfString;
        System.out.println("QuadraticProbingHashTable Insert Time: " + time);
        DataStroage3.add(String.valueOf(time));
    }


    /**
     * Measure CuckooHashTable delete time and print it
     */
    private static void CuckooDeleteTimeMeasure ()
    {
        long time = 0;
        for (String s : randomString.someStrings)
        {
            long startTime = System.nanoTime();
            cuckoo.remove(s);
            long endTime = System.nanoTime();
            time += (endTime - startTime);
        }
        time /= numOfStringDelete;
        System.out.println("CuckooHashTable Delete Time: " + time);
        DataStroage4.add(String.valueOf(time));
    }

    /**
     * Measure SeparateChainingHashTable delete time and print it
     */
    private static void SeparateChainingTimeMeasure ()
    {
        long time = 0;
        for (String s : randomString.someStrings)
        {
            long startTime = System.nanoTime();
            sep.remove(s);
            long endTime = System.nanoTime();
            time += (endTime - startTime);
        }
        time /= numOfStringDelete;
        System.out.println("SeparateChainingHashTable Delete Time: " + time);
        DataStroage5.add(String.valueOf(time));
    }

    /**
     * Measure QuadraticProbingTable delete time and print it
     */
    private static void QuadraticProbingTimeMeasure ()
    {
        long time = 0;
        for (String s : randomString.someStrings)
        {
            long startTime = System.nanoTime();
            quadratic.remove(s);
            long endTime = System.nanoTime();
            time += (endTime - startTime);
        }
        time /= numOfStringDelete;
        System.out.println("QuadraticProbingHashTable Delete Time: " + time);
        DataStroage6.add(String.valueOf(time));
    }
}
