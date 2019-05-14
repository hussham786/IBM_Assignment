import java.util.ArrayList;
import java.util.Scanner;
class Laptop{
    private Integer ramSize, hddSize, id;
    private String brand;
 
    Laptop(int id, int ramSize, int hddSize, String brand ){
        this.id = id;
        this.ramSize = ramSize;
        this.hddSize = hddSize;
        this.brand = brand;
    }

    Laptop(){

    }
    //Creating the setters
    void setId(int id){
        this.id = id;
    }

    void setRamSize(int ramSize){
        this.ramSize = ramSize;
    }
 
    void setHddSize(int hddSize){
        this.hddSize = hddSize;
    }
 
    void setBrand(String brand){
        this.brand = brand;
    }
 
    //Creating the getters
    public Integer getId(){
        return this.id;
    }

    public Integer getRamSize(){
        return this.ramSize;
    }
 
    public Integer getHddSize(){
        return this.hddSize;
    }
 
    public String getBrand(){
        return this.brand;
    }
}
 
class LaptopCollectionAndOperationUsingJava{
    static Scanner sc;
    //private int idVal = 542;
    public static void main(String[] args) {
 
        ArrayList list = new ArrayList();
 
        Laptop l = new Laptop(101, 8, 600, "Lenovo");
 
        //Store a Laptop object in the list
        list.add(new Laptop(111, 4, 500, "IBM"));
        list.add(new Laptop(201, 8, 800, "IBM"));
        list.add(new Laptop(121, 6, 500, "Sony"));
        list.add(new Laptop(234, 6, 600, "Sony"));
        list.add(new Laptop(321, 4, 500, "Sony"));
        list.add(new Laptop(231, 6, 1000, "Lenovo"));
        list.add(new Laptop(541, 8, 500, "IBM"));
 
        list.add(l);
 
//Get all the details of a particular laptop
/*System.out.println("Second Laptop Details : ");
 
System.out.println("Ram : " + ((Laptop)list.get(1)).getRamSize());
System.out.println("HDD Size : " + ((Laptop)list.get(1)).getHddSize());
System.out.println("Brand : " + ((Laptop)list.get(1)).getBrand());*/
        LaptopCollectionAndOperationUsingJava.sc = new Scanner(System.in);
        System.out.println("Enter your choice\nEnter 1 to add new laptop\nEnter 2 to view all laptops\nEnter 3 to search for a laptop\nEnter 4 to update laptop details\nEnter 5 to delete laptop details");
        int choice = sc.nextInt();
        sc.nextLine();
        new LaptopCollectionAndOperationUsingJava().selectedChoice(choice, list);
 
    }

    void selectedChoice(int choice, ArrayList list){
        String str = "";
        do{
            switch(choice){
                case 1: addLaptop(list);
                    break;
                case 2: viewLaptop(list);
                    break;
                case 3: searchLaptop(list);
                    break;
                case 4: updateLaptop(list);
                    break;
                case 5: deleteLaptop(list);
                    break;
                default: System.out.println("WRONG INPUT!");
            }
            System.out.println("Do you wish to continue?\n Press Y/N");
            str = sc.next();
            if (str.equalsIgnoreCase("Y")) {
                System.out.println("Enter your choice\nEnter 1 to add new laptop\nEnter 2 to view all laptops\nEnter 3 to search for a laptop\nEnter 4 to update laptop details\nEnter 5 to delete laptop details");
                choice = sc.nextInt();
            }
        }while(str.equalsIgnoreCase("Y"));
    }

    void addLaptop(ArrayList list){
       // Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = sc.nextInt();
        System.out.println("Enter ram size");
        int ram = sc.nextInt();
        System.out.println("Enter HDD size");
        int hdd = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter brand name");
        String brand = sc.nextLine();
        //ArrayList list = new ArrayList();
        list.add(new Laptop(id, ram, hdd, brand));
        //return list;
        /*for (Object obj : list) {
            System.out.print("ID " +((Laptop)obj).getId() +"  Brand "+ ((Laptop)obj).getBrand() +" Ram " + ((Laptop)obj).getRamSize() +" gb " +" Hard Disk " +((Laptop)obj).getHddSize() +" gb\n");
        }*/

    }

    void viewLaptop(ArrayList list){

        for (Object obj : list) {
            System.out.print("ID " +((Laptop)obj).getId() +" Brand "+ ((Laptop)obj).getBrand() +" Ram " + ((Laptop)obj).getRamSize() +" gb " +" Hard Disk " +((Laptop)obj).getHddSize() +" gb\n");
        }
    }

    void searchLaptop(ArrayList list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice\nEnter 1 to search by brand\nEnter 2 to search by ram size\nEnter 3 to search by Hard disk size");
        int choice = sc.nextInt();

        switch(choice){
            case 1: searchByBrand(list);
                break;
            case 2: searchByRam(list);
                break;
            case 3: searchByHDD(list);
                break;
            default: System.out.println("WRONG INPUT!");
        }

    }

    void updateLaptop(ArrayList list){
        System.out.println("Enter the laptop id to update");
        int id = sc.nextInt();
        System.out.println("Enter your choice\nEnter 1 to update brand\nEnter 2 to update ram size\nEnter 3 to update hard disk size\nEnter 4 to update all");
        int choice = sc.nextInt();

        /*System.out.println("Enter the updated brand");
        String brand = sc.nextLine();
        System.out.println("Enter the updated ram size");
        int ram = sc.nextInt();
        System.out.println("Enter the updated hard disk size");
        int hdd = sc.nextInt();*/
        int index = 0;
        for (Object obj : list) {
            if(((Laptop)obj).getId() == id){
               index = list.indexOf(obj);
               break;
            }
        }


        switch(choice){
            case 1: updateByBrand(id, index, list);
                break;
            case 2: updateByRam(id, index, list);
                break;
            case 3: updateByHDD(id, index, list);
                break;
            case 4: updateAll(id, index, list);
                break;
            default: System.out.println("WRONG INPUT!");
        }

        //list.get(index).getBrand()


        //list.set(index);

    }

    void deleteLaptop(ArrayList list){
        System.out.println("Enter the laptop id to delete");
        int id = sc.nextInt();
        int index = 0;
        for (Object obj : list) {
            if(((Laptop)obj).getId() == id){
               index = list.indexOf(obj);
               break;
        }
    }
    list.remove(index);
}

    void searchByBrand(ArrayList list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter brand name");
        String brand = sc.nextLine();
        for (Object obj : list) {
            if(((Laptop)obj).getBrand().equalsIgnoreCase(brand)){
            System.out.print("ID " +((Laptop)obj).getId() +" Brand "+ ((Laptop)obj).getBrand() +" Ram " + ((Laptop)obj).getRamSize() +" gb " +" Hard Disk " +((Laptop)obj).getHddSize() +" gb\n");
        }
    }
}

    void searchByRam(ArrayList list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ram size");
        int ram = sc.nextInt();
        for (Object obj : list) {
            if(((Laptop)obj).getRamSize() == ram){
            System.out.print("ID " +((Laptop)obj).getId() +" Brand "+ ((Laptop)obj).getBrand() +" Ram " + ((Laptop)obj).getRamSize() +" gb " +" Hard Disk " +((Laptop)obj).getHddSize() +" gb\n");
        }
    }
}

    void searchByHDD(ArrayList list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hard disk size");
        int hdd = sc.nextInt();
        for (Object obj : list) {
            if(((Laptop)obj).getHddSize() == hdd){
            System.out.print("ID " +((Laptop)obj).getId() +" Brand "+ ((Laptop)obj).getBrand() +" Ram " + ((Laptop)obj).getRamSize() +" gb " +" Hard Disk " +((Laptop)obj).getHddSize() +" gb\n");
        }
    }
}

    void updateByBrand(int id, int index, ArrayList list){
        System.out.println("Enter the updated brand");
        String brand = sc.next();
        int ram = ((Laptop)list.get(index)).getRamSize();
        int hdd = ((Laptop)list.get(index)).getHddSize();
        list.set(index, new Laptop(id, ram, hdd, brand));

    }

    void updateByRam(int id, int index, ArrayList list){
        System.out.println("Enter the updated ram size");
        int ram = sc.nextInt();
        String brand = ((Laptop)list.get(index)).getBrand();
        int hdd = ((Laptop)list.get(index)).getHddSize();
        list.set(index, new Laptop(id, ram, hdd, brand));
    }

    void updateByHDD(int id, int index, ArrayList list){
        System.out.println("Enter the updated hard disk size");
        int hdd = sc.nextInt();
        String brand = ((Laptop)list.get(index)).getBrand();
        int ram = ((Laptop)list.get(index)).getRamSize();
        list.set(index, new Laptop(id, ram, hdd, brand));
    }

    void updateAll(int id, int index, ArrayList list){
        System.out.println("Enter the updated brand");
        String brand = sc.next();
        System.out.println("Enter the updated ram size");
        int ram = sc.nextInt();
        System.out.println("Enter the updated hard disk size");
        int hdd = sc.nextInt();
        
        list.set(index, new Laptop(id, ram, hdd, brand));
    }
}
