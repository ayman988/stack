package datastructure.stack;

public class object {
 int value;
 int size;
 char c;
 float result;
 /**
  * set value onto the object
  * @param value
  *        the input value
  */
 public void setvalue(int value) {
	  this.value=value;
  }
 /**
  * set size of the stack
  * @param size
  *       size of the stack
  */
 public void setsize(int size) {
	  this.size=size;
  }
 /**
  * 
  * @return the value within a given object
  */
 public int getvalue() {
	  return value;
  }
 /**
  * 
  * @return the size of the stack
  */
 public int getsize() {
	  return size;
  }
 /**
  * set a char onto the object
  * @param a
  *    the input char
  */
 public void setchar(char a) {
	 c=a;
 }
 /**
  * 
  * @return the char within a given object
  */
 public char getchar() {
	 return c;
 }
/**
 * set the expression result onto the object
 * @param r
 *       the expression result
 */
 public void setresult(float r) {
	 result=r;
 }
 /**
  * 
  * @return the expression result
  */
 public float getresult() {
	 return result;
 }
 
}
