package project;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {

        // create a new province
        Province province = new Province(5," Province 1");

        // add some anesthetic lands to the province
        Agriculture  land1 = new Agriculture();
        Construction land2 = new Construction();
        Agriculture  land3 = new Agriculture();
        
      //read information of land
        land1.ReadDetailsOfAgricultureLand();
        land2.ReadDetailsOfConstructionLand();
        land3.ReadDetailsOfAgricultureLand();
        
        province.AddAnestheticLand(land1);
        province.AddAnestheticLand(land2);
        province.AddAnestheticLand(land3);
       
        // display the information of all lands in the province
        province.displayAllLands();

        // find the number of agriculture and construction lands in the province
        int numAgricultureLands = province.FindNumberOfAgricultureLands();
        int numConstructionLands = province.FindNumberOfConstructionLands();
        System.out.println("Number of agriculture lands: " + numAgricultureLands);
        System.out.println("Number of construction lands: " + numConstructionLands);

        // update the information of a land
        boolean updated = province.UpdateLandInformation(3);
        if (updated) {
            System.out.println("Land information updated successfully");
        } else {
            System.out.println("Land not found, update failed");
        }

        // merge two agriculture lands
        boolean merged = province.MergeTwoLands(1, 3);
        if (merged) {
            System.out.println("Lands merged successfully");
        } else {
            System.out.println("Land merging failed");
        }

        // split a construction land
        boolean split = province.SplitLand(1, 4,50);
        if (split) {
            System.out.println("Land split successfully");
        } else {
            System.out.println("Land spliting failed");
        }
        //search land
        System.out.println(province.searchLandById(6));
       
        //delete land
        System.out.println(province.DeleteAnestheticLand(6));
        
        String AgrFileName = "agriculture.txt";
        String ConsFileName = "construction.txt";
        try {
            province.storeData(AgrFileName, ConsFileName);
            System.out.println("Data stored successfully!");
        } catch (IOException e) {
            System.out.println("Error storing data: " + e.getMessage());
        }
        
        Agriculture  land4 = new Agriculture();
        land4.ReadDetailsOfAgricultureLand();
      System.out.println( province.SecondMethodToFindPriceOfLandById(2));

    }
}
