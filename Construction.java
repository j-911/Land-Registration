package project;

public class Construction extends AnestheticLand implements LandPrice{

	private int numberOfLevels;
	private String typeOfSoil;
	
	
	public Construction() {
		super();
	}


	public Construction(int Nb, String nameOfPerson, int idOfLand, double area, double priceOfOneMeter,int numberOfLevels,String typeOfSoil) {
		super(Nb,nameOfPerson, idOfLand, area, priceOfOneMeter);
		this.numberOfLevels = numberOfLevels;
		this.typeOfSoil = typeOfSoil;
	}


	public Construction(int numberOfLevels, String typeOfSoil){
		super();
		this.numberOfLevels = numberOfLevels;
		this.typeOfSoil = typeOfSoil;
		
	}


	public int getNumberOfLevels() {
		return numberOfLevels;
	}


	public void setNumberOfLevels(int numberOfLevels) {
		this.numberOfLevels = numberOfLevels;
	}


	public String getTypeOfSoil() {
		return typeOfSoil;
	}


	public void setTypeOfSoil(String typeOfSoil) {
		this.typeOfSoil = typeOfSoil;
	}
	
	
	public void Display() {  
		System.out.println("The number Of Levels: "+numberOfLevels);
		System.out.println("The type of soil: "+typeOfSoil);
		
	}
	
	
	public void ReadDetailsOfConstructionLand() {
		super.ReadAnestheticLandInforamtion();
		System.out.print("Enter The number Of Levels: ");
		this.numberOfLevels=x.nextInt();
		System.out.print("Enter The type Of Soil: ");
		this.typeOfSoil=x.next();
}
	
	
	
	@Override
	public double PriceOfLand() {
	// TODO Auto-generated method stub
		return super.getarea()*super.getPriceOfOneMeter();
		
	}
	
	
	
}




