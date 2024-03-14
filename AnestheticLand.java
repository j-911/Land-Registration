package project;


	import java.util.Scanner;
	public abstract class AnestheticLand extends Country implements LandPrice{

		protected String NameOfPerson;
		protected int idOfLand;
		protected double area;
		protected double PriceOfOneMeter;
		Scanner x=new Scanner(System.in);
		
		public AnestheticLand() {
			super();
		}


		public AnestheticLand(int Nb,String nameOfPerson, int idOfLand, double area, double priceOfOneMeter) {
			this.NameOfPerson = nameOfPerson;
			this.idOfLand = idOfLand;
			this.area = area;
			this.PriceOfOneMeter = priceOfOneMeter;
			
		}


		public AnestheticLand(AnestheticLand L) {
			this.NameOfPerson = L.NameOfPerson;
			this.idOfLand = L.idOfLand;
			this.area = L.area;
			this.PriceOfOneMeter = L.PriceOfOneMeter;
		}


		public String getNameOfPerson() {
			return NameOfPerson;
		}


		public void setNameOfPerson(String nameOfPerson) {
			NameOfPerson = nameOfPerson;
		}


		public int getIdOfLand() {
			return idOfLand;
		}


		public void setIdOfLand(int idOfLand) {
			this.idOfLand = idOfLand;
		}


		public double getarea() {
			return area;
		}


		public void setarea(double area) {
			this.area=area;
		}


		public double getPriceOfOneMeter() {
			return PriceOfOneMeter;
		}


		public void setPriceOfOneMeter(double priceOfOneMeter) {
			PriceOfOneMeter = priceOfOneMeter;
		}
		
		
		public void Display() {
			System.out.println("The Name Of Person: " +NameOfPerson);
			System.out.println("The Id Of Land: " +idOfLand);
			System.out.println("The area Of Land: " +area);
			System.out.println("The Price Of One Meter Of Land: :" +PriceOfOneMeter);
		}
		
			
		public void ReadAnestheticLandInforamtion() {
			System.out.print("Enter The Name Of The Person: ");
			NameOfPerson=x.next();
			System.out.print("Enter The Id Of Land: ");
			idOfLand=x.nextInt();
			System.out.print("Enter The area Of Land: ");
			area=x.nextDouble();
			System.out.print("Enter The Price Of One Meter Of Land: ");
			PriceOfOneMeter=x.nextDouble();
		}

		
		
		
		
	}



