/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.gti525.commun;

/**
 *
 * @author shonguiz
 */
import java.util.Timer;
import java.util.TimerTask;




public class TimerEE extends Timer {
private int duree;
public TimerEE(int duree) {
	this.duree = duree;
	TimerTask task = new TimerTask() {
		  public void run() {
		    System.out.print("Test");
		    this.cancel();
		  }
		};
		this.schedule(task, duree);
}
}

