package basic07_thread;
//thread 클래스 이용한 스레드 구현
//thread 클래스를 상속받고 스레드 처리가 필요한 코드를 run()에 오버라이딩하면
//자바가상머신의 스레드스케쥴러가 실행을 관리
public class ThreadTest1 extends Thread{  
	String threadName;
	public ThreadTest1() {
		// TODO Auto-generated constructor stub
	}
	
	public ThreadTest1(String threadName) {
		this.threadName = threadName;
		
	}
	
	public void run() {
		for (int i = 1;; i++) {
			System.out.println(threadName+"->"+i);
		}
	}
	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1("첫번째 스레드");
		ThreadTest1 t2 = new ThreadTest1("두번째 스레드");

		//t1.thread_method();
		//t2.thread_method();

		//run()메소드는 start()메소드를 이용하여 호출 가능하다.
		t1.start();
		t2.start();
		
	}

}
