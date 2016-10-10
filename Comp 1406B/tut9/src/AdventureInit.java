public class AdventureInit{    
  
  public static Room init(int numRooms){
    // create a game with numRooms rooms in it
    // main entrance
    Room start = new Room("You are in the main entrence of the castle", 0, 20);
    start.people = new Player[]{ new Player("Butler", 0, 0, "Welcome.  Please have a look around and enjoy your visit.") };
        
        if(numRooms>=2){
            start.numExits = 3;
            start.exit[0] = new Room("You are in the coat room", 10, 0);
            start.exit[0].exit[1] = start; // these rooms are connected
            start.exit[0].numExits = 1;
        }
        if(numRooms>=3){  
            start.exit[1] = new Room("You are in the main hallway", 0, 0);
            start.exit[1].exit[0] = start; // these rooms are connected
            start.exit[1].numExits = 1;
        }
        if(numRooms>=4){
            start.exit[3] = new Room("You are in a kitchen", 5, 4);
            start.exit[3].exit[2] = start; // these rooms are connected
            start.exit[3].numExits = 2;
        }
        //
        // build up more rooms!
        // 
        if(numRooms>=5){
            start.exit[3].exit[1] = new Room("pantry", 0, 50);
            start.exit[3].exit[1].exit[1] = start.exit[3];//connection
            start.exit[3].exit[1].numExits = 1;
            
            start.exit[3].exit[1].hiddenDoor = start.exit[0];//coatroom
            start.exit[0].hiddenDoor = start.exit[3].exit[1];//connection
            start.exit[0].numExits += 1;
        }
        if(numRooms>=6){
            start.exit[1].exit[1] = new Room("Banquet hall", 20, 10);
            start.exit[1].exit[1].exit[1] = start.exit[1];//connection
            start.exit[1].exit[1].numExits = 1;
        }
        if(numRooms>=7){
            start.exit[1].exit[2] = new Room("kings tower", 0, 0);
            start.exit[1].exit[2].exit[1] = start.exit[1];//connection
            start.exit[1].exit[2].numExits = 1;
        }
        if(numRooms>=8){
            start.exit[1].exit[2].exit[2] = new Room("kings tower", 0, 0);
            start.exit[1].exit[2].exit[1] = start.exit[1];//connection
            start.exit[1].exit[2].numExits = 1;
        }
    
    return start;
  }
  
  
}   