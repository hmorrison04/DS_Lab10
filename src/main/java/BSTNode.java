import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;
   private int depth = 0;
   int hold = 0;


   public BSTNode(T val)
   {
      this(val,null,null);
      
   }
    

   public BSTNode(T val, BSTNode<T> l,BSTNode<T> r)
   {
	   this.val = val;
	   this.left = l;
	   this.right = r;
   }

   
   
   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
	  
	  // BSTNode<T> curr = new BSTNode<T>(val,left,right);
	   //System.out.println(curr.val);
	  if(this.val == null) {
		   val = target;
		   
		   return;
	   }
	  
	  //target is greater than current val
	   if(right == null && val.compareTo(target) < 0) 
	   {
		   BSTNode<T> a = new BSTNode<T>(target,null, null);
		   right = a;
		   return;
	   }
	   
	 //target is less than current val
	   if(left == null && val.compareTo(target) > 0) 
	   {
		  
		   BSTNode<T> a = new BSTNode<T>(target,null, null);
		   left = a;
		   
		   return;
	   }
	   if(val.compareTo(target) < 0)
	   {
		  right.insert(target);
		 // val = right.val;
		  //right = right.right;
		  //insert(target);
	   }
	   if(val.compareTo(target) > 0)
	   {
		   left.insert(target);
		  // val = left.val;
		   //left = left.left;
		   //insert(target);
	   }
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
	 //  System.out.println(val);
	   if(this.val==null)
	    {
		  
	    	return null;
	    }
	   	if(val.compareTo(target) == 0)
	    {
		    return target;
	    }
	   
		if(left == null && val.compareTo(target) > 0)
		{
			return null;
		}
		if(right == null && val.compareTo(target) < 0)
		{
			return null;
		}
		
		//target > val
		if(val.compareTo(target) < 0) {
			return right.retrieve(target);
			
		}
		
		//target < val
		if(val.compareTo(target) > 0) {
			return left.retrieve(target);
			
		}
		
	return retrieve(target);
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target)
   {
	  depth = depth+=1;
	  // int depth = 0;
	  // System.out.println(target);
	   //System.out.println(val);
	   if (this.val == null)
	   {	
	   	   depth = 0;
	   		
		   return depth;
	   }
	 
	   if(val.compareTo(target) == 0)
	   {
		  // hold = depth;
		   //depth = 0;
		   return depth;
	   }
	   
	  
	   
	   //target > val
	   if(val.compareTo(target) < 0 && right == null) {
		   // depth++;
			//hold = depth;
		   
			//depth = 0;
		
		   
			return depth; 
		}
	//  target < val
		if(val.compareTo(target) > 0 && left == null) {
			//depth++;
			//val = this.left.val;
			//left = this.left.left;
			
			//hold = depth;
			
			//depth = 0;
			
			return depth;
		}
		
		if(left == null || right == null) {
			 //hold = depth;  
			// depth = 0;
			 
			 return depth;
		   }
		 
		 if (val.compareTo(target) < 0) {
			 depth++;
			 hold = depth;
			
			 return right.retrieveDepth(target);
		 }
		 
		 if (val.compareTo(target) > 0) {
			 depth++;
			 hold = depth;
			
			 return left.retrieveDepth(target);
		 }
		
	return retrieveDepth(target);
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
	   if(val == null) {
		   return null;
	   }
	   if(right == null) {
		   return val;
	   }
		
		//target < val
	   if(right.val.compareTo(val) > 0) {
			return right.getLargest();
			
		}
	return null;
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {
	   	if(val == null) 
	   	{
	   		return;
	   	}

	   	if(left!= null) 
	   	{
	   		left.inOrderTraversal(consume);
	   	}
	   	
	   	consume.accept(val);
	   	
	   	if(right != null)
	   	{
	   		right.inOrderTraversal(consume);
	   	}

	   	
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
	   if(that == null)
	   {
		   return false;
	   }
	   if(left == null && right == null && val == that.val) {
		   return true;
	   }
	   if(left!= null && val == that.val) {
		   return left.myEquals(that.left);
	   }
	   
	   if(right!= null && val == that.val) {
		   return right.myEquals(that.left);
	   }
	   
	return false;
   

   }
   

}
