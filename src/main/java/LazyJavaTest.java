/**
 * Created by erjun on 2017/8/13.
 */
public class LazyJavaTest {

	//私有构造方法，不允许外界创建对象
	private LazyJavaTest() {

	}

	//类的内部类，也就是说静态的成员式内部类，此内部类的对象与外部类的对象没有关系，而且只有被调用到才会
	//装载，从而实现了延迟加载
	private static class SingletonHolder{
		//静态初始化器，由JVM来保证线程的安全
		private static LazyJavaTest INSTANCE = new LazyJavaTest();
	}

	public static LazyJavaTest getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
