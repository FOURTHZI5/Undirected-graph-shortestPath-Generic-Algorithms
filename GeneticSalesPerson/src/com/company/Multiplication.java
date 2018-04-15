package com.company;


import java.util.Arrays;

public class Multiplication {

    int n;

    public Multiplication(int n) {
        this.n = n;

    }

    public void beginMulti () {

        TravellerMapInfo mapInfo = new TravellerMapInfo(n);

        int[] AdamDNA = new int[n];
        for (int i = 0; i < n ; i++) AdamDNA[i] = i;

        int[] EvaDNA = new int[n];
        for (int i = 0; i < n ; i++) EvaDNA[i] = n - 1 - i;

        RouteGene[] firstPairRoute = new RouteGene[2];
        firstPairRoute[0] = new RouteGene(AdamDNA);
        firstPairRoute[0].setMapDistance(mapInfo.getMapDistance());
        //firstPairRoute[0].printMap();
        firstPairRoute[1] = new RouteGene(EvaDNA);
        //firstPairRoute[1].printMap();

        GeneticFindPathOfOneGeneration previousGeneration = new GeneticFindPathOfOneGeneration(firstPairRoute);
        //System.out.println("FINISH PARENTS' GENERATION");
        previousGeneration.massiveDate(200);
        //System.out.println("FINISH PARENTS' MASSIVE DATE");
        GeneticFindPathOfOneGeneration nextGeneration;

        int Generation = 2;
        while (Generation < 100) {
            //System.out.println("COME INTO THE LOOP");
            nextGeneration = new GeneticFindPathOfOneGeneration(previousGeneration.getGenerationBaby(200));
            //System.out.println("BEGIN > "+ Generation + " < GENERATION");
            nextGeneration.massiveDate(200);
            //System.out.println("COMPLETE MASSIVE DATE");
            previousGeneration = nextGeneration;
            System.out.println("FINISH > "+ Generation + " < GENERATION");

            Generation++;
        }
    }
}
