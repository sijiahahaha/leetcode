
/**
depth
**/
// max depth
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// min depth
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

/**
max path sum
**/

// root to leaf 
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + root.val;
    }
}


//root to any
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(0, singlePath);
        return singlePath
    }
}



//any to any
class Solution {
    private class resultType {
        //singlePath:root to any, don't count root, maxPath:any to any
        int singlePath, maxPath;     
        resultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
       
    private resultType helper(TreeNode root) {
        if (root == null) {
            return new resultType(0, Integer.MIN_VALUE);
        }
        
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(0, singlePath);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        
        return new resultType(singlePath, maxPath);       
    }
     
    public int maxPathSum(TreeNode root) {
        resultType result = helper(root);
        return result.maxPath;
    }
}


/**
min path sum
**/

//root to leaf
class Solution {
    public int minPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        if (root.left == null) {
            return minPathSum(root.right) + root.val;
        }
        
        if (root.right == null) {
            return minPathSum(root.left) + root.val;
        }
        
        return Math.min(minPathSum(root.left), minPathSum(root.right)) + root.val;
    }
}


//root to any
class Solution {
    public int minPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return Math.min(root.val, 0);
        }
        
        if (root.left == null) {

            return Math.min(minPathSum(root.right) + root.val, 0);
        }
        
        if (root.right == null) {
            return Math.min(minPathSum(root.left) + root.val, 0);
        }
        
        return Math.min(Math.min(minPathSum(root.left), minPathSum(root.right)) + root.val, 0);
    }
}

// any to any
class Solution {
    private class resultType {
        //singlePath:root to any, don't count root, maxPath:any to any
        int singlePath, minPath;     
        resultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = minPath;
        }
    }
       
    private resultType helper(TreeNode root) {
        if (root == null) {
            return new resultType(0, Integer.MAX_VALUE);
        }
        
        if (root.left == null && root.right == null) {
            int singlePath = Math.min(0, root.val);
            int minPath = root.val;
            return new resultType(singlePath, minPath);
        }
        
        if (root.left == null) {
            resultType right = helper(root.right);
            int singlePath = Math.min(right.singlePath + root.val, 0);
            int minPath = Math.min(right.minPath, right.singlePath + root.val)
            return new resultType(singlePath, minPath);
        }
        
        if (root.right == null) {
            resultType left = helper(root.left);
            int singlePath = Math.min(left.singlePath + root.val, 0);
            int minPath = Math.min(left.minPath, left.singlePath + root.val)
            return new resultType(singlePath, minPath);
        }


        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        int singlePath = Math.min(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.min(0, singlePath);
        
        int minPath = Math.min(left.minPath, right.minPath);
        minPath = Math.min(minPath, left.singlePath + right.singlePath + root.val);
        
        return new resultType(singlePath, minPath);       
    }
     
    public int minPathSum(TreeNode root) {
        resultType result = helper(root);
        return result.minPath;
    }
}


or

class Solution {
    public int minPathSum(TreeNode root) {
        Result r = new Result(Integer.MAX_VALUE);
        minPath(root, r);
        return r.val;
    }

    public int minPath(TreeNode root, Result res) {
        if (root == null) {
            return 0;
        }
         int l = minPath(root.left, res);
         int r = minPath(root.right, res);
         int min = Math.min(l,r) + root.val;
         int min2 = Math.min(min, l + r + root.val);
         res.val = Math.min(res.val, min2);
         return min;
    }
}

/**
find path sum equal target
**/
// if has path
path_sum_i.java  
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

path_sum_ii.java  
//find all path
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> currPath = new ArrayList<>();
        dfs(root, sum, result, currPath);
        return result;
    }
    
    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currPath) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        currPath.add(root.val);
        
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<Integer>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        dfs(root.left, sum, result, currPath);
        dfs(root.right, sum, result, currPath);
        currPath.remove(currPath.size() - 1);
    }
}

path_sum_iii.java 
// any to any, but must downwards 
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int helper(TreeNode root, int sum) {
        int count = 0;
        if (root == null) return count;
        sum -= root.val;
        if (sum == 0) count++;
        count += helper(root.left, sum);
        count += helper(root.right, sum);
        return count;
    }
}