class Engine
{
    String type;
    int power;
    int cost;
    public Engine(String type, int power, int cost) {
        this.type = type;
        this.power = power;
        this.cost=cost;
    }

    public void getEngineParameters()
    {
        System.out.println("Engine type: "+type+" || Engine Power in HP: "+power +" || Engine Cost in Euro:"+cost);
    }
}

class CombustionEngine extends Engine
{
    public CombustionEngine(String type,int power,int cost) {
       super(type,power,cost);  
    }  
}

class ElectricEngine extends Engine
{
    public ElectricEngine(String type,int power,int cost) {
       super(type,power,cost);  
    }  
}
class HybridEngine extends Engine
{
    public HybridEngine(String type,int power,int cost) {
       super(type,power,cost);  
    }  
}
//---------------------------------------------------------------
class Manufacture
{
    private String Manufacture_name;
    private int Manufacture_year;
    private int Manufacturing_cost;
    public void setManufacture_properties(String manufacture_name, int manufacture_year,int manufacturing_cost) 
    {
        Manufacture_name = manufacture_name;
        Manufacture_year = manufacture_year;
        Manufacturing_cost = manufacturing_cost;

    }
    public String getManufacture_properties() 
    {
        return Manufacture_name +","+ Manufacture_year +","+Manufacturing_cost;
    }    
}
//----------------------------------------------------------------
abstract class Vehicle
{
    abstract void ShowCharacteristics();
}


class ICEV extends Vehicle
{
    Manufacture manufacture;
    Engine engine; 
    public ICEV(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }
    public void ShowCharacteristics()
    {
        String[] sa=this.manufacture.getManufacture_properties().split(",");
        System.out.println("\nManufacture_name: "+sa[0]+"\nManufacture_year: "+sa[1]+"\nManufacturing_cost: "+sa[2]+"\n");
        System.out.println("Vehicle type: ICEV");
        engine.getEngineParameters();
    }
}


class BEV extends Vehicle
{
    Manufacture manufacture;
    Engine engine;
    public BEV(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }
    public void ShowCharacteristics()
    {
        String[] sa=this.manufacture.getManufacture_properties().split(",");
        System.out.println("\nManufacture_name: "+sa[0]+"\nManufacture_year: "+sa[1]+"\nManufacturing_cost: "+sa[2]+"\n");
        System.out.println("Vehicle type: BEV");
        engine.getEngineParameters();
    }
}


class HybridV extends Vehicle
{
    Manufacture manufacture;
    Engine engine;
    public HybridV(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }
    public void ShowCharacteristics()
    {
        String[] sa=this.manufacture.getManufacture_properties().split(",");
        System.out.println("\nManufacture_name: "+sa[0]+"\nManufacture_year: "+sa[1]+"\nManufacturing_cost: "+sa[2]+"\n");
        System.out.println("Vehicle type: HybridV");
        engine.getEngineParameters();
    }
}
//------------------------------------------------------
public class Main
{
    public static void main(String[] args) 
    {
       Engine engine1=new ElectricEngine("Electric Engine",20,10000);
       Manufacture manufacture1=new Manufacture();
       manufacture1.setManufacture_properties("Toyato",1990,30000);
       Vehicle Vehicle1=new BEV(manufacture1, engine1);

       Engine engine2=new CombustionEngine("Combustion Engine", 30,9000);
       Manufacture manufacture2=new Manufacture();
       manufacture2.setManufacture_properties("Audi",2001,29000);
       Vehicle Vehicle2=new ICEV(manufacture2, engine2);

       Engine engine3=new ElectricEngine("Electric Engine", 40,9000);
       Manufacture manufacture3=new Manufacture();
       manufacture3.setManufacture_properties("Tata",1985,33000);
       Vehicle Vehicle3=new BEV(manufacture3, engine3);

       Engine engine4=new HybridEngine("Hybrid Engine",35,15000);
       Manufacture manufacture4=new Manufacture();
       manufacture4.setManufacture_properties("Benz",192015,35000);
       Vehicle Vehicle4=new HybridV(manufacture4, engine4);

       Engine engine5=new CombustionEngine("Combustion Engine", 50,11000);
       Manufacture manufacture5=new Manufacture();
       manufacture5.setManufacture_properties("BMW",1995,21000);
       Vehicle Vehicle5=new ICEV(manufacture5, engine5);
       
       
       Vehicle[] vehicles={Vehicle1,Vehicle2,Vehicle3,Vehicle4,Vehicle5};
       System.out.println("----------------------------------");
       for(Vehicle i:vehicles)
       {
        i.ShowCharacteristics();
        System.out.println("----------------------------------");
       }
    
    }
}