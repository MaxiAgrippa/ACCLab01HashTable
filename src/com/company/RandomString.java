package com.company;

/**
 * @author Maxi Agrippa
 */

import java.util.*;
import java.lang.*;

public class RandomString
{
    /**
     * the number of strings that stored
     */
    private int numberOfStrings = 0;

    /**
     * Store Strings
     */
    public ArrayList<String> strings = new ArrayList<String>();

    /**
     * Store some of Strings in strings
     */
    public ArrayList<String> someStrings = new ArrayList<String>();

    /**
     * using StringBuffer to build a string
     */
    private StringBuffer string = new StringBuffer();

    /**
     * generate a "random" number
     */
    private Random random = new Random();

    /**
     * decide the length of each string
     */
    final private int StringLength = 10;

    /**
     * Alphabet that a string would use
     */
    final private String AlphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "qwertyuiopasdfghjklzxcvbnm";

    /**
     * Alphabet length
     */
    final private int AlphabetStringLength = 62;

    /**
     * Constructor empty
     */
    public RandomString ()
    {

    }

    /**
     * Constructor that Generate n Random strings
     *
     * @param n number of strings to generate
     */
    public RandomString (int n)
    {
        setNumberOfStrings(n);
        if (isNumberOfStringsValid(numberOfStrings))
        {
            CreateRandomStrings();
            GetSomeRandomStrings();
        }
    }

    /**
     * Create an Random String
     *
     * @return String
     */
    public String CreateARandomString ()
    {
        for (int i = 0; i < StringLength; i++)
        {
            string.append(AlphabetString.charAt(random.nextInt(62)));
        }
        return string.toString();
    }

    /**
     * Create Strings(numberOfStrings(int) of them)
     *
     * @return null/string (ArrayList\<String\>) String Collection
     */
    public ArrayList<String> CreateRandomStrings ()
    {
        if (isNumberOfStringsValid(numberOfStrings))
        {
            for (int j = 0; j < numberOfStrings; j++)
            {
                string.delete(0, string.length());
                for (int i = 0; i < StringLength; i++)
                {
                    string.append(AlphabetString.charAt(random.nextInt(62)));
                }
                strings.add(string.toString());
            }
            return strings;
        }
        return null;
    }

    /**
     * Get random number of Strings from strings.
     *
     * @return null/someStrings
     */
    public ArrayList<String> GetSomeRandomStrings ()
    {
        if (isNumberOfStringsValid(numberOfStrings))
        {
            //Generate unique random number list.
            ArrayList<Integer> integers = new ArrayList<Integer>();
            for (int i = 0; i < numberOfStrings; i++)
            {
                integers.add(i);
            }
            Collections.shuffle(integers);
            //Get strings
            int numOfStringsToGet = random.nextInt(numberOfStrings);
            for (int i = 0; i < numOfStringsToGet; i++)
            {
                someStrings.add(strings.get(integers.get(i)));
            }
            return someStrings;
        }
        return null;
    }

    public ArrayList<String> GetSomeRandomStrings (int n)
    {
        if (isNumberOfStringsValid(numberOfStrings) && isNumberOfStringsValid(n))
        {
            //Generate unique random number list.
            ArrayList<Integer> integers = new ArrayList<Integer>();
            for (int i = 0; i < numberOfStrings; i++)
            {
                integers.add(i);
            }
            Collections.shuffle(integers);
            //Get strings
            int numOfStringsToGet = n;
            for (int i = 0; i < numOfStringsToGet; i++)
            {
                someStrings.add(strings.get(integers.get(i)));
            }
            return someStrings;
        }
        return null;
    }


    /**
     * Get how much string
     *
     * @return the number of strings(int)
     */
    public long getNumberOfStrings ()
    {
        return numberOfStrings;
    }

    /**
     * Set how much string
     *
     * @param numberOfStrings
     */
    public void setNumberOfStrings (int numberOfStrings)
    {
        if (isNumberOfStringsValid(numberOfStrings))
        {
            this.numberOfStrings = numberOfStrings;
        }
    }

    /**
     * is the numberOfStrings attribute valid?
     *
     * @return true or false
     */
    public boolean isNumberOfStringsValid (int numberOfStrings)
    {
        return numberOfStrings > 0 ? true : false;
    }
}
