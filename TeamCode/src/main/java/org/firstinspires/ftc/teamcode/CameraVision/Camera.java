package org.firstinspires.ftc.teamcode.CameraVision;

import java.lang.Runnable;


//A runnable is a java interface which is used to encapsulate a single task that later will be run on it's own
//separate thread. It doesn't HAVE to run on a different thread, but that's what everyone uses it for.
public class Camera implements Runnable{
    private volatile boolean running = true; //I've got no clue what "volatile" does

    @Override //If you don't add this annotation, then the run() code is replaced by the default, which is blank
    public void run(){
        while (running && !Thread.currentThread().isInterrupted()){

            //PUT CODE HERE

            try {
                Thread.sleep(20); //We sleep so that we don't hog the CPU
            } catch (InterruptedException e){ //"e" is a variable that stores the exception. We don't use it
                Thread.currentThread().interrupt();
            }
        }
    }

    public void end(){
        running = false;
    }
}
