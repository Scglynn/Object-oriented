
public class MultiplicationTable {
     
    public static void main(String[] args) 
    {
        int rowSize = Integer.parseInt(args[0]);
        int colSize = Integer.parseInt(args[1]);

        
        System.out.format("   x|");
        for(int i = 1; i<=rowSize;i++ ) {
            System.out.format("%5d",i);
        }
        System.out.println();

        for(int i = 0; i<=rowSize;i++){
            System.out.print("-----");
        }

         System.out.println();

        for(int i = 1 ;i<=colSize;i++) {
         
            System.out.format("%4d|",i);

            for(int j=1;j<=rowSize;j++) {
                System.out.format("%5d",i*j);
            }
            System.out.println();
        }
    }
     
}
