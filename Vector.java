import java.util.*;

public class Vector {

	private Long sum;
	private Long mode;
	private Long median;
	private Long minimum;
	private Long maximum;

	private final int length;
	private final long[] elements;

	// ===========================================================================
	// INITIALIZATION
	// ===========================================================================

	/**
	 * Constructs new vector with the given
	 * length and all elements set to zero.
	 */
	public Vector(int length) {

		this.sum = null;
		this.mode = null;
		this.median = null;
		this.minimum = null;
		this.maximum = null;

		this.length = length;
		this.elements = new long[length];
	}

	/**
	 * Returns new vector with elements generated at random up to 100.
	 */
	public static Vector random(int length, int seed) {

		Vector vector = new Vector(length);
		Random random = new Random(seed);

		for (int i = 0; i <vector.length; i++) {
			vector.elements[i] = (long) random.nextInt(101);
		}

		return vector;
	}

	/**
	 * Returns new vector with all elements set to given value.
	 */
	
	public static Vector uniform(int length, long value) {
		Vector vector = new Vector (length);
		vector.sum = value;
		vector.mode = value;
		vector.median = value;
		vector.minimum = value;
		vector.maximum = value;

		for(int i=0; i<length; i++)
		{
			vector.elements[i] =  value;
		}



		/*
			to do

			length 1, value 1 => [1]
			length 2, value 2 => [2 2]
			length 3, value 3 => [3 3 3]
			length 4, value 4 => [4 4 4 4]
		*/

		return vector;
	}

	/**
	 * Returns new vector with elements in sequence from given start and step.
	 */
	public static Vector sequence(int length, long start, long step) {
		Vector sequence = new Vector (length);
		for (int i=0; i<length; i++)
		{
			sequence.elements[i]= start+step*i;
		}

		/*
			to do

			length 1, start 1, step 1  => [1]
			length 2, start 2, step 2  => [2 4]
			length 3, start 3, step 3  => [3 6 9]
			length 4, start 4, step 4  => [4 8 12 16]
			length 5, start 5, step -1 => [5 4 3 2 1]
		*/

		return sequence;
	}

	/**
	 * Returns whether the number is semiprime.
	 */
	public static boolean isPQ(long number) {
	if (number == 4 || number == 6 || number == 9 || number == 25) {
			return true;
		} else {
			for (int i = 2; i < (number/2) + 1; i++){
				if (isPrime(i) && number % i == 0 && isPrime(number/i)){
					return true;
				}
			}
		}
		return false;
	}
		/*
			to do
		*/

	

	/**
	 * Returns new vector with elements generated from the
	 * pq number sequence starting from the specified value.
	 */
	public static Vector pq(int length, long start) {
	Vector pq = new Vector(length);
		long number = start;
		int position = 0;
		
		while (position < length) {
			
			if (number == 0 && isPQ(start) == true) {
				pq.elements[0] = start;
				number++;
				position ++;
				
			}else if (isPQ(number) == true) {
				pq.elements[position] = number;
				number++;
				position++;
				
			} else if (isPQ(number) == false) {
				number++;
				
			}
			
		}
		return pq;
	}
		/*
			to do

			length 4, start 1  => [4 6 9 10]
			length 4, start 4  => [4 6 9 10]
			length 4, start -1 => [4 6 9 10]
			length 4, start 42 => [46 49 51 55]
		*/

		

	/**
	 * Returns whether the number is prime.
	 */
	public static boolean isPrime(long number) {
	if (number < 2) {
			return false;
		} else if (number == 2 || number == 3 || number == 5 || number == 7 ||
		number == 11 || number == 13) {
			return true;
		} else if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0 ||
		number % 7 == 0 || number % 11 == 0 || number % 13 == 0) {
			return false;
		}
		long sqrtNumber = (long)Math.sqrt(number) + 1;
		for (long i = 6l; i <= sqrtNumber; i += 6) {
			if (number % (i - 1) == 0 || number % (i + 1) == 0) {
				return false;
			}
		}
	
		/*
			to do
		*/

		return true;
	}

	/**
	 * Returns new vector with elements generated from the
	 * prime number sequence starting from the specified value.
	 */
	public static Vector prime(int length, long start) {
		Vector prime = new Vector(length);
		int counter = 0;
		while (counter < prime.length)
		{
			if(isPrime(start))
			{
				prime.elements[counter] = start;
				if (counter==length/2)
				{
					prime.median = start;
				}
				counter++;
			}
			start ++;
		}
		/*
			to do

			length 4, start 1  => [2 3 5 7]
			length 4, start 2  => [2 3 5 7]
			length 4, start -1 => [2 3 5 7]
			length 4, start 42 => [43 47 53 59]
		*/

		return prime;
	}

	/**
	 * Returns whether the number is abundant.
	 */
	public static boolean isAbundant(long number) {
	 long sum = 0;
		long divisorNum = 0;
		long integer = 2;
		boolean isAbundant = true;
		for (int i = 1; i <= number; i++) {
			if (number%i == 0) {
				sum += i;
			}
			divisorNum = integer * number;
			if (sum < divisorNum) {
				isAbundant = false;
			} else if (sum == divisorNum) {
				isAbundant = false;
			} else if (sum > divisorNum) {
				isAbundant = true;
			}
		}
		return isAbundant;
		/*
			to do
		*/

		
	}

	/**
	 * Returns new vector with elements generated from the
	 * abundant number sequence starting from the specified value.
	 */
	public static Vector abundant(int length, long start) {
		Vector abundant = new Vector(length);
		if (start < 12) {
			start = 12;
		}
		long number = start;
		int position = 0;
		while (position < length) {
			if (isAbundant(number) == true) {
				abundant.elements[position] = number;
				number++;
				position++;
			} else if (isAbundant(number) == false) {
				number++;
			}
		}
		/*
			to do

			length 4, start 0  => [12 18 20 24]
			length 4, start 12 => [12 18 20 24]
			length 4, start -1 => [12 18 20 24]
			length 4, start 42 => [42 48 54 56]
		*/

		return abundant;
	}

	/**
	 * Returns whether the number is composite.
	 */
	public static boolean isComposite(long number) {
	if (isPrime(number) == true) {
			return false;
		} else {
		}
		return true;
	}
		/*
			to do
		*/

	

	/**
	 * Returns new vector with elements generated from the
	 * composite number sequence starting from the specified value.
	 */
	public static Vector composite(int length, long start) {
	Vector composite = new Vector(length);
		if (start < 2) {
			start = 2;
		}
		long number = start;
		int position = 0;
		while (position < length) {
			if (isComposite(number) == true) {
				composite.elements[position] = number;
				number++;
				position++;
			} else if (isComposite(number) == false) {
				number++;
			}
		}
		/*
			to do

			length 4, start 0  => [4 6 8 9]
			length 4, start 4  => [4 6 8 9]
			length 4, start -1 => [4 6 8 9]
			length 4, start 42 => [42 44 45 46]
		*/

		return composite;
	}

	// ===========================================================================
	// VECTOR OPERATIONS
	// ===========================================================================

	/**
	 * Returns new vector that is a copy of the current vector.
	 */
	public Vector cloned() {
	 Vector clone = new Vector (length);
		for(int i = 0; i<length; i++)
		{
			clone.elements[i]=this.elements[i];
		}
		/*
			to do

			[1 1 1 1] => [1 1 1 1]
			[1 2 3 4] => [1 2 3 4]
			[4 3 2 1] => [4 3 2 1]
		*/

		return clone;
		

		
	}

	/**
	 * Returns new vector with elements ordered from smallest to largest.
	 */
	public Vector sorted() { 
		Vector sorted = new Vector (length);
		
		for(int i = 0; i<sorted.length; i++)
		{
			
			sorted.elements[i]=this.elements[i];
		}
		Arrays.parallelSort(sorted.elements);
		/*
			to do

			[1 1 1 1] => [1 1 1 1]
			[1 2 3 4] => [1 2 3 4]
			[4 3 2 1] => [1 2 3 4]
		*/

		return sorted;
	}

	/**
	 * Returns new vector with elements ordered in reverse.
	 */
	public Vector reversed() {
		Vector reversed = new Vector(length);
		for(int i = 0; i < length / 2; i++)
    {
    
    reversed.elements[i] = this.elements[length - i - 1];
    reversed.elements[length - i - 1] = this.elements[i];
    }

		/*
			to do

			[1 1 1 1] => [1 1 1 1]
			[1 2 3 4] => [4 3 2 1]
			[4 3 2 1] => [1 2 3 4]
		*/

		return reversed;
	}

	/**
	 * Returns new vector with elements shifted right by a given number of positions.
	 */
	public Vector shifted(long amount) {
	Vector shifted = this.cloned();
		
		
		long[] temp = new long[length];
		for (int i = 0; i<length; i++)
		{
			if((i-(int)amount)<0)
			{
				temp[i] = shifted.elements[length +(i - (int)amount)];
			}
			else 
			{
				temp[i] = shifted.elements[(i-(int)amount)];
			}
		}
		for (int i = 0; i<temp.length; i++)
		{
			shifted.elements[i] = temp[i];
		}
	
		/*
			to do

			[1 2 3 4] 0 => [1 2 3 4]
			[1 2 3 4] 1 => [4 1 2 3]
			[1 2 3 4] 2 => [3 4 1 2]
			[1 2 3 4] 3 => [2 3 4 1]
			[1 2 3 4] 4 => [1 2 3 4]
			[1 2 3 4] 5 => [4 1 2 3]
		*/

		return shifted;
	}

	/**
	 * Returns new vector, adding scalar to each element.
	 */
	public Vector scalarAdd(long scalar) {
	Vector scalarAdd = new Vector(length);
		for(int i = 0; i<length; i++)
			{
				scalarAdd.elements[i] = this.elements[i]+scalar;
			}
		/*
			to do

			[1 1 1 1] + 1  => [2 2 2 2]
			[1 2 3 4] + 4  => [5 6 7 8]
			[2 2 2 2] + -1 => [1 1 1 1]
		*/

		return scalarAdd;
	}

	/**
	 * Returns new vector, multiplying scalar to each element.
	 */
	public Vector scalarMultiply(long scalar) {
	 Vector scalarMultiply = new Vector(length);
		for (int i = 0; i<length; i++)
		{
			scalarMultiply.elements[i] = this.elements[i]*scalar;
		}
		/*
			to do

			[1 2 3 4] x 0  => [0 0 0 0]
			[1 2 3 4] x 1  => [1 2 3 4]
			[1 2 3 4] x 2  => [2 4 6 8]
			[1 2 3 4] x 10 => [10 20 30 40]
			[1 2 3 4] x -1 => [-1 -2 -3 -4]
		*/

		return scalarMultiply;
	}

	/**
	 * Returns new vector, adding elements with the same index.
	 */
	public Vector vectorAdd(Vector other) {
	 Vector vectorAdd = new Vector(length);
		for (int i = 0; i<length; i++)
		{
			vectorAdd.elements[i] = this.elements[i]+other.elements[i];
		}
		/*
			to do

			[1 2 3 4] + [0 0 0 0]     => [1 2 3 4]
			[1 2 3 4] + [4 4 4 4]     => [5 6 7 8]
			[1 2 3 4] + [1 2 3 4]     => [2 4 6 8]
			[2 2 2 2] + [-1 -1 -1 -1] => [1 1 1 1]
		*/

		return vectorAdd;
	}

	/**
	 * Returns new vector, multiplying elements with the same index.
	 */
	public Vector vectorMultiply(Vector other) {
	Vector vectorMultiply = new Vector(length);
		for(int i = 0; i<length; i++)
		{
			vectorMultiply.elements[i]=this.elements[i]*other.elements[i];
		}
		/*
			to do

			[1 2 3 4] x [0 0 0 0]     => [0 0 0 0]
			[1 2 3 4] x [1 1 1 1]     => [1 2 3 4]
			[1 2 3 4] x [1 2 3 4]     => [1 4 9 16]
			[2 2 2 2] x [-1 -1 -1 -1] => [-2 -2 -2 -2]
		*/

		return vectorMultiply;
	}

	// ===========================================================================
	// VECTOR COMPUTATIONS
	// ===========================================================================

	/**
	 * Returns the sum of all elements.
	 */
	public Long getSum() {
		
	
		Long ans = 0L;
		for(int i = 0; i < length; i++)
		{
			ans += this.elements[i];
		}
			this.sum= ans;
		/*
			to do

			[0 0 0 0] => 0
			[1 1 1 1] => 4
			[1 2 3 4] => 10
		*/

		// Calculate and store the sum when unknown
		if (this.sum == null) {

			// to do

		}

		return this.sum;
	}

	/**
	 * Returns the most frequently occuring element
	 * or -1 if there is no such unique element.
	 */
	public Long getMode() {
	Map<Long, Integer> seen = new HashMap<Long, Integer>();
		int max = 0;
		long mode = 0;
		boolean multiple = false;
		for(Long value: this.elements)
		{
			if(seen.containsKey(value))
			{
			seen.put(value, seen.get(value) + 1);	
			}
			else
			{
			seen.put(value, 1);	
			}
			if (seen.get(value) > max)
			{
				max = seen.get(value);
				mode = value;
				multiple = false;
			}else if (seen.get(value)== max)
			{
				multiple = true;
			}
		}
		if(!multiple)
		{
			this.mode = mode;
		}
		else {
			this.mode = -1L;
		}
	
		
		/*
			to do

			[1]       => 1
			[2 2]     => 2
			[2 4 4]   => 4
			[1 2 3 4] => -1
		*/

		return this.mode;
	}

	/**
	 * Returns the upper median.
	 */
	public Long getMedian() {
	
		Arrays.sort(this.elements);
		
	 int middleSlot = length/2;
this.median = this.elements[middleSlot];
		/*
			to do

			[1] => 1
			[1 2] => 2
			[1 2 3] => 2
			[1 1 1 1] => 1
		*/

		return this.median;
	}

	/**
	 * Returns the smallest value in the vector.
	 */
	public Long getMinimum() {
		Long minimum =  this.elements[0];
		if (this.elements == null || length < 1)
	        return minimum;
	    
	  

	    for (int i = 1; i <= length - 1; i++) {
	       

	        if (minimum > this.elements[i]) {
	            minimum =  this.elements[i];
				
	        }
	    }
		this.minimum=minimum;
		/*
			to do

			[1 1 1 1] => 1
			[1 2 3 4] => 1
			[4 3 2 1] => 1
		*/

		return this.minimum;
	}

	/**
	 * Returns the largest value in the vector.
	 */
	public Long getMaximum() {
	Long maximum =  this.elements[0];
		if (this.elements == null || length < 1)
	        return maximum;
	    
	  

	    for (int i = 1; i <= length - 1; i++) {
	       

	        if (maximum < this.elements[i]) {
	            maximum =  this.elements[i];
				
	        }
	    }
		this.maximum=maximum;
		/*
			to do

			[1 1 1 1] => 1
			[1 2 3 4] => 4
			[4 3 2 1] => 4
		*/

		return this.maximum;
	}

	/**
	 * Returns the frequency of the value in the vector.
	 */
	public long getFrequency(long value) {
	long count = 0;
		for(int i = 0; i < length; i++)
		{
			if (value == this.elements[i])
			{
				count++;
			}
		}
		return count;
		/*
			to do

			[1 2 3 4] 0 => 0
			[1 2 3 4] 1 => 1
			[1 1 1 1] 1 => 4
		*/

	}

	// ===========================================================================
	// DISPLAY OPERATIONS
	// ===========================================================================

	/**
	 * Displays the vector.
	 */
	public void display() {
		
		for (int i=0; i<length; i++)
		{
			
			if (i + 1 == length) {
                // print ==> println
                System.out.print(this.elements[i]);
            } else {
                System.out.print(this.elements[i] + " ");
				
            }
			

		}
		System.out.println("");
		/*
			to do

			Display each element in the vector seperated by a space.
		*/
	}

	/**
	 * Displays the element at the specified index.
	 */
	public void displayElement(int index) {
		
		System.out.println(this.elements[index]);
		/*
			to do

			Display the element at the given index.
		*/
	}

	// ===========================================================================
	// ACCESSOR METHODS
	// ===========================================================================

	/**
	 * Returns the vector length.
	 */
	public int getLength() {

		return this.length;
	}

	/**
	 * Returns the vector elements.
	 */
	public long[] getElements() {

		return this.elements;
	}
}
