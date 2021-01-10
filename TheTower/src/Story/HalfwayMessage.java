/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Story;

/**
 *
 * @author AmirS
 */
public class HalfwayMessage implements TellStory {

    @Override
    public void tellStory() {
        System.out.println("\t#############################################################################");
        System.out.println("\t####            You are halway through the tower - keep going!           ####");
        System.out.println("\t#############################################################################");
    }
}
