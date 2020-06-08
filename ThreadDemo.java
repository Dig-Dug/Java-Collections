

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Demo for thread creation and concurrent thread execution.
 * @author Sascha Baumeister
 */
public class ThreadDemo {

	static public void main (final String[] args) {
		final Runnable worker = () -> {
			for (int loop = 0; loop < 100000; ++loop) {
				System.out.println("Hello worker-thread world!");
				// throw new Error("yay, endlich!");
				try {
					Thread.sleep(100);
				} catch (final InterruptedException e) {
					// do nothing
				}
			}
		};
		final Thread thread = new Thread(worker, "worker-thread");
		thread.setDaemon(true);	// does not prevent VM from terminating!
		thread.setPriority(Thread.NORM_PRIORITY + 1);
		thread.setUncaughtExceptionHandler((t,e) -> Logger.getGlobal().log(Level.INFO, e.getMessage(), e));
		// thread.setContextClassLoader(classLoader);
		thread.start();		// starts a new thread and executes it asynchronously
		// thread.run();	// starts no thread and executes it synchronously within the main thread

		for (int loop = 0; loop < 10; ++loop) {
			System.out.println("Hello main-thread world!");
			try {
				Thread.sleep(100);
			} catch (final InterruptedException e) {
				// do nothing
			}
		}
	}
}