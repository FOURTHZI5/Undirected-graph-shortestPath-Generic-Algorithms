package com.company;

import java.util.*;

public class GeneticFindPathOfOneGeneration {

    private List<RouteGene> GenerationBaby;
    private RouteGene[] GenerationParents;

    private static Random random = new Random();

    int babyNeeded;

    public GeneticFindPathOfOneGeneration(RouteGene[] GenerationParents) {

        this.GenerationParents = GenerationParents;

        System.out.println("Begin Find Path");
    }

    public RouteGene[] getGenerationBaby(int ChooseEndWith) {
        /*System.out.println("Come to get GenerationBaby");

        for (RouteGene gene : GenerationBaby.subList(0, ChooseEndWith-1)) {
            System.out.println(Arrays.toString(gene.getDNA()));
        }*/

        RouteGene[] ChosenChildGeneration = new RouteGene[ChooseEndWith];
        return GenerationBaby.subList(0, ChooseEndWith).toArray(ChosenChildGeneration);
    }

    public void massiveDate (int babyNeeded) {

        //System.out.println("Massive Date start : ");

        this.babyNeeded = babyNeeded;
        int babyProductionPractice = babyNeeded * 2;
        GenerationBaby = new ArrayList<>(babyProductionPractice);

        //ont time create a baby: you should change the range of like (babyAccount * 2  more )

        for (int babycount = 0; babycount < babyProductionPractice ; babycount++) {
            int sper;
            int egg;
            //System.out.print("Second Come to massive baby Born : " + babycount + "  ");
            do {
                sper = random.nextInt(GenerationParents.length);
                egg = random.nextInt(GenerationParents.length);
            } while (sper == egg);
            //System.out.print("Got an egg and sper  ");
            RouteGene newBabyRoute = new RouteGene(GenerationParents[sper], GenerationParents[egg]);
            //System.out.print("New Baby  ");
            GenerationBaby.add(newBabyRoute);
            //newBabyRoute.printMap();
            //System.out.println("added : " + Arrays.toString(newBabyRoute.getDNA()));
        }
        //System.out.println("It means many baby was born! ");
        Collections.sort(GenerationBaby);

        for (RouteGene gene : GenerationBaby.subList(0,50)) {
            System.out.println (Arrays.toString(gene.getDNA()) + " D s a c :" + gene.getWholeRouteDistance());
        }System.out.println("===========================================================");
    }

}
