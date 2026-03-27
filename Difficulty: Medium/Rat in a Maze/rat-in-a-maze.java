class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        
        ArrayList<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        int n = maze.length;
        int[][] visit = new int[n][n];
        if(maze[0][0] == 1) {
            visit[0][0] = 1;
            int row = 0;
            int col = 0;
            helper(answer, sb, maze, visit, n, row, col);
            Collections.sort(answer);
        }
        
        return answer;
    }
    
    public void helper(ArrayList<String> answer , StringBuilder sb , int[][] maze, int[][] visit , int n, int row, int col) {
        //base case
        if(row >= n-1 && col >= n-1) {
            answer.add(sb.toString());
            return;
        }
        //recursive case
        //UP direction
        if((row - 1 >= 0) && maze[row-1][col] == 1 && visit[row-1][col] == 0) {
            sb.append('U');
            visit[row-1][col] = 1;
            helper(answer, sb, maze, visit, n, row - 1, col);
            sb.deleteCharAt(sb.length()-1);
            visit[row-1][col] = 0;
            
        }
        //DOWN direction
        if((row + 1 <= n-1) && maze[row+1][col] == 1 && visit[row+1][col] == 0) {
            sb.append('D');
            visit[row+1][col] = 1;
            helper(answer, sb, maze, visit, n, row + 1, col);
            sb.deleteCharAt(sb.length()-1);
            visit[row+1][col] = 0;
            
        }
        //LEFT direction
        if((col - 1 >= 0) && maze[row][col-1] == 1 && visit[row][col-1] == 0) {
            sb.append('L');
            visit[row][col-1] = 1;
            helper(answer, sb, maze, visit, n, row, col-1);
            sb.deleteCharAt(sb.length()-1);
            visit[row][col-1] = 0;
            
        }
        //RIGHT direction
        if((col + 1 <= n-1) && maze[row][col+1] == 1 && visit[row][col+1] == 0) {
            sb.append('R');
            visit[row][col+1] = 1;
            helper(answer, sb, maze, visit, n, row, col+1);
            sb.deleteCharAt(sb.length()-1);
            visit[row][col+1] = 0;
            
        }
    }
}