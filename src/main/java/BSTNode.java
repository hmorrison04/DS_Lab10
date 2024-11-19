import java.lang.Comparable;
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
	   
	   if(right == null && val.compareTo(target) < 0) 
	   {
		   BSTNode<T> a = new BSTNode<T>(target,null, null);
		   this.right = a;
	   }
	   if(left == null && val.compareTo(target) > 0) 
	   {
		   BSTNode<T> a = new BSTNode<T>(target,null, null);
		   this.left = a;
	   }
	   if(val.compareTo(target) < 0)
	   {
		  val = this.right.val;
		  right = this.right.right;
		  insert(target);
	   }
	   if(this.val.compareTo(target) > 0)
	   {
		   val = this.left.val;
		   left = this.left.left;
		   insert(target);
	   }
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
	    if(val.compareTo(target) == 0)
	    {
		    return target;
	    }
		if(right == null && left == null)
		{
			return null;
		}
		if(right.val.compareTo(target) > 0) {
			val = this.right.val;
			right = this.right.right;
			retrieve(target);
		}
		
		if(left.val.compareTo(target) > 0) {
			val = this.left.val;
			left = this.left.left;
			retrieve(target);
		}
		
	return retrieve(target);
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target)
   {
	  // int depth = 0;
	   if(val.compareTo(target) == 0)
	   {
		   return depth;
	   }
	   if (left == null && right == null)
	   {
		   return depth;
	   }
	   
	   if(val.compareTo(target) < 0)
	   {
		  depth++;
		  System.out.println(depth);
		  val = this.right.val;
		  right = this.right.right;
		  retrieveDepth(target);
		 
	   }
	   if(this.val.compareTo(target) > 0)
	   {
		   depth++;
		   val = this.left.val;
		   left = this.left.left;
		   retrieveDepth(target);
	   }
	return retrieveDepth(target);
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
	return null;
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {

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
	return false;
   

   }

}
