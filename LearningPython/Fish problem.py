
alphaShark = int(2);
alphaTank = int(4);
betaShark = int(4);
betaTank = int(2);
shark = 0;

for shark in 1,3,5,6,7:
   for tank in range(50):
        for counter in range(10):
                y = (alphaTank*tank)+(betaTank*tank)+int(shark)+alphaShark+betaShark+(counter*tank)
                if y == 50:
                    print("fish per tank",tank);
                    print("sharks in sector c",shark);
                    print("Number of tanks in sector c", counter);

        
