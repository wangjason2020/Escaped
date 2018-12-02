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
            System.out.println("List of verb commands: open | close | light | read| write | play | look | get | go");
            System.out.println("List of noun commands: door | room | bench | chest | candle | note | matches | shelves | shelf | book | pen | scroll | music | trumpet | piano | drum | lock | north | south | east | west");
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
            System.out.println("The candle in the center of the room is not lit. If only there was something to light it with.");
            turnsLeft();
        }

        if (command.equals("look bench")) {
            System.out.println("There is a bench on the western wall. You are tempted to sit on it, but you decide against it. On top of the bench, there is a small note with something printed in messy handwriting.");
            turnsLeft();
        }

        if (command.equals("read note")) {
            System.out.println("After carefully examining the note, you determine it says: May my light show you the way.");
            turnsLeft();
        }

        if (command.equals("look note")) {
            System.out.println("There is a note on top of the bench. Maybe you should read it.");
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
                System.out.println("It's a box of matches. I wonder what they're for.");
            }
            if (hasMatches==false) {
                System.out.println("You need the matches first.");
            }
            turnsLeft();
        }

        if (command.equals("light candle")) {
            if (room==1) {
                if (hasMatches==true) {
                    System.out.println("You carefully strike the match, watching it catch ablaze. You use the match to light the candle. Suddenly, you hear a loud metal grinding sound from the north.");
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
                System.out.println("The door is locked. You come to the conclusion that you need to do something for it to open.");
            }
            if (doorLocked==false) {
                System.out.println("The door to the north is closed, but unlocked.");
            }
            turnsLeft();
        }

        if (command.equals("open door")) {
            if (doorLocked==true) {
                System.out.println("The door is locked. You come to the conclusion that you need to do something for it to open.");
            }
            if (doorLocked==false) {
                System.out.println("You slowly twist the handle and open the door.");
                doorOpen=true;
            }
            turnsLeft();
        }

        if (command.equals("go north")) {
            if (doorLocked==true) {
                System.out.println("The door is locked. You come to the conclusion that you need to do something for it to open.");
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
                        System.out.println("You go through the last doorway as you catch a glimpse of light. As you step outside, you find yourself in a vast green forest. It appears you made it out of the escape room! Congratulations! Now where do we go from here...");
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
                System.out.println("The shelves are lined with thousands of books. Upon closer inspection, you notice there is an open book on one of the shelves.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look shelf")) {
            if (room==2) {
                System.out.println("The shelves are lined with thousands of books. Upon closer inspection, you notice there is an open book on one of the shelves.");
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
                System.out.println("You see a book protruding from the shelves. Maybe you should read it.");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look pen")) {
            if (room==2) {
                System.out.println("It's a nice pen. ");
            }
            if (room!=2) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look scroll")) {
            if (room==2) {
                System.out.println("There is a scroll on top of the desk. Maybe you should read it.");
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
                System.out.println("It's a nice trumpet.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look piano")) {
            if (room==3) {
                System.out.println("It's a nice piano.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look drum")) {
            if (room==3) {
                System.out.println("It's a nice drum.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("look music")) {
            if (room==3) {
                System.out.println("There is a music sheet on a stand in the middle of the room. Maybe you should read it.");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("read music")) {
            if (room==3) {
                System.out.println("The music sheet is empty, but has this phrase written on the musical staff: Timbre, Tone, and Time. Maybe each of these words correspond to a different instrument...");
            }
            if (room!=3) {
                System.out.println("You cannot do that.");
            }
            turnsLeft();
        }

        if (command.equals("play trumpet")) {
            if (room==3) {
                    System.out.println("You blow the dust off of the trumpet and play it. It sounds awful.");
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
                        System.out.println("Even though you have no memory of ever playing the piano, you miraculously play it and it sounds good.");
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
                        System.out.println("You smack the drum as hard as you can. You hear a familiar loud metal grinding sound from the north.");
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
            System.out.println("Game Over. It appears you will be eternally trapped in this escape room...");
            System.exit(1);
        }
        promptUser();
    }

    public static void roomDescription() {
        if (room==1) {
            System.out.println("As the metal door shuts and locks, you snap awake. You immediately jump up and start banging on the door, screaming for them to let you out. After realizing that you were trapped, you examine your surroundings. You appear to be in a large foyer. To your north, there is the large metal door that was just locked. In the room, there is a wooden bench, a small chest, an unlit candle, and a note. Panic sets in as you realize that you don't remember anything except for your name: Doug. You have no idea how you got there; all you know is that you need to escape. Using these items and actions, escape the room in 30 turns or less. Type help for options. Good luck!");
        }
        if (room==2) {
            System.out.println("Relief sets in as you go through the door, thinking you escaped. However, you soon realize that this was not the end, but merely the beginning. Once again, you examine your surroundings. You appear to be in a library with stacks of books lining the shelves. Next to one of the shelves, there is a desk with a a pen and scroll on top of it. There is another door to the north that is locked. You come to the conclusion that you must again use these items to try to escape the room. Type help for options.");
        }
        if (room==3) {
            System.out.println("Once again, you enter an unfamiliar room. It appears to be a conservatory with three instruments inside: a trumpet, a drum, and a piano. They all look very old and unused, since there is a layer of dust on top of each. There is a piece of sheet music in the center of the room on a stand. On the north side of the room, the door is unsurprisingly locked. You sigh in defeat, but ultimately resolve to continue to try to escape. Type help for options.");
        }
    }

    public static int turnsLeft() {
        turnsLeft=turnsLeft-1;
        System.out.println("You have "+turnsLeft+" turns left to escape.");
        return turnsLeft;
    }

}
