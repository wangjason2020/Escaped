import java.util.Scanner;

public class Main {

    public static int room=1;
    public static int turnsLeft=30;
    public static boolean doorLocked=true;
    public static boolean hasMatches=false;
    public static boolean doorOpen=false;
    public static boolean chestOpen=false;
    public static boolean hasPen=false;
    public static boolean trumpetPlayed=false;
    public static boolean pianoPlayed=false;

    public static void main(String[] args) {
	// write your code here
        roomDescription();
        promptUser();
    }

    public static void promptUser() {
        System.out.print(">> ");
        Scanner a=new Scanner(System.in);
        String command=a.nextLine();

        if (command.equals("help")) {
            System.out.println("List of verb commands: open, close, light, read, write, play, look, get, go");
            System.out.println("List of noun commands: door, room, bench, chest, candle, note, matches, shelves, shelf, book, pen, scroll, music, trumpet, piano, drum, lock, north, south, east, west");
        }

        if (command.equals("look")) {
            roomDescription();
            turnsLeft();
        }

        if (command.equals("look room")) {
            roomDescription();
            turnsLeft();
        }

        if (command.equals("look candle")) {
            System.out.println("The candle in the center of the room is not lit.");
            turnsLeft();
        }

        if (command.equals("look bench")) {
            System.out.println("There is a bench on the western wall. On top of the bench, there is a small note.");
            turnsLeft();
        }

        if (command.equals("read note")) {
            System.out.println("The note says: May my light show you the way.");
            turnsLeft();
        }

        if (command.equals("look note")) {
            System.out.println("There is a note on top of the bench.");
            turnsLeft();
        }

        if (command.equals("look chest")) {
            System.out.println("The chest is closed. It does not seem to be locked.");
            turnsLeft();
        }

        if (command.equals("open chest")) {
            System.out.println("Inside the chest, there is a box of matches.");
            chestOpen=true;
            turnsLeft();
        }

        if (command.equals("get matches")) {
            if (chestOpen==true) {
                System.out.println("You take the box of matches out of the chest.");
                hasMatches=true;
            }
            if (chestOpen==false) {
                System.out.println("You must open the chest first.");
            }
            turnsLeft();
        }

        if (command.equals("look matches")) {
            if (hasMatches==true) {
                System.out.println("It's a box of matches.");
            }
            if (hasMatches==false) {
                System.out.println("You need the matches first.");
            }
            turnsLeft();
        }

        if (command.equals("light candle")) {
            if (room==1) {
                if (hasMatches==true) {
                    System.out.println("You light the candle. You hear a loud metal grinding sound from the north.");
                    doorLocked = false;
                }
            }
            if (room!=1) {
                System.out.println("You light the candle.");
            }
            if (hasMatches==false) {
                System.out.println("You need to get the matches first.");
            }
            turnsLeft();
        }

        if (command.equals("look door")) {
            if (doorLocked==true) {
                System.out.println("The door is locked.");
            }
            if (doorLocked==false) {
                System.out.println("The door to the north is closed, but unlocked.");
            }
            turnsLeft();
        }

        if (command.equals("open door")) {
            if (doorLocked==true) {
                System.out.println("The door is locked.");
            }
            if (doorLocked==false) {
                System.out.println("The door opens.");
                doorOpen=true;
            }
            turnsLeft();
        }

        if (command.equals("go north")) {
            if (doorLocked==true) {
                System.out.println("The door is locked.");
            }
            if (doorLocked==false) {
                if (doorOpen==true) {
                    System.out.println("You leave the room.");
                    if (room==1) {
                        room=room+1;
                        doorLocked=true;
                        doorOpen=false;
                        roomDescription();
                        promptUser();
                    }
                    if (room==2) {
                        room=room+1;
                        doorLocked=true;
                        doorOpen=false;
                        roomDescription();
                        promptUser();
                    }
                    if (room==3) {
                        System.out.println("You made it out of the escape room! Congratulations!");
                        System.exit(1);
                    }
                }
                if (doorOpen==false) {
                    System.out.println("You must open the door first.");
                }
            }
            turnsLeft();
        }

        if (command.equals("look shelves")) {
            if (room==2) {
                System.out.println("The shelves are lined with books. Upon closer inspection, you notice there is an open book on one of the shelves.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look shelf")) {
            if (room==2) {
                System.out.println("The shelves are lined with books. Upon closer inspection, you notice there is an open book on one of the shelves.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look desk")) {
            if (room==2) {
                System.out.println("It's a nice rectangular desk. Probably mahogany.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look book")) {
            if (room==2) {
                System.out.println("You see a book protruding from the shelves.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look pen")) {
            if (room==2) {
                System.out.println("It's a nice pen.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look scroll")) {
            if (room==2) {
                System.out.println("There is a scroll on top of the desk.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("read book")) {
            if (room==2) {
                    System.out.println("The book is titled: The Autobiography of...");
                }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("read scroll")) {
            if (room==2) {
                System.out.println("The scroll says: Share your story.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("get pen")) {
            if (room==2) {
                System.out.println("You pick up the pen.");
                hasPen=true;
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("write book")) {
            if (room==2) {
                if (hasPen==true) {
                        System.out.println("You write your name in the empty space. You hear a loud metal grinding sound from the north.");
                        doorLocked=false;
                }
                if (hasPen==false) {
                    System.out.println("You need to get the pen first.");
                }
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look trumpet")) {
            if (room==3) {
                System.out.println("It's a trumpet.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look piano")) {
            if (room==3) {
                System.out.println("It's a piano.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look drum")) {
            if (room==3) {
                System.out.println("It's a drum.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look music")) {
            if (room==3) {
                System.out.println("There is a music sheet on a stand in the middle of the room.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("read music")) {
            if (room==3) {
                System.out.println("The music sheet is empty, but has this phrase written on the musical staff: Timbre, Tone, and Time.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("play trumpet")) {
            if (room==3) {
                    System.out.println("You play the trumpet.");
                    trumpetPlayed=true;
                }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("play piano")) {
            if (room==3) {
                if (pianoPlayed==true) {
                    System.out.println("You play the piano but nothing happens. Maybe try playing the instruments in a different order.");
                    trumpetPlayed=false;
                }
                if (pianoPlayed==false) {
                    if (trumpetPlayed==true) {
                        System.out.println("You play the piano.");
                        pianoPlayed=true;
                    }
                    if (trumpetPlayed==false) {
                        System.out.println("You play the piano but nothing happens. Maybe try playing the instruments in a different order.");
                    }
                }
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("play drum")) {
            if (room==3) {
                if (trumpetPlayed==true) {
                    if (pianoPlayed==true) {
                        System.out.println("You play the drum. You hear a loud metal grinding sound from the north.");
                        doorLocked=false;
                    }
                }
                if (trumpetPlayed==false||pianoPlayed==false) {
                    System.out.println("You play the drum but nothing happens. Maybe try playing the instruments in a different order.");
                    trumpetPlayed=false;
                    pianoPlayed=false;
                }
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

            if (!(command.equals("help"))) {
                if (!(command.equals("look"))) {
                    if (!(command.equals("look candle"))) {
                        if (!(command.equals("look bench"))) {
                            if (!(command.equals("read note"))) {
                                if (!(command.equals("look chest"))) {
                                    if (!(command.equals("open chest"))) {
                                        if (!(command.equals("get matches"))) {
                                            if (!(command.equals("light candle"))) {
                                                if (!(command.equals("look door"))) {
                                                    if (!(command.equals("open door"))) {
                                                        if (!(command.equals("go north"))) {
                                                            if (!(command.equals("look note"))) {
                                                                if (!(command.equals("look room"))) {
                                                                    if (!(command.equals("look matches"))) {
                                                                        if (!(command.equals("look shelves"))) {
                                                                            if (!(command.equals("look pen"))) {
                                                                                if (!(command.equals("look desk"))) {
                                                                                    if (!(command.equals("look book"))) {
                                                                                        if (!(command.equals("look scroll"))) {
                                                                                            if (!(command.equals("read book"))) {
                                                                                                if (!(command.equals("read scroll"))) {
                                                                                                    if (!(command.equals("get pen"))) {
                                                                                                        if (!(command.equals("write book"))) {
                                                                                                            if (!(command.equals("look trumpet"))) {
                                                                                                                if (!(command.equals("look piano"))) {
                                                                                                                    if (!(command.equals("look drum"))) {
                                                                                                                        if (!(command.equals("look music"))) {
                                                                                                                            if (!(command.equals("read music"))) {
                                                                                                                                if (!(command.equals("play trumpet"))) {
                                                                                                                                    if (!(command.equals("play piano"))) {
                                                                                                                                        if (!(command.equals("play drum"))) {
                                                                                                                                                    if (!(command.equals("look shelf"))) {
                                                                                                                                                        System.out.println("You cannot do that.");
                                                                                                                                                        turnsLeft();
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        if (turnsLeft==0) {
            System.out.println("Game Over");
            System.exit(1);
        }
        promptUser();
    }

    public static void roomDescription() {
        if (room==1) {
            System.out.println("You wake up in an unknown foyer. You don't remember anything. To your north, there is a locked door. In the room, there is a bench, a chest, an unlit candle, and a note. Escape the room in 30 turns. Type help for options.");
        }
        if (room==2) {
            System.out.println("You enter a library with stacks of books lining the shelves. There is a desk, a pen, and a scroll. The door to the north is locked. Type help for options.");
        }
        if (room==3) {
            System.out.println("You enter a conservatory with three instruments: a trumpet, a drum, and a piano. There is a piece of sheet music in the center of the room. On the north side of the room, there is a locked door. Type help for options.");
        }
    }

    public static int turnsLeft() {
        turnsLeft=turnsLeft-1;
        System.out.println("You have "+turnsLeft+" turns left to escape.");
        return turnsLeft;
    }

}
