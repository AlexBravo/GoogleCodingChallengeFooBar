package com.alexbravo.googlecodingchallengefoobar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** Created by alex on 5/14/16. */

public class MinionInterrogation {

    public static LinkedHashMap<Double, Integer> sortMap(HashMap<Double, Integer> map) {
        List<Map.Entry<Double, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Double, Integer>>() {
            @Override
            public int compare(Map.Entry<Double, Integer> o1, Map.Entry<Double, Integer> o2) {
                return (o2.getKey()).compareTo(o1.getKey());
            }
        });
        LinkedHashMap<Double, Integer> returnVal = new LinkedHashMap<>();
        for (Map.Entry<Double, Integer> entry : list) {
            returnVal.put (entry.getKey(), entry.getValue());
        }
        return returnVal;
    }
    public static int[] answer(int[][] minions) {

        int answer[] = new int[minions.length];

        // Calculate expected times for each minion
        HashMap<Double, Integer> timesToInterrogate = new HashMap<>();
        for (int i = 0; i < minions.length; i++) {
            double probability = (double) (minions[i][1]) / minions[i][2];
            //double timeToInterrogate = probability;//* minions[i][0];
            timesToInterrogate.put(probability, i);
        }

        LinkedHashMap<Double, Integer> sorted = sortMap(timesToInterrogate);


        double minExpectedTime = 1024 * 50;

        HashMap<Double, Integer> expectedTimes = new HashMap<>();
        double expectedTime = 0;
        int totalTime = 0;
        double totalProbability = 1;
        int j = 0;
        for (LinkedHashMap.Entry<Double, Integer> entry : sorted.entrySet()) {
            if (j != minions.length - 1) {
                int time = minions[entry.getValue()][0];
                expectedTime += entry.getKey() * time;
                double probability = (double) (minions[entry.getValue()][1]) / minions[entry.getValue()][2];
                totalProbability *= probability;
                totalTime += time;
            } else {
                double guaranteeProbability = 1 - totalProbability;
                expectedTime += (totalTime + minions[entry.getValue()][0]) * guaranteeProbability;
            }

            answer[j] = entry.getValue();
            j++;
        }

        int[] bestAnswer = null;
        if (expectedTime < minExpectedTime) {
            minExpectedTime = expectedTime;
            bestAnswer = answer.clone();
        }


//        j = 0;
//        for (LinkedHashMap.Entry<Double, Integer> entry : sorted.entrySet()) {
//            answer[j++] = entry.getValue();
//        }


        return bestAnswer;
    }
}
