package com.company;

import java.util.Random;

public class TravellerMapInfo {
    private CoordinateInfo[] mapCoordinate;
    private float[][] mapDistance;

    private int n; // whole num of the location

    static private Random random = new Random();

    public TravellerMapInfo (int n) {
        this.n = n;
        mapCoordinate = new CoordinateInfo[n];
        mapDistance = new float[n][n];
        generateMap();

    }

    //generate a map of location within 100*100
    private void generateMap () {
        for (int i = 0 ; i < n ; i++) {
            mapCoordinate[i] = new CoordinateInfo(100 * random.nextFloat(), 100 * random.nextFloat());

            for (int j = 0 ; j <= i ; j++) {
                mapDistance[i][j] = mapDistance[j][i] = getDistance(mapCoordinate[i], mapCoordinate[j]);
            }
        }
    }

    private float getDistance (CoordinateInfo p1, CoordinateInfo p2) {
        return (float)Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
    }

    public float[][] getMapDistance() {
        return mapDistance;
    }
}

