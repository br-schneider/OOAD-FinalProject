
public abstract class Store {
	
	protected abstract Car createCar(String type);
	
	public Car orderCar(String type) {
		
		Car car = createCar(type);
		
		
		return car;
	}
	
}
