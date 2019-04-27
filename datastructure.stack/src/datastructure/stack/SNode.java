package datastructure.stack;

public class SNode {

 SNode previous;
 object oop;
 /**
  * constructor to set an object onto the Node
  * @param obj
  *        the input object
  */
public SNode(object obj)
 {
	
	oop=obj;
 }
/**
 * 
 * @return the object
 */
 public object getobject() {
	 return oop;
 }
/**
 * set previous of the last Node to the new Node
 * @param previous
 *          pointer to previous Node
 */
public	void setprevious (SNode previous) {
		this.previous=previous;
	}
/**
 * 
 * @return the previous Node
 */
public SNode getprevious() {
	return this.previous;
}
	/**
	 * set object onto the Node
	 * @param obj
	 *       the input object
	 */
public	void setobject(object obj) {
		 oop.value=obj.value;
		 oop.size=obj.size;
		 
	}
}
