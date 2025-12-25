/**
 @authors Noa Shem Tov  , Linoy Nisim Pur  */
 */
package animals;

import animals.Genders;
import mobility.Point;
import Olympics.Medal;

import java.time.*;
import java.util.concurrent.CountDownLatch;

import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;

import Graphics.CompetitionPanel;

/**
 * participant - The animal that advances
 * neededDistance - The distance the animal has to travel
 * startFlag - sign that the competittion has started this is a common sign for the participants of the competition
 * finishFlag - sign that the competittion is finished this is a common sign for the participants of the competition
 * - SleepTime - the time that thread will sleep
 */
public class AnimalThread implements Runnable {
    private Animal participant;
    private double neededDistance;
    private Boolean[] startFlag;
    private Boolean[] finishFlag;
    private static int SleepTime = 1000;
    private Object classLock = new Object();
    private CompetitionPanel panel;
    //for checking
    LocalDateTime currentDateTime = LocalDateTime.now();

    /**
     * Creating an instance of the trade by receiving parameters
     *
     * @param participant
     * @param neededDistance
     * @param startFlag
     * @param finishFlag
     */
    public AnimalThread(Animal participant, double neededDistance, Boolean[] startFlag, Boolean[] finishFlag, CompetitionPanel pan, Object classLock, int SleepTime) {
        this.participant = participant;
        this.neededDistance = neededDistance;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        this.panel = pan;
        this.classLock = classLock;
        this.SleepTime = SleepTime;

    }

    @Override
    public void run() {
        waitingForStart();
        if (!Thread.currentThread().isInterrupted()) {
            animalMove();
        } else {
            System.out.println("The trade does not exist");
        }
        synchronized (classLock) {
            //הוספת IF
           // if (participant.getLocation().equals(participant.GetFinish())) {
                startFlag[0] = false;
                finishFlag[0] = true;
                System.out.println("finisht: " + currentDateTime);
                classLock.notifyAll();
          //  }
        }
    }

    /**
     * As long as the animal has not received a signal to start, it waits
     */
    private void waitingForStart() {
        synchronized (classLock) {
            while (!startFlag[0]) {
                try {
                    classLock.wait();
                    System.out.println(participant.getAnimaleName() + "waiting.." + LocalDateTime.now());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            classLock.notifyAll();
        }
    }

    /**
     * Responsible for moving the animal. When moving the animal, it prevents unexpected changes by locking the participant field
     */
    public void animalMove() {
        System.out.println(neededDistance);
        try {
            synchronized (participant) {
                Thread.sleep(SleepTime);
                // שימוש ב-CountDownLatch להמתנה לסיום פעולת הטיימר
                CountDownLatch latch = new CountDownLatch(1);
                Timer timer = new Timer(1000, e -> {
                    panel.moveAnimal(participant);
                    latch.countDown(); // מפחית את הקאונטר של CountDownLatch כאשר הפעולה מסתיימת
                });
                timer.start();
                latch.await(); // המתנה לסיום הטיימר
                panel.repaint();
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Responsible for signaling the animal to begin its part of the competition
     */
    public synchronized void startMovement() {
        synchronized (classLock) {
            this.startFlag[0] = true;
            classLock.notifyAll();
        }
    }

}