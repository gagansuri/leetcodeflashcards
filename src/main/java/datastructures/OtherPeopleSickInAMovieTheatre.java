package datastructures;
  /*
public class OtherPeopleSickInAMovieTheatre
{

   COVID-42 spread

   You have a rectangularly shaped movie theater represented by m x n grid.

   0 representing an empty seat
   1 representing a healthy person
   3 representing a sick person


   Every minute, any healthy person that is 4-directionally adjacent to a sick person becomes sick.
   Return the minimum number of minutes that must elapse unil there is no healthy person in the theater. If this is impossible, return -1.

   * Nice to have:
   2 representing a healthy person wearing a mask
   Every healthy person wearing a mask that is 4-directionally adjacent to a sick person becomes sick in 2 minutes.


   Constraints:

   m == grid.length
   n == grid[i].length
   1 <= m, n <= 100
   grid[i][j] is 0, 1, 2 or 3


  theater m rows and n columns

  first we a sick person
  Map<String,Boolean> alreadyChecked=new HashMap<>();
  int time =0
for(int i=0;i<grid.length;i++) {
  for(int j=0;j<grid[i].length;j++) {
    if(!alreadyChecked.get(i+"_"+j) && grid[i][j]==3) {
      // first sick person
      time+=checkAllAdjacent(i,j,grid);
      alreadyChecked.put(i+"_"+j,true);
    }
  }
}


  checkAllAdjacent(int i,int j,int[][]grid) {

    if(i<0 || i>=grid.length || j<0 || j>=grid[i].length && grid[i][j] !=0) return 0;

    grid[i][j]=3;

    checkAllAdjacent(i-1,j,grid);
    checkAllAdjacent(i+1,j,grid);
    checkAllAdjacent(i,j+1,grid);
    checkAllAdjacent(i,j-1,grid);

    return 1;

  }




}
*/