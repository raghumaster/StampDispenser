
package stampdispenser;

import java.util.Arrays;

/**
 *
 * @author RaghuNandan
 */
public class DispenserMain {
   
    
    public static void main(String[] args) {
        
        int a[] = {25,35,10,1,2,3,4,29,45};
        StampDispenser obj = new StampDispenser(a);
        System.out.println("Minumum number of stamps required : "+obj.calcMinNumStampsToFillRequest(41));
        
      
    }
    
}
