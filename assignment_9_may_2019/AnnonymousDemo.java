interface Remote{
    void doSomething();
}
 
class Work{
 
    public void makeSheets(Remote temp){
        temp.doSomething();
        //Some code here later on...
    }
}
 
 
class AnnonymousDemo{
    public static void main(String[] args) {
        Work work = new Work();
        work.makeSheets(new Remote(){
            @Override
            public void doSomething(){
                System.out.println("Truly magical this...");
            }
        });
    }
 
 
 
}