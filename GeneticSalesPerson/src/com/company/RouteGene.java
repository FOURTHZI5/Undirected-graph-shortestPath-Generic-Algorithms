package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RouteGene implements Comparable<RouteGene> {
    private int[] DNA;
    private float wholeRouteDistance = 10000;
    protected static float[][] mapDistance;

    static Random random = new Random();

    public RouteGene (RouteGene Dad, RouteGene Mom) {
        System.out.print("?");
        DNA = new int[Dad.getDNA().length];

        for (int i = 0 ; i < Dad.getDNA().length ; i++) DNA[i] = -1;
        /*System.out.print("IniDNA->");
        System.out.print("><" + Arrays.toString(Mom.getDNA()) + " ");
        System.out.print("!" + Arrays.toString(Dad.getDNA()));*/

        bornFromParent(Dad.getDNA(), Mom.getDNA());
        //System.out.print("MergeDNA->");
        bornwithMutation();
        //System.out.print("MuteDNA --|  ");
    }

    public RouteGene (int[] DNA) {
        this.DNA = DNA;
        System.out.println(Arrays.toString(DNA));
    }

    public int[] getDNA () {
        return this.DNA;
    }

    public static void setMapDistance(float[][] mapDistance) {
        RouteGene.mapDistance = mapDistance;
    }

    public void bornFromParent (int[] dadDNA, int[] momDNA) {
        //System.out.print(" -->| Here Bay come!");
        Set babyDNASet = new HashSet();

        //add ramdomly half sequence of dadDNA into the baby bluePrint
        int i = random.nextInt(dadDNA.length);

        for ( ; babyDNASet.size() <= dadDNA.length/2 ; i = (i + 1) % dadDNA.length ) {
            DNA[i] = dadDNA[i];
            babyDNASet.add(dadDNA[i]);
        }
        //System.out.print(" ->absorDAD");

        //add mom DND into to the blank of the baby, better at sequence but whatever is OK
        while (babyDNASet.size() < dadDNA.length) {
            if (!babyDNASet.contains(momDNA[i])) {
                int hashi = i;
                while (DNA[hashi] != -1) {
                    hashi = (hashi + 1) % DNA.length;
                }
                DNA[hashi] = momDNA[i];
                babyDNASet.add(momDNA[i]);
            }
            i = (i + 1) % momDNA.length;
        }
        //System.out.print(" ->absorMOM");

        //calculate the distance of the genetic
        wholeRouteDistance = mapDistance[DNA[0]][DNA[DNA.length-1]];
        for (i = 0 ; i + 1 < DNA.length ; i++) wholeRouteDistance += mapDistance[DNA[i]][DNA[i+1]];

    }

    public float getWholeRouteDistance() {
        return wholeRouteDistance;
    }

    /**
     * with 5% probability of Swapping two elements of the gene
     */
    public void bornwithMutation (){

        for (int i = 0 ; i < DNA.length ; i++) {
            if (random.nextInt(20) == 10) {
                randomSwapGene(i, random.nextInt(DNA.length));
            }
        }
    }

    public void randomSwapGene (int i1, int i2) {
        int prium = DNA[i1];
        DNA[i1] = DNA[i2];
        DNA[i2] = prium;
    }

    @Override
    public int compareTo(RouteGene o) {
        return (int) (this.wholeRouteDistance - o.wholeRouteDistance);
    }

    public void printMap () {
        if (DNA != null) {
            System.out.println(Arrays.toString(mapDistance));
        }
    }

}
