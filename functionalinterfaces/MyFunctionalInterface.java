package functionalinterfaces;

@FunctionalInterface
public interface MyFunctionalInterface<T> {
	
	void accept(T t);

}
