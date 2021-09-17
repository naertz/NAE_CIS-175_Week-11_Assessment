/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Sep 16, 2021
 */

import java.util.List;
import java.util.Scanner;

import controller.LinuxDistroHelper;
import model.LinuxDistro;

public class Start {
    private static LinuxDistroHelper ldh = new LinuxDistroHelper();
    private static Scanner input = new Scanner(System.in);
    
    private static void addDistro() {
        System.out.print("Enter the Linux distro's name: ");
        String name = input.nextLine();
        
        System.out.print("Enter the Linux distro this Linux distro is based on: ");
        String basedOn = input.nextLine();
        
        System.out.print("Enter the Linux distro's origin: ");
        String origin = input.nextLine();
        
        System.out.println();
        
        LinuxDistro distro = new LinuxDistro(name, basedOn, origin);
        ldh.insertLinuxDistro(distro);
    }
    
    private static void editDistro() {
        System.out.println("1: Search by the Linux distro's name");
        System.out.println("2: Search by the Linux distro this Linux distro is based on");
        System.out.println("3: Search by the Linux distro's origin");
        System.out.println();
        System.out.print("Enter search method: ");
        int searchMethod = input.nextInt();
        input.nextLine();
        
        List<LinuxDistro> foundDistros;
        
        if (searchMethod == 1) {
            System.out.print("Enter the Linux distro's name: ");
            String name = input.nextLine();
            
            foundDistros = ldh.findLinuxDistroName(name);
        } else if (searchMethod == 2) {
            System.out.print("Enter the Linux distro this Linux distro is based on: ");
            String basedOn = input.nextLine();
            
            foundDistros = ldh.findLinuxDistroBasedOn(basedOn);
        } else {
            System.out.print("Enter the Linux distro's origin: ");
            String origin = input.nextLine();
            
            foundDistros = ldh.findLinuxDistroOrigin(origin);
        }
        
        System.out.println();
        
        if (!foundDistros.isEmpty()) {
            System.out.println("Found Distros:");
            for (LinuxDistro distro : foundDistros) {
                System.out.println(distro.getID() + " : " + distro.toString());
            }
            System.out.println();
            System.out.print("Enter the Linux distro's ID to edit: ");
            int id = input.nextInt();
            
            System.out.println();
            
            LinuxDistro distro = ldh.findLinuxDistroID(id);
            
            System.out.println("Retrieved Linux Distro:");
            System.out.println("Name: " + distro.getName());
            System.out.println("Based On: " + distro.getBasedOn());
            System.out.println("Origin: " + distro.getOrigin());
            System.out.println();
            System.out.println("1: Edit the Linux distro's name");
            System.out.println("2: Edit the Linux distro this Linux distro is based on");
            System.out.println("3: Edit the Linux distro's origin");
            System.out.println();
            System.out.print("Enter value: ");
            int selectedValue = input.nextInt();
            input.nextLine();
            
            if (selectedValue == 1) {
                System.out.print("Enter the Linux distro's new name: ");
                String newName = input.nextLine();
                
                distro.setName(newName);
            } else if (selectedValue == 2) {
                System.out.print("Enter the new Linux distro this Linux distro is based on: ");
                String newBasedOn = input.nextLine();
                
                distro.setBasedOn(newBasedOn);
            } else if (selectedValue == 3) {
                System.out.print("Enter the Linux distro's new origin: ");
                String newOrigin = input.nextLine();
                
                distro.setOrigin(newOrigin);
            }
            
            ldh.updateLinuxDistro(distro);
        } else {
            System.out.println("No Linux distro(s) found");
        }
    }
    
    private static void removeDistro() {
        System.out.print("Enter the Linux distro's name to remove: ");
        String name = input.nextLine();
        
        System.out.print("Enter the Linux distro this Linux distro is based on: ");
        String basedOn = input.nextLine();
        
        System.out.print("Enter the Linux distro's origin: ");
        String origin = input.nextLine();
        
        LinuxDistro distro = new LinuxDistro(name, basedOn, origin);
        ldh.deleteLinuxDistro(distro);
    }
    
    private static void showDistros() {
        List<LinuxDistro> linuxDistros = ldh.getLinuxDistroList();
        System.out.println();
        for (LinuxDistro distro : linuxDistros) {
            System.out.println(distro.getInformation());
        }
    }
    
    private static void exit() {
        ldh.closeEMF();
        System.out.println("Goodbye.");
    }
    
    private static void runMenu() {
        boolean shouldContinue = true;
        
        System.out.println("Linux Distribution Table Console Application");
        while (shouldContinue) {
            System.out.println();
            System.out.println("1: Add Linux distro");
            System.out.println("2: Edit Linux distro");
            System.out.println("3: Remove Linux distro");
            System.out.println("4: Show Linux distros");
            System.out.println("5: Exit");
            System.out.println();
            System.out.print("Enter option: ");
            int selectedOption = input.nextInt();
            input.nextLine();
            
            System.out.println();
            
            if (selectedOption == 1) {
                addDistro();
            } else if (selectedOption == 2) {
                editDistro();
            } else if (selectedOption == 3) {
                removeDistro();
            } else if (selectedOption == 4) {
                showDistros();
            } else {
                exit();
                shouldContinue = false;
            }
        }
    }
    
    public static void main(String[] args) {
        runMenu();
        input.close();
    }
}
