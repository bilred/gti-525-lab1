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


public class Timers {
	private Timer timer_1;

	private Timer timer_2;
	public static void main(String[] args) {


		new Timers(6);

		}

	public Timers(int t1) {


		       timer_1 = new Timer();

		       timer_1.schedule(new TaskMaster(),  t1 * 1000);





	}
}
