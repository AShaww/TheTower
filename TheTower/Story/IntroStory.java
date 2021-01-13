package Story;

public class IntroStory implements TellStory {

    @Override
    public void tellStory() {
        
        System.out.println("----------------------------------------------------------------------- ");
        System.out.println(" -- You look up to see a large inconspicuous tower with a small door -- ");
        System.out.println(" ---------------------------------------------------------------------- ");
        System.out.println(" -------------- You decide to open it and squeeze through, ------------- ");
        System.out.println(" ------------- The door shuts behind you with a loud bang. ------------- ");
        System.out.println(" - Upon entering you see a chest, intrigued you walk over and peer in, - ");
        System.out.println(" ------- inside you see some weapons, deciding on which to pick - ------ ");
        System.out.println();
        System.out.println("########################################################################");
        System.out.println(" ----------------- Type a letter to select a weapon ------------------- ");
        System.out.println();
        System.out.println(" --- Enter 's' for Shotgun");
        System.out.println(" --- Enter 'r' for Rifle");
        System.out.println(" --- Enter 'm' for MP5");
        System.out.println("########################################################################");
    
    }
}
