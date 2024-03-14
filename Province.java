package project;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Province
{
	private String name;
	private int NumberOfAnestheticLands;
	private AnestheticLand[] L;
	
	public Province(int size,String s)
	{
		L= new AnestheticLand[size];
		name=s;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfAnestheticLands() {
		return NumberOfAnestheticLands;
	}
	public void setNumberOfAnestheticLands(int numberOfAnestheticLands) {
		NumberOfAnestheticLands = numberOfAnestheticLands;
	}
	public AnestheticLand[] getL() {
		return L;
	}
	public void setL(AnestheticLand[] l) {
		L = l;
	}
	
	public boolean isFull()
	{
		return NumberOfAnestheticLands==L.length;
	}
	public boolean isEmpty()
	{
		return 	NumberOfAnestheticLands==0;
	}
	public boolean AddAnestheticLand(AnestheticLand land)
	{
		if(isFull()) {
			return false;
		}
		else {
			L[NumberOfAnestheticLands++]=land;
			return true;
		}
		}
	
	public boolean DeleteAnestheticLand(int idland)
	{
		if(searchLandById(idland)!=-1)
		{
			L[searchLandById(idland)]=null;
			NumberOfAnestheticLands--;
			return true;
		}
		return false;
	}
	
	public int searchLandById(int I)
	{
		for(int i=0;i<L.length;i++)
			if(L[i]==null)
				return -1;
				else {
		if(L[i].idOfLand==I)
		{
		System.out.println("The land is in the Province");
		return i;
		}
		System.out.println("The land is not in the Province");}
		return -1;
	}
	public void displayAllLands()
	{
		for(int i=0;i<L.length;i++)
			if(L[i]!=null)
			L[i].Display();
	}
	public int FindNumberOfAgricultureLands()
	{
		int counter=0;
		for(int i=0;i<L.length;i++)
		if(L[i] instanceof Agriculture)
		counter++;
		return counter;
	}
	public int FindNumberOfConstructionLands()
	{
		int counter=0;
		for(int i=0;i<L.length;i++)
		if(L[i] instanceof Construction)
		counter++;
		return counter;
	}
	public boolean UpdateLandInformation(int idLand)
	{
		Scanner x=new Scanner(System.in);
		String newName;
		double newArea;
		double newPriceOfOneMeter;
		for(int i=0;i<L.length;i++)
		{
			if(L[i]==null)
			return false;
			else
			{
				if(L[i].idOfLand==idLand)
				{
					System.out.println("Updating Land information:");
					System.out.print("Enter the name of the person: ");
					newName=x.next();
					L[i].setNameOfPerson(newName);
					System.out.print("Enter the area of the land: ");
					newArea=x.nextDouble();
					L[i].setarea(newArea);
					System.out.print("Enter the price of one meter: ");
					newPriceOfOneMeter=x.nextDouble();
					L[i].setPriceOfOneMeter(newPriceOfOneMeter);
					return true;
				}	
			}
		}
		return false;
	}
	public boolean MergeTwoLands(int IdOfLand1,int IdOfLand2)
	{
		int flag=0,index1=0,index2=0;
		for(int i=0;i<L.length;i++)
		{
			if(L[i]==null)
				{return false;}
			else
				{
			if(L[i].idOfLand==IdOfLand1)
				{index1=i;flag++;}
			if(L[i].idOfLand==IdOfLand2)
			{index2=i;flag++;}
			
		
		L[index1].setNameOfPerson(L[index2].getNameOfPerson()+" and "+L[index1].getNameOfPerson());
		L[index1].setarea(L[index1].getarea()+L[index2].getarea());
		L[index2]=null;
		return true;
		}
			}
		return false;
	}
	public boolean SplitLand(int idPre,int idNew,double Percent)
	{
		int flag=0;
		int index1=0,index2=0;
		for(int i=0;i<L.length;i++)
		{
			if(L[i]==null)
				return false;
				else
				{
			if(L[i].getIdOfLand()==idPre)
				{index1=i;flag++;}
			if(L[i].getIdOfLand()==idNew)
			{index2=i;flag++;}
		AnestheticLand newL=null;
		newL.setNameOfPerson(L[index1].getNameOfPerson());
		newL.setIdOfLand(idNew);
		newL.setarea(L[index1].area*(Percent/100)*L[index1].area);
		newL.setPriceOfOneMeter(L[index1].PriceOfOneMeter);
		L[idPre].area=L[idPre].area-newL.area;
		return true;}
		}
		return false;
	}
	public void storeData(String AgrFileName,String ConFileName)throws IOException{
	    for(int i=0;i<L.length;i++) {
	    	if(L[i] instanceof Construction) {
	    		FileWriter Construction=new FileWriter("ConstructionFile.txt");
	    		Construction a =new Construction();
	    		a.Display();
	    		Construction.close();
	    	}else {
	    		FileWriter Agriculture= new FileWriter("AgriculturalFile.txt");
	    		Agriculture a=new Agriculture();
	    		a.Display();
	    		Agriculture.close();
	    }
	    }
	    }
public Agriculture TakeAgricultureInfoFromFile(String filName) throws IOException {
		
		for (int i = 0; i <L.length; i++) {
			if (L[i] instanceof Agriculture) {
				FileReader Agriculture = new FileReader("AgriculturalFile.txt");
				Agriculture a = new Agriculture();
				Agriculture.read();
				System.out.println("The Agricultural Lands are :");
				Agriculture.close();
				return a;
			}
		}
		return null;
	}
public Construction TakeConstructionInfoFromFile(String fileName) throws IOException {
	for (int i = 0; i < L.length; i++) {
		if (L[i] instanceof Construction) {
			FileReader Construction = new FileReader("ConstructionFile.txt");
			Construction a = new Construction();
			Construction.read();
			System.out.println("The Construction Lands are :");
			Construction.close();
			return a;
		}
	}
	return null;
}
public double PriceOfAgricultureLandByID(String fileName) throws IOException {
	TakeAgricultureInfoFromFile(fileName);
	Agriculture a = new Agriculture();
	return a.PriceOfLand();
	
}
public double PriceOfConstructionLandByID(String fileName) throws IOException {
	TakeConstructionInfoFromFile(fileName);
	Construction a = new Construction();
	return a.PriceOfLand();
}



	public double SecondMethodToFindPriceOfLandById(int id)
	{
		return L[searchLandById(id)].area*L[searchLandById(id)].PriceOfOneMeter;
	}
	
}

