/**
 * Java Program that implements a stamp dispenser 
 * @author RaghuNandan
 */
/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
class StampDispenser
{
    int[] sortedDenominations;
    /**
     * Constructs a new StampDispenser that will be able to dispense the given 
     * types of stamps.
     *
     * @param stampDenominations The values of the types of stamps that the 
     *     machine should have.  Should be sorted in descending order and 
     *     contain at least a 1.
     */
    public StampDispenser(int[] stampDenominations)
    {
        //Logic for sorting the stamp denominations array in decending order (implemented using quick sort algorithm)
        quickSort(stampDenominations);
    }
 
    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {  
        return minChange(this.sortedDenominations,request);
    }
    
    public int minChange(int[] denom, int targetAmount) {
    int actualAmount;
    int m = denom.length + 1;
    int n = targetAmount + 1;
    int inf = Integer.MAX_VALUE - 1;

    int[][] table = new int[m][n];
    for(int i = 0; i< m; ++i) {
        for (int j = 1; j < n; j++) {
            table[i][j] = inf;
        }
    }

    for (int d = 1; d < m; d++) {
        for (int ca = 1; ca < n; ca++) {
            if (denom[d-1] <= ca) {
                // take
                actualAmount = table[d][ca - denom[d-1]];
            }
            else {
                actualAmount = inf;
            }                                              // do not take
            table[d][ca] = Math.min(table[d-1][ca], 1 + actualAmount);
        }
    }
    //For printing the intermediate results
    /*
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(table[i][j]<10)
                    System.out.print(table[i][j] + "                    ");
                else
                System.out.print(table[i][j] + "          ");
                
            }
            System.out.println("");
            int[] is = table[i];
            
        }
    */
    return table[m-1][n-1];
}
    
    
   //Method for implementing the binary search
    public boolean binarySearch(int value)
    {
        if(rBsearch(0,sortedDenominations.length,value)==-1){
        return false;
        }
      return true;
    }
    
    public int rBsearch(int low, int high, int value) {
    int mid = (low + high) / 2;
    if (low > high) {
        return -1;
    } else if (sortedDenominations[mid] == value) {
        return mid;
    } else if (sortedDenominations[mid] > value) {
         return rBsearch( mid + 1, high, value);
    } else {
         return rBsearch(low, mid-1, value);
    }
}
    
   //Method for sorting the given array in decending array. 
   public void quickSort(int[] stampDenominations)
    {
        this.sortedDenominations = stampDenominations;
        int low=0;
        int high=sortedDenominations.length-1;
        quick(low,high);
    }

    public void quick(int low, int high){
      if(sortedDenominations.length==0 || sortedDenominations == null)
           return;
         else
         {
             int temp;
             int i = low;
             int j = high;
             int pivot=sortedDenominations[low+((high-low)/2)];
             while(i<=j)
             {
                 while(sortedDenominations[i]>pivot)
                     i++;
                 while(sortedDenominations[j]<pivot)
                     j--;    
                 if(i<=j){
                 temp = sortedDenominations[i];
                 sortedDenominations[i] = sortedDenominations[j];
                 sortedDenominations[j] = temp;
                 i++;
                 j--;
                 }
             }
             if(low<j)
             quick(low,j);
             if(i<high)
             quick(i,high);
         }                  
    }  
    
    public static void main(String[] args)
    {
        int[] denominations = { 16, 12, 10, 8, 4, 2, 1 };
        System.out.println("here");
        StampDispenser stampDispenser = new StampDispenser(denominations);
        System.out.println(stampDispenser.calcMinNumStampsToFillRequest(20));
        //assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
    }
    
}

