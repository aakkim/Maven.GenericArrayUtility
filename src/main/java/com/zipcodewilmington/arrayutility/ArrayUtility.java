package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] array;

    public ArrayUtility(T[] inputArray) {
        array = inputArray;
        //assign parameter array to field array to use/access throughout this class
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        //create a new array where .getClass() will return the Class object representing the type.
        //.getComponentType() gets the type of the given array. for example, if arrayToMerge is an Integer[],
        //this will return the Class object representing Integer.
        //Array.newInstance(componentType(class object representing component type like Integer), length(length of new array))
        T[] newArray = (T[]) Array.newInstance(arrayToMerge.getClass().getComponentType(), array.length+arrayToMerge.length);
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(arrayToMerge, 0, newArray, array.length, arrayToMerge.length);
        /*
        System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        src: source array from which elements will be copied
        srcPos: starting index in source array from which to begin copying elements
        dest: destination array where elements will be copied
        destPos: starting index in destination array where the copied elements will be placed
        length: number of elements to copy from the source array to the destination array
         */
        int count = 0;
        for(T n:newArray) {
            if(n.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        //create a new array where .getClass() will return the Class object representing the type.
        //.getComponentType() gets the type of the given array. for example, if arrayToMerge is an Integer[],
        //this will return the Class object representing Integer.
        //Array.newInstance(componentType(class object representing component type like Integer), length(length of new array))
        T[] newArray = (T[]) Array.newInstance(arrayToMerge.getClass().getComponentType(), array.length+arrayToMerge.length);
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(arrayToMerge, 0, newArray, array.length, arrayToMerge.length);
        /*
        System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        src: source array from which elements will be copied
        srcPos: starting index in source array from which to begin copying elements
        dest: destination array where elements will be copied
        destPos: starting index in destination array where the copied elements will be placed
        length: number of elements to copy from the source array to the destination array
         */
        int maxCount = 0;
        //to store the number of occurrences of the element with the most occurrences
        T element = null;
        //to return the element with the most occurrence
        for(T n:newArray) {
            if(getNumberOfOccurrences(n) > maxCount) {
                maxCount = getNumberOfOccurrences(n);
                element = n;
            }
        }
        return element;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;//increase counter every time an element in the array equals valueToEvaluate

        for(int i=0; i<array.length; i++) {
            if(array[i]==valueToEvaluate) {
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        int idx = 0;
        //get number of occurrences of the value to remove and deduct from array length when creating new array
        int size = getNumberOfOccurrences(valueToRemove);
        T[] newArray = (T[]) Array.newInstance(valueToRemove.getClass(), array.length-size);
        //to initialize generic array, needs two parameters: first to specify the type of object inside the new array
        //second parameter specifies how much space to create for the array
        for (int i = 0; i < array.length; i++) {
            if(!(array[i]==valueToRemove)) {
                newArray[idx] = array[i];
                idx++;
            }
        }
        return newArray;
    }
}
