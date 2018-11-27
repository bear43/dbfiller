package com.hiber.Util;

import java.util.Collection;
import java.util.Random;

public class Picker
{
    public static Random r = new Random();
    public static Object pickFromCollection(Collection collection)
    {
        if(collection == null || collection.size() == 0) return null;
        int collectionSize = collection.size();
        int randomIndex = r.nextInt(collectionSize);
        int counter = 0;
        for(Object obj : collection)
        {
            if(counter == randomIndex) return obj;
            counter++;
        }
        return collection.iterator().next();
    }
}
