//BFS: 
// Time Complexity: O(n)
// Space Complexity: O(n/2)=O(n)
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) { 
//         List<Integer> result = new ArrayList<>();
//         if(root==null) return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0;i<size;i++){
//                 TreeNode curr = q.poll();
//                 if(i==size-1){
//                     result.add(curr.val);
//                 }
//                 if(curr.left!=null){
//                     q.add(curr.left);
//                 }
//                 if(curr.right!=null){
//                     q.add(curr.right);
//                 }
//             }
//         }
//         return result;
//     }
// }


// DFS recursion-preorder-incrementing levels in recursive call
// Time Complexity: O(n)
// Space Complexity: O(1)aux, O(h) for recurion stack
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) { 
//         List<Integer> result = new ArrayList<>();
//         dfs(root,0,result);
//         return result;
//     }
//     private void dfs(TreeNode root, int level, List<Integer> result){
//         //base
//         if (root==null) return;
//         //logic
//         if(result.size()==level){
//             result.add(root.val);
//         }
//         level +=1;
//         dfs(root.right,level,result); //right recursive first
//         dfs(root.left,level,result);
//     }
// }

//DFS recursion-preorder-incrementing levels in recursive call
//Time Complexity: O(n)
//Space Complexity: O(1)aux, O(h) for recurion stack
class Solution {
    public List<Integer> rightSideView(TreeNode root) { 
        List<Integer> result = new ArrayList<>();
        dfs(root,0,result);
        return result;
    }
    private void dfs(TreeNode root, int level, List<Integer> result){
        //base
        if (root==null) return;
        //logic
        if(result.size()==level){
            result.add(root.val);
        }
        else{
            result.set(level,root.val);
        }
        level +=1;
        dfs(root.left,level,result); //left recursive first
        dfs(root.right,level,result);
    }
}