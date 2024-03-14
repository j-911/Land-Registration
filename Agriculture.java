package project;



public class Agriculture extends AnestheticLand implements LandPrice{
	
	private String cropToBeSeeded;
	
	
	public Agriculture() {
		
	}


	public Agriculture(int CountryNumber, String nameOfPerson, int idOfLand, double area, double priceOfOneMeter,String cropToBeSeeded) {
		super(CountryNumber, nameOfPerson, idOfLand, area, priceOfOneMeter);
		this.cropToBeSeeded=cropToBeSeeded;
	}


	public Agriculture(String j) {
		this.cropToBeSeeded=j;
	}


	public String getCropToBeSeeded() {
	return cropToBeSeeded;
}


	public void setCropToBeSeeded(String cropToBeSeeded) {
	this.cropToBeSeeded = cropToBeSeeded;
}
	public void Display() {  
		System.out.println("The crop To Be Seeded: "+cropToBeSeeded);
	}

	
	public void ReadDetailsOfAgricultureLand() {
		super.ReadAnestheticLandInforamtion();
		System.out.print("Enter The crop To Be Seeded: ");
		this.cropToBeSeeded=x.next();
	}
	
	
	@Override
	public double PriceOfLand() {
		// TODO Auto-generated method stub
			return super.getarea()*super.getPriceOfOneMeter();
	}
	
}

	

