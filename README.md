# INFO6205_TEAM"310"_Undirected-graph-shortestPath-Generic-Algorithms
Undirected graph shortestPath Generic Algorithms

This is a program monitor the salesman shortest-path problem using genetic algorithms.
A salesman must go from one city and then the remaining cities, finally come back to the original city.
During the whole process, the salesman can only reach each city once.
The Aim of the problem is to find the comparably shortest path of the map.

In our project, the number of vertex of the map can be choose but the coordinate of each node is generated randomly.
Each time, the result of the shortest path can not be the same.

----------------------------------------------------------------------------------------------------------------

1. When start the programme, an instance of "TravellerMapInfo" will create a Map contains N cities with random coordinate;
2. After that, one instance of "multiplication" will begin to produce 100 "Generation" of DNA libraries, each generation of DNA was produced by the original generation;
3. During each generation, in each instance of "GeneticFindPathOfOneGeneration", a list of baby gene will be created accoding to the previous generation;
4. In each generation, only 200 shortest path will be chosen and thier gene could be kept in the DNA library. Their gene can be recorded can be used to produce baby in next generation.
5. (We choose to make 100 generations for not enter into a dead loop).

-----------------------------------------------------------------------------------------------------------------

"DNA" part
- in each "RouteGene", the DNA is stored as an simple list.
  - if there are 10 vertex in the map, the DNA will be stored like [3, 7, 2, 8, 5, 4, 9, 6, 1, 0], that means the salesman       will come first come the city "3", then go to city "7", then to "2" ... to "0" , and finally back to "3";
  - each DNA was generated from two differnt parents, for example, the babyDNA can generated from the two previous DNA :
    DadDNA: [9, 7, 2, 8, 3, 4, 5, 1, 6, 0]    &    MomDNA: [0, 2, 9, 7, 5, 4, 1, 3, 8, 6]
    We can catch the five elements from DadDNA to build the BabyDNA: [ ,  , 2, 8, 3, 4, 5,  ,  ,  ]
    Then catch other DNA from MomDNA and the BabyDNA look like this: [0,  , 2, 8, 3, 4, 5,  ,  ,6 ]
    Then fill the BabyDNA using the sequence of MomDNA but not the exactly same position: [0, 1, 2, 8, 3, 4, 5, 9, 7, 6]
    The "crossover" step finished.
  - We build a 5% probability to generate the DNA mutation situation.
    For each babyDNA, each node have 5% probability randomly swap with the later node.
    That is the final step to generate a BabyDNA (They will be sorted and only 200 shortest one can be chosen)
 
