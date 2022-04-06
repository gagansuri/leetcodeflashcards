public class StockBuying {


    public static void main(String[] args) {
        int[] stockPrices=new int[]{1,0,13,4,5,6,1};
        stockPrices=new int[]{7,1,5,3,6,4};
        System.out.println(findMaxProfit(stockPrices));
    }
    static int findMaxProfit(int []stockPricees) {
        int totalProfit=0;

        for(int i=0;i<stockPricees.length-1;i++) {


            if(stockPricees[i+1]>stockPricees[i]) {
                int profit=stockPricees[i+1]-stockPricees[i];
                totalProfit+=profit;
            }

        }

        return totalProfit;
    }
}
