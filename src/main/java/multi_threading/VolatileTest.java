package multi_threading;

/*
* Read volatile keyword from internet or go to theory file in the same package
* */
public class VolatileTest {

	//keep and remove volatile for experimenting
	private static volatile int MY_INT = 0;

	public static void main(String[] args)
	{
		new ChangeListener().start();
		new ChangeMaker().start();
	}

	static class ChangeListener extends Thread {
		@Override public void run()
		{
			int local_value = MY_INT;
			while (local_value <=5) {
				if (local_value != MY_INT) {
					System.out.printf("\nGot Change for MY_INT : %s",MY_INT);

					local_value = MY_INT;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override public void run()
		{
			int local_value = MY_INT;
			while (MY_INT < 5) {
				System.out.printf("\nIncrementing MY_INT to %s",local_value + 1);
				MY_INT = ++local_value;
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
