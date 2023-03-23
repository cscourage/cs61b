public class DogLauncher{
    public static void main(String[] args){
	Dog d = new Dog(51);
	
	Dog d1 = new Dog(100);

	Dog bigger = Dog.maxDog(d, d1);
	bigger.makeNoise();
        System.out.println(Dog.binomen);
	//d.weightInPounds = 51;
        //d.makeNoise();
    }
}
